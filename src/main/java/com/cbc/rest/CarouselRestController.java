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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.Carousel;
import com.cbc.model.Channel;
import com.cbc.repository.CarouselRepository;
import com.cbc.repository.ChannelRepository;

/**
 * @author Mina
 *
 */
@RestController
@RequestMapping("/carousel")
public class CarouselRestController 
{
	private static final Logger LOGGER = Logger.getLogger(CarouselRestController.class);
	
	@Autowired
	private CarouselRepository carouselRepo;
	
	@Autowired
	private ChannelRepository channelRepository;
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	 @RequestMapping(value = "/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Carousel> getByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		 Carousel carousel = null;
		 
		 Channel channel = channelRepository.findOne(channelId);
		 if(channel != null)
		 {
			carousel = carouselRepo.findByChannelBean(channel);
		 }
		 
		 if(carousel == null)
		 {
			 return new ResponseEntity<Carousel>(HttpStatus.NOT_FOUND);
		 }
		 
		 return new ResponseEntity<Carousel>(carousel , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/hub", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<String>> getHubCarouselImages()
	 {
		 List<String> imagesList = new ArrayList<String>();
		 
		 List<Channel> channels = (List<Channel>) channelRepository.findAll();
		 
		 if(channels != null && !channels.isEmpty())
		 {
			 for(Channel channel : channels)
			 {
				 imagesList.add(channel.getHubCarouelImage());
			 }
		 }
		 
		 return new ResponseEntity<List<String>>(imagesList , HttpStatus.OK);
	 }
	
	
}
