/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbc.domain.HubSlickContent;
import com.cbc.domain.MediaContentTuple;
import com.cbc.model.CbcNew;
import com.cbc.model.Channel;
import com.cbc.model.Episode;
import com.cbc.model.EpisodesAdDiv;
import com.cbc.model.HubSlick;
import com.cbc.model.Program;
import com.cbc.model.ProgramPromo;
import com.cbc.model.ProgramScene;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.EpisodeRepository;
import com.cbc.repository.HubSlickRepository;
import com.cbc.repository.ProgramNewsRepository;
import com.cbc.repository.ProgramPromosRepository;
import com.cbc.repository.ProgramRepository;
import com.cbc.repository.ProgramSceneRepository;
import com.cbc.util.Constants.MostViewedType;

/**
 * @author Mina Saleeb
 *
 */
@Service
@Transactional
public class ProgramsService 
{

	private static final Logger LOGGER = Logger.getLogger(ProgramsService.class);
	
	@Autowired
	private ProgramRepository programRepository;
	
	@Autowired
	private ChannelRepository channelRepository;
	
	@Autowired
	private ProgramNewsRepository programNewsRepo;
	
	@Autowired
	private ProgramSceneRepository ProgramSceneRepo;
	
	@Autowired
	private EpisodeRepository EpisodeRepo;
	
	@Autowired
	private HubSlickRepository hubSlickRepo;
	
	@Autowired
	private ProgramPromosRepository programPromosRepo;
	
	
	
	/**
	 * 
	 * @param channelId
	 * @return
	 * @throws Exception
	 */
	public List<Program> retrieveProgramsByChannel(int channelId) throws Exception
	{
		List<Program> programsList = new ArrayList<Program>();
		Channel channel = channelRepository.findOne(channelId);
		if(channel != null)
		{
			programsList = programRepository.findByChannelBean(channel);
		}
		else
		{
			LOGGER.error("channelId {"+channelId+"} is not found in DB");
			throw new Exception("channelId {"+channelId+"} is not found in DB");
		}
		
		return programsList;
	}
	
	/**
	 * 
	 * @param programId
	 * @return
	 * @throws Exception
	 */
	public Program retrieveProgramById(int programId) throws Exception
	{
		Program prgm = programRepository.findOne(programId);
		if(prgm == null)
		{
			LOGGER.error("programId {"+programId+"} is not found in DB");
			throw new Exception("programId {"+programId+"} is not found in DB");
		}
		
		return prgm;
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	public List<String> getProgramsNamesByChannelId(int channelId)
	{
		List<String> programsNamesList = new ArrayList<String>();
		
		try 
		{
			List<Program> prgms = retrieveProgramsByChannel(channelId);
			if(prgms != null && !prgms.isEmpty())
			{
				for(Program prgm : prgms)
				{
					programsNamesList.add(prgm.getTitle());
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return programsNamesList;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Program> listAllPrograms()
	{
		return (List<Program>) programRepository.findAll();
	}
	
	/**
	 * 
	 * @param programId
	 * @return
	 */
	public List<CbcNew> getProgramNewsByProgramId(int programId)
	{
		return programNewsRepo.findByProgramId(programId);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<MediaContentTuple> getMostViewedList(int size)
	{
		List<MediaContentTuple> resultList = new ArrayList<MediaContentTuple>();
		Pageable pageSize = new PageRequest(0, size > 2 ?size-2:size == 2? 2 :1);
		List<Episode> episodes = EpisodeRepo.findRandomEpisodes(pageSize);
		List<ProgramScene> imagesOrVedios = null;
		if(size > 2)
		{
			pageSize = new PageRequest(0, 2);
			imagesOrVedios = ProgramSceneRepo.findRandomProgramScene(pageSize);
		}
		
		return mapEpisodesAndImagesToTuple(episodes, imagesOrVedios, null);
		/*
		if(episodes != null && !episodes.isEmpty())
		{
			for(Episode e : episodes)
			{
				MostViewed mv = new MostViewed(e.getUrl());
				mv.setId(e.getId());
				mv.setTitle(e.getTitle());
				mv.setDescription(e.getProgramBean().getDescription());
				mv.setType(MostViewedType.VEDIO);
				mv.setIconImage(e.getPhotoPath());
				resultList.add(mv);
			}
		}
		
		if(imagesOrVedios != null && !imagesOrVedios.isEmpty())
		{
			for(ProgramScene p : imagesOrVedios)
			{
				String  url = "";
				MostViewedType type = null;
				if(p.getPhotoPath() != null && !p.getPhotoPath().isEmpty())
				{
					url = p.getPhotoPath();
					type = MostViewedType.IMAGE;
				}
				if(p.getVedioUrl() != null && !p.getVedioUrl().isEmpty())
				{
					url = p.getVedioUrl();
					type = MostViewedType.VEDIO;
				}
				MostViewed mv = new MostViewed(url);
				mv.setId(p.getId());
				mv.setTitle(p.getTitle());
				mv.setDescription(p.getDescription());
				mv.setType(type);
				mv.setIconImage(p.getProgramBean().getImageXPath());
				resultList.add(mv);
			}
		}
		
		
		return resultList;
		*/
	}
	
	/**
	 * 
	 * @return
	 */
	public List<MediaContentTuple> getHubSelectedTuples()
	{
		
		
		List<Episode> hubSelectedVedios = EpisodeRepo.findByHubSelected(true);
		List<ProgramScene> hubSelectedImages = ProgramSceneRepo.findByHubSelected(true);
		
	 	return mapEpisodesAndImagesToTuple(hubSelectedVedios , hubSelectedImages, null);
	}
	
	/**
	 * 
	 * @param hubSelectedVedios
	 * @param hubSelectedImages
	 */
	private List<MediaContentTuple> mapEpisodesAndImagesToTuple(List<Episode> hubSelectedVedios, List<ProgramScene> hubSelectedImages, List<Program> hubSelectedPrograms)
	{
		List<MediaContentTuple> tuplesList = new ArrayList<MediaContentTuple>();
		
		if(hubSelectedVedios != null && !hubSelectedVedios.isEmpty())
		{
			for(Episode e : hubSelectedVedios)
			{
				MediaContentTuple tuple = new MediaContentTuple();
				tuple.setMediaType(MostViewedType.VEDIO);
				tuple.setUrl(e.getUrl());
				Program p = e.getProgramBean();
				tuple.setProgramName(p.getTitle());
				tuple.setProgramImage(e.getPhotoPath());// here will be the eposide image
				tuple.setProgramId(p.getId());
				tuplesList.add(tuple);
			}
		}
		
		if(hubSelectedPrograms != null && !hubSelectedPrograms.isEmpty())
		{
			for(Program p : hubSelectedPrograms)
			{
				MediaContentTuple tuple = new MediaContentTuple();
				tuple.setMediaType(MostViewedType.PROGRAM);
				tuple.setProgramName(p.getTitle());
				tuple.setProgramImage(p.getImageXPath());
				tuple.setProgramId(p.getId());
				tuplesList.add(tuple);
			}
		}
		
		if(hubSelectedImages != null && !hubSelectedImages.isEmpty())
		{
			for(ProgramScene ps : hubSelectedImages)
			{
				MediaContentTuple tuple = new MediaContentTuple();
				if(ps.getPhotoPath() != null)
				{
					tuple.setMediaType(MostViewedType.IMAGE);
					tuple.setUrl(ps.getPhotoPath());
				}
				else if(ps.getVedioUrl() != null)
				{
					tuple.setMediaType(MostViewedType.VEDIO);
					tuple.setUrl(ps.getVedioUrl());
				}
				Program p = ps.getProgramBean();
				tuple.setProgramName(p.getTitle());
				tuple.setProgramImage(p.getImageXPath());
				tuple.setProgramId(p.getId());
				tuplesList.add(tuple);
			}
		}
		
		return tuplesList;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<HubSlickContent> getHubSlicks()
	{
		List<HubSlickContent> hubSlicksList = new ArrayList<HubSlickContent>();
		
		List<HubSlick> slicks = (List<HubSlick>) hubSlickRepo.findAll();
		
		if(slicks != null  && !slicks.isEmpty())
		{
			for(HubSlick s : slicks)
			{
				hubSlicksList.add(new HubSlickContent(s.getTitle() ,mapEpisodesAndImagesToTuple(s.getEpisodes(), s.getProgramScenes() , s.getPrograms())));
			}
		}
		
		return hubSlicksList;
	}
	
	/**
	 * 
	 * @param programId
	 * @return
	 */
	public List<Episode> getProgramEpisodesById(int programId)
	{
		return EpisodeRepo.findByProgramId(programId);
	}
	
	public List<ProgramScene> getProgramGalleryById(int programId)
	{
		return ProgramSceneRepo.findByProgramId(programId);
	}
	
	public List<ProgramPromo> getProgramPromosById(int programId)
	{
		return programPromosRepo.findByProgramId(programId);
	}
	
	/**
	 * 
	 * @param eposideId
	 * @return
	 */
	public Map<String , String> getEposideAds(long eposideId)
	{
		Map<String , String> eposideAdsmap = new HashMap<String , String>();
		
		Episode e = EpisodeRepo.findOne(eposideId);
		
		if(e == null)
		 {
			 LOGGER.error("eposideId {"+eposideId+"} is not found in DB");
		 }
		 else
		 {
			 List<EpisodesAdDiv> eAds = e.getEpisodesAdDivs();
			 if(eAds != null && !eAds.isEmpty())
			 {
				 for(EpisodesAdDiv ad :eAds)
				 {
					 eposideAdsmap.put(ad.getAdDiv().getDivCode(), ad.getAdScript());
				 }
			 }
		 }
		return eposideAdsmap;
	}
}
