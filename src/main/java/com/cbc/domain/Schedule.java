/**
 * 
 */
package com.cbc.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cbc.domain.Channel;
import com.cbc.domain.ScheduleDay;
import com.cbc.domain.TimeLine;

/**
 * @author Mina Saleeb
 *
 */
public class Schedule 
{
	private List<Channel> channels;
	
	private List<ScheduleDay> days;

	/**
	 * Each map entry will contain the the time lines list by the key channelName+dayId
	 */
	private Map<String , List<TimeLine>> timeLinesMap = new HashMap<String , List<TimeLine>>();

	/**
	 * @param channels
	 * @param days
	 * @param timeLinesMap
	 */
	public Schedule(List<Channel> channels, List<ScheduleDay> days, Map<String, List<TimeLine>> timeLinesMap) {
		super();
		this.channels = channels;
		this.days = days;
		this.timeLinesMap = timeLinesMap;
	}

	/**
	 * @return the channels
	 */
	public List<Channel> getChannels() {
		return channels;
	}

	/**
	 * @param channels the channels to set
	 */
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	/**
	 * @return the days
	 */
	public List<ScheduleDay> getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(List<ScheduleDay> days) {
		this.days = days;
	}

	/**
	 * @return the timeLinesMap
	 */
	public Map<String, List<TimeLine>> getTimeLinesMap() {
		return timeLinesMap;
	}

	/**
	 * @param timeLinesMap the timeLinesMap to set
	 */
	public void setTimeLinesMap(Map<String, List<TimeLine>> timeLinesMap) {
		this.timeLinesMap = timeLinesMap;
	}
	
	
}
