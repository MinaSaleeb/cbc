/**
 * 
 */
package com.cbc.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.Channel;
import com.cbc.model.ChannelsAdDiv;
import com.cbc.repository.ChannelRepository;

/**
 * @author Mina Saleeb
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/channel")
@Transactional
public class ChannelsRestController 
{
	private static final Logger LOGGER = Logger.getLogger(ChannelsRestController.class);
	
	@Autowired
	private ChannelRepository channelRepository;
	
	/**
	 * 
	 * @return
	 */
	 @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.Channel>> listChannels()
	 {
		 List<Channel> channels = (List<Channel>) channelRepository.findAll();
		 
		 if(channels == null || channels.isEmpty())
		 {
			 LOGGER.error("No Channels in DB");
			 return new ResponseEntity<List<com.cbc.domain.Channel>>(HttpStatus.NO_CONTENT);
		 }
		 
		 List<com.cbc.domain.Channel> chnls = new ArrayList<com.cbc.domain.Channel>();
		 
		 for(Channel c : channels)
		 {
			 chnls.add(new com.cbc.domain.Channel(c));
		 }
		 
		 return new ResponseEntity<List<com.cbc.domain.Channel>>(chnls , HttpStatus.OK);
	 }
	 
	 /**
	  * 
	  * @param channelId
	  * @return
	  */
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<com.cbc.domain.Channel> getChannelById(@PathVariable("id") int channelId)
	 {
		Channel channel = channelRepository.findOne(channelId);
		 
		 if(channel == null)
		 {
			 LOGGER.error("channelId {"+channelId+"} is not found in DB");
			 return new ResponseEntity<com.cbc.domain.Channel>(HttpStatus.NOT_FOUND);
		 }
		 
		 return new ResponseEntity<com.cbc.domain.Channel>(new com.cbc.domain.Channel(channel) , HttpStatus.OK);
	 }
	 
	 /**
	  * 
	  * @param channelId
	  * @return
	  */
	 @RequestMapping(value = "/{id}/ads", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Map<String , String>> getChannelAdsScripts(@PathVariable("id") int channelId)
	 {
		Channel channel = channelRepository.findOne(channelId);
		Map<String , String> channelAdsmap = new HashMap<String , String>();
		 
		 if(channel == null)
		 {
			 LOGGER.error("channelId {"+channelId+"} is not found in DB");
			 return new ResponseEntity<Map<String , String>>(HttpStatus.NOT_FOUND);
		 }
		 else
		 {
			List<ChannelsAdDiv> channelAds = channel.getChannelsAdDivs();
			
			if(channelAds != null && !channelAds.isEmpty())
			{
				for(ChannelsAdDiv ad : channelAds)
				{
					channelAdsmap.put(ad.getAdDiv().getDivCode(), ad.getAdScript());
				}
			}
			else
			{
				LOGGER.error("channelId {"+channelId+"} does not have ads");
				return new ResponseEntity<Map<String , String>>(HttpStatus.NO_CONTENT);
			}
		 }
		 
		 return new ResponseEntity<Map<String , String>>(channelAdsmap , HttpStatus.OK);
	 }
	
	
}
