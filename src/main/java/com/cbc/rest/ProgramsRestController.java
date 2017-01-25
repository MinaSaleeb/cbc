/**
 * 
 */
package com.cbc.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.domain.HubSlickContent;
import com.cbc.domain.MediaContentTuple;
import com.cbc.model.Channel;
import com.cbc.model.Program;
import com.cbc.model.ProgramPagesAdDiv;
import com.cbc.model.ProgramsAdDiv;
import com.cbc.repository.ProgramPageRepository;
import com.cbc.repository.ProgramPagesAdDivRepository;
import com.cbc.services.AdDivsPropagationService;
import com.cbc.services.ProgramsService;
import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/program")
@Transactional
public class ProgramsRestController 
{
	private static final Logger LOGGER = Logger.getLogger(ProgramsRestController.class);
	
	@Autowired
	private ProgramsService programsService;
	
	@Autowired
	private ProgramPageRepository programPageRepo;
	
	@Autowired
	private ProgramPagesAdDivRepository programPagesAdDivRepo;
	
	@Autowired
	private AdDivsPropagationService adDivsPropagationService;
	
	
	
	 @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.Program>> listPrograms()
	 {
		 List<Program> allPrgms = programsService.listAllPrograms();
		 
		 if(allPrgms == null || allPrgms.isEmpty())
		 {
			 LOGGER.error("No Programs in DB");
			 return new ResponseEntity<List<com.cbc.domain.Program>>(HttpStatus.NO_CONTENT);
		 }
		  
		 return new ResponseEntity<List<com.cbc.domain.Program>>(ModelToDomainMapper.mapProgramsList(allPrgms) , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.Program>> searchPrograms(@RequestParam(required = false , value = "channelId") Integer channelId,
			 															@RequestParam(required = false , value = "onAir") Boolean onAir,
			 															@RequestParam(required = false , value = "type") String type,
				 														@RequestParam(required = false , value = "excludedPrgm") int[] excludedProgramsIds)
	 {
		 List<Program> prgrms = new ArrayList<Program>();
		 boolean isByTypeOnly = false;
		 
		 if(channelId == null && onAir == null)
		 {
			 isByTypeOnly = true;
		 }
		 
		 if(channelId == null && onAir == null && type == null)
		 {
			 prgrms = programsService.listAllPrograms();
		 }
		 else if(channelId != null && onAir != null && type != null)
		 {
			 prgrms = programsService.findByChannelIdAndOnAirAndType(channelId, onAir, type);
		 }
		 else if(channelId != null && type != null)
		 {
			 prgrms = programsService.findByChannelIdAndType(channelId, type);
		 }
		 else if(onAir != null && type != null)
		 {
			 prgrms = programsService.findByOnAirAndType(onAir, type);
		 }
		 else if(channelId != null && onAir != null)
		 {
			 prgrms = programsService.findByChannelIdAndOnAir(channelId, onAir);
		 }
		 else if(channelId != null)
		 {
			 prgrms = programsService.findByChannelId(channelId);
		 }
		 else if(onAir != null)
		 {
			 prgrms = programsService.findByOnAir(onAir);
		 }
		 else if(isByTypeOnly)
		 {
			 prgrms = programsService.findByType(type);
		 }
		 
		 if(excludedProgramsIds != null && excludedProgramsIds.length > 0)
		 {
			 for(int id : excludedProgramsIds)
			 {
				 if(prgrms != null && prgrms.size() > 0)
				 { 
					 for(int i = 0; i < prgrms.size() ; i++)
					 {
						 Program prgm = prgrms.get(i);
						 if(id == prgm.getId())
						 {
							 prgrms.remove(i);
							 break;
						 }
					 }
				 }
			 }
		 }
		 
		 return new ResponseEntity<List<com.cbc.domain.Program>>(ModelToDomainMapper.mapProgramsList(prgrms)  , HttpStatus.OK);
	 }
	 
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	 @RequestMapping(value = "/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.Program>> getByChannelId(@RequestParam(required = true , value = "channelId") int channelId,
			 											 @RequestParam(required = false , value = "excludedPrgm") int[] excludedProgramsIds
			 											)
	 {
		 List<Program> prgrms = new ArrayList<Program>();
		 try 
		 {
			
			prgrms = programsService.retrieveProgramsByChannel(channelId);
		 } 
		 catch (Exception e) 
		 {
			LOGGER.error("Error in retrieving programs list by channelId {"+channelId+"}");
			e.printStackTrace();
			return new ResponseEntity<List<com.cbc.domain.Program>>(HttpStatus.NOT_FOUND);
		}
		 
		 if(excludedProgramsIds != null && excludedProgramsIds.length > 0)
		 {
			 for(int id : excludedProgramsIds)
			 {
				 for(int i = 0; i < prgrms.size() ; i++)
				 {
					 Program prgm = prgrms.get(i);
					 if(id == prgm.getId())
					 {
						 prgrms.remove(i);
						 break;
					 }
				 }
			 }
		 }
		 
		 return new ResponseEntity<List<com.cbc.domain.Program>>(ModelToDomainMapper.mapProgramsList(prgrms)  , HttpStatus.OK);
	 }
	 
	 /**
	  * 
	  * @param programId
	  * @return
	  */
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<com.cbc.domain.Program> getProgramById(@PathVariable("id") int programId)
	 {
		 Program prgrm = null;
		 try 
		 {
			
			 prgrm = programsService.retrieveProgramById(programId);
		 } 
		 catch (Exception e) 
		 {
			LOGGER.error("Error in retrieving program by programId {"+programId+"}");
			e.printStackTrace();
			return new ResponseEntity<com.cbc.domain.Program>(HttpStatus.NOT_FOUND);
		}
		
		 return new ResponseEntity<com.cbc.domain.Program>(new com.cbc.domain.Program(prgrm) , HttpStatus.OK);
	 }
	 
	 /**
	  * 
	  * 
	  * @param programId
	  * @return
	  */
	 @RequestMapping(value = "/{id}/ads", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Map<String , String>> getProgramAdsScripts(@PathVariable("id") int programId)
	 {
		 Program prgrm = null;
		 Map<String , String> programAdsmap = new HashMap<String , String>();
		 try 
		 {
			
			 prgrm = programsService.retrieveProgramById(programId);
		 } 
		 catch (Exception e) 
		 {
			LOGGER.error("Error in retrieving program by programId {"+programId+"}");
			e.printStackTrace();
			return new ResponseEntity<Map<String , String>>(HttpStatus.NOT_FOUND);
		 }
		 
			List<ProgramsAdDiv> programAds = prgrm.getProgramsAdDivs();
			List<Channel> prgmChannels = prgrm.getChannels();
			Set<String> checkedDivCodes = adDivsPropagationService.getAdDivsCodes();
			
			if(programAds != null && !programAds.isEmpty())
			{
				for(ProgramsAdDiv ad : programAds)
				{
					programAdsmap.put(ad.getAdDiv().getDivCode(), ad.getAdScript());
				}
			}
			
			if(prgmChannels != null && !prgmChannels.isEmpty())
			{
				for(Channel c : prgmChannels)
				{
					if(c.getChannelsAdDivs() != null && !c.getChannelsAdDivs().isEmpty())
					{
						adDivsPropagationService.checkMissingChnlAdDivsFromTree(c.getChannelsAdDivs(),programAdsmap,checkedDivCodes);
						break;
					}
				}
			}
		 
		 return new ResponseEntity<Map<String , String>>(programAdsmap , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/{id}/episodes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.Episode>> getProgramEpisodes(@PathVariable("id") int programId)
	 {
		 return new ResponseEntity<List<com.cbc.domain.Episode>>(ModelToDomainMapper.mapEpisodesList(programsService.getProgramEpisodesById(programId)) , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/{id}/gallery", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.ProgramScene>> getProgramGallery(@PathVariable("id") int programId)
	 {
		 return new ResponseEntity<List<com.cbc.domain.ProgramScene>>(ModelToDomainMapper.mapProgramSceneList(programsService.getProgramGalleryById(programId)) , HttpStatus.OK);
	 }
	 
	 /**
	  * 
	  * @param pageCode
	  * @return
	 * @throws Exception 
	  */
	 @RequestMapping(value = "/{programId}/page/{pageCode}/ads", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Map<String , String>> getPageAdsScripts(@PathVariable("programId") int programId ,@PathVariable("pageCode") String pageCode) throws Exception
	 {
		 Map<String , String> pageAdsmap = new HashMap<String , String>();
		 
			List<ProgramPagesAdDiv> pageAds = programPagesAdDivRepo.findByPrmIdAndPageCode(programId, pageCode);
			Program pageProgram = programsService.retrieveProgramById(programId);
			List<Channel> programChannels = pageProgram != null? pageProgram.getChannels():null;
			List<ProgramsAdDiv> programAds = pageProgram != null?pageProgram.getProgramsAdDivs():null;
			Set<String> checkedDivCodes = adDivsPropagationService.getAdDivsCodes();
			
			// Implement ads inheratance tree page -> program -> channel
			if(pageAds != null && !pageAds.isEmpty())
			{
				for(ProgramPagesAdDiv ad : pageAds) // page ads
				{
					pageAdsmap.put(ad.getAdDiv().getDivCode(), ad.getAdScript());
				}
			}
			
			if(programAds != null && !programAds.isEmpty())
			{
				// program ads
				adDivsPropagationService.checkMissingPrgmAdDivsFromTree(programAds, pageAdsmap, checkedDivCodes);
			}
			
			if(programChannels != null && !programChannels.isEmpty())
			{
				for(Channel c : programChannels)
				{
					if(c.getChannelsAdDivs() != null && !c.getChannelsAdDivs().isEmpty())
					{
						adDivsPropagationService.checkMissingChnlAdDivsFromTree(c.getChannelsAdDivs(),pageAdsmap,checkedDivCodes);
						break;
					}
				}
			}
			
		 
		 return new ResponseEntity<Map<String , String>>(pageAdsmap , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/eposide/{id}/ads", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Map<String , String>> getEposideAdsScripts(@PathVariable("id") long id)
	 {
		 return new ResponseEntity<Map<String,String>>(programsService.getEposideAds(id) , HttpStatus.OK);
	 }
	 
	 /**
	  * 
	  * @param channelId
	  * @return
	  */
	 @RequestMapping(value = "/names/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<String>> getProgramsNamesByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		 return new ResponseEntity<List<String>>(programsService.getProgramsNamesByChannelId(channelId) , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/{id}/news", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.CbcNew>> getProgramNews(@PathVariable("id") int programId)
	 {
		 return new ResponseEntity<List<com.cbc.domain.CbcNew>>(ModelToDomainMapper.mapCbcNewsList(programsService.getProgramNewsByProgramId(programId)), HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/{id}/promos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.ProgramPromo>> getProgramPromos(@PathVariable("id") int programId)
	 {
		 return new ResponseEntity<List<com.cbc.domain.ProgramPromo>>(ModelToDomainMapper.mapProgramPromoList(programsService.getProgramPromosById(programId)), HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/{id}/tabs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.ProgramTab>> getProgramTabs(@PathVariable("id") int programId)
	 {
		 return new ResponseEntity<List<com.cbc.domain.ProgramTab>>(ModelToDomainMapper.mapProgramTabsList(programsService.getProgramTabsById(programId)), HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/{id}/widgets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.Widget>> getProgramWidgets(@PathVariable("id") int programId) throws Exception
	 {
		 return new ResponseEntity<List<com.cbc.domain.Widget>>(ModelToDomainMapper.mapWidgetsList(programsService.findProgramWidgets(programId), false), HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/mostViewed", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<MediaContentTuple>> getMostViewed(@RequestParam(required = true , value = "size") int size, @RequestParam(required = false , value = "channelId") Integer channelId)
	 {
		 if(channelId == null)
		 {
			 channelId = 0;
		 }
		 return new ResponseEntity<List<MediaContentTuple>>(programsService.getMostViewedListV2(size, channelId) , HttpStatus.OK);
	 }
	 
	 
	 @RequestMapping(value = "/hub/selected", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<MediaContentTuple>> getHubSelectedTuples()
	 {
		 return new ResponseEntity<List<MediaContentTuple>>(programsService.getHubSelectedTuples() , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/hub/slicks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<HubSlickContent>> getHubSlicks()
	 {
		 return new ResponseEntity<List<HubSlickContent>>(programsService.getHubSlicks() , HttpStatus.OK);
	 }
	 
}
