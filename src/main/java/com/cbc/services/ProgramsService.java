/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cbc.domain.MostViewed;
import com.cbc.model.CbcNew;
import com.cbc.model.Channel;
import com.cbc.model.Episode;
import com.cbc.model.Program;
import com.cbc.model.ProgramScene;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.EpisodeRepository;
import com.cbc.repository.ProgramNewsRepository;
import com.cbc.repository.ProgramRepository;
import com.cbc.repository.ProgramSceneRepository;
import com.cbc.util.Constants.MostViewedType;

/**
 * @author Mina Saleeb
 *
 */
@Service
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
	public List<MostViewed> getMostViewedList(int size)
	{
		List<MostViewed> resultList = new ArrayList<MostViewed>();
		Pageable pageSize = new PageRequest(0, size%2);
		List<Episode> episodes = EpisodeRepo.findRandomEpisodes(pageSize);
		pageSize = new PageRequest(0, size - size%2);
		List<ProgramScene> imagesOrVedios = ProgramSceneRepo.findRandomProgramScene(pageSize);
		
		if(episodes != null && !episodes.isEmpty())
		{
			for(Episode e : episodes)
			{
				MostViewed mv = new MostViewed(e.getUrl());
				mv.setTitle(e.getTitle());
				mv.setDescription(e.getProgramBean().getDescription());
				mv.setType(MostViewedType.VEDIO);
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
				mv.setTitle(p.getTitle());
				mv.setDescription(p.getDescription());
				mv.setType(type);
				resultList.add(mv);
			}
		}
		
		
		return resultList;
	}
}
