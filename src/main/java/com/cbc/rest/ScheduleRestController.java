/**
 * 
 */
package com.cbc.rest;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.domain.HubTimeLine;
import com.cbc.domain.Schedule;
import com.cbc.services.ScheduleService;
import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
@CrossOrigin("*")
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
	public ResponseEntity<List<com.cbc.domain.TimeLine>> getTodayTimeLineByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	{
		return new ResponseEntity<List<com.cbc.domain.TimeLine>>(ModelToDomainMapper.mapTimeLineList(scheduleService.getTodayTimeLineByChannelId(channelId)),HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Schedule> getSchedule()
	{
		return new ResponseEntity<Schedule>(scheduleService.getSchedule(),HttpStatus.OK);
	}
}
