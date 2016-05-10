/**
 * 
 */
package com.cbc.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	 public ResponseEntity<Presenter> getPresenterById(@PathVariable("id") int presenterId)
	 {
		 Presenter presenter = presentersService.getPresenterById(presenterId);
		
		if(presenter == null)
		{
			LOGGER.error("presenterId {"+presenterId+"} is not found in DB");
			return new ResponseEntity<Presenter>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Presenter>(presenter , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/names/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<String>> getPresentersNamesByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		 return new ResponseEntity<List<String>>(presentersService.getPresentersNamesByChannelId(channelId) , HttpStatus.OK);
	 }
}
