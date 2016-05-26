/**
 * 
 */
package com.cbc.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.Presenter;
import com.cbc.services.PresentersService;

/**
 * @author Mina Saleeb
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/presenter")
public class PresentersRestController 
{
	private static final Logger LOGGER = Logger.getLogger(PresentersRestController.class);
	
	@Autowired
	private PresentersService  presentersService;
	
	/**
	 * 
	 * @param presenterId
	 * @return
	 */
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<com.cbc.domain.Presenter> getPresenterById(@PathVariable("id") int presenterId)
	 {
		 Presenter presenter = presentersService.getPresenterById(presenterId);
		
		if(presenter == null)
		{
			LOGGER.error("presenterId {"+presenterId+"} is not found in DB");
			return new ResponseEntity<com.cbc.domain.Presenter>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<com.cbc.domain.Presenter>(new com.cbc.domain.Presenter(presenter) , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/names/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<String>> getPresentersNamesByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		 return new ResponseEntity<List<String>>(presentersService.getPresentersNamesByChannelId(channelId) , HttpStatus.OK);
	 }
	 
	 
	 @RequestMapping(value = "/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.Presenter>> getByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		 return new ResponseEntity<List<com.cbc.domain.Presenter>>(presentersService.getPresentersByChannel(channelId) , HttpStatus.OK);
	 }
	 
	 
	 @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.Presenter>> listPresenters()
	 {
		 List<Presenter> presenters = presentersService.listAllPresenters();
		 
		 if(presenters == null || presenters.isEmpty())
		 {
			 LOGGER.error("No Presenters in DB");
			 return new ResponseEntity<List<com.cbc.domain.Presenter>>(HttpStatus.NO_CONTENT);
		 }
		 
		 List<com.cbc.domain.Presenter> domList = new ArrayList<com.cbc.domain.Presenter>();
		 for(Presenter p : presenters)
		 {
			 domList.add(new com.cbc.domain.Presenter(p));
		 }
		 
		 return new ResponseEntity<List<com.cbc.domain.Presenter>>(domList , HttpStatus.OK);
	 }
}
