/**
 * 
 */
package com.cbc.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.domain.HubTimeLine;
import com.cbc.model.TimeLine;
import com.cbc.services.ScheduleService;
import java.util.*;

/**
 * @author Mina Saleeb
 *
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleRestController 
{
	private static final Logger LOGGER = Logger.getLogger(ScheduleRestController.class);
	
	@Autowired
	private ScheduleService scheduleService;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/hub/timeline", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,List<HubTimeLine>>> getHubPageTimeLine()
	{
		return new ResponseEntity<Map<String,List<HubTimeLine>>>(scheduleService.getHubTimeLine(),HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	@RequestMapping(value = "/today/timeline/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TimeLine>> getTodayTimeLineByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	{
		return new ResponseEntity<List<TimeLine>>(scheduleService.getTodayTimeLineByChannelId(channelId),HttpStatus.OK);
	}
}