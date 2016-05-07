/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.domain.HubTimeLine;
import com.cbc.domain.Schedule;
import com.cbc.model.Channel;
import com.cbc.model.ScheduleDay;
import com.cbc.model.TimeLine;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.ScheduleDayRepository;
import com.cbc.repository.TimeLineRepository;
import com.cbc.util.Constants;
import com.cbc.util.TimeUtils;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class ScheduleService 
{
	private static final Logger LOGGER = Logger.getLogger(ScheduleService.class);
	
	@Autowired
	private TimeLineRepository timeLineRepo;
	
	@Autowired
	private ScheduleDayRepository scheduleDayRepo;
	
	@Autowired
	private ChannelRepository channelRepo;
	
	/**
	 * 
	 * @param day
	 * @return
	 */
	public ScheduleDay getMappedScheduleDay(Date day)
	{
		ScheduleDay scheduleDay = scheduleDayRepo.findByActualDate(day);
		
		return scheduleDay;
 	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public Map<String , List<HubTimeLine>> getHubTimeLine()
	{
		Map<String,List<HubTimeLine>> hubTimeLineMap = new HashMap<String,List<HubTimeLine>>();
		List<HubTimeLine> nowList = new ArrayList<HubTimeLine>();
		List<HubTimeLine> nextList = new ArrayList<HubTimeLine>();
		List<HubTimeLine> afterNextList = new ArrayList<HubTimeLine>();
		
		//1- list all channels
		List<Channel> allChannels = (List<Channel>) channelRepo.findAll();
		if(allChannels != null && !allChannels.isEmpty())
		{
			ScheduleDay today = getMappedScheduleDay(TimeUtils.getTodayDate());
			//2- loop on each channel to get its schedule by today date
			for(Channel chnl : allChannels)
			{
				List<TimeLine> chnlTimeLines = timeLineRepo.findByChannelBeanAndScheduleDay(chnl, today);
				//2.1 - Specify what is displaying (now , next , after next) for the current channel.
				if(chnlTimeLines != null && !chnlTimeLines.isEmpty())
				{
					int currentHour = TimeUtils.getCurrentHourAs_24();
					int nextTimeLineStartHour = 0;
					int afterNextTimeLineStartHour = 0;
					//2.1.a- NOW
					for(TimeLine timeLine : chnlTimeLines)
					{
						int timeLineStartHour = TimeUtils.convert_hhaa_to_24(timeLine.getStartTime());
						int timeLineEndHour = timeLineStartHour + timeLine.getDuration();
						if(currentHour >= timeLineStartHour && currentHour < timeLineEndHour) 
						{
							com.cbc.domain.Channel domChnl = new com.cbc.domain.Channel(chnl);
							HubTimeLine nowHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
							nowList.add(nowHubTmLn);
							nextTimeLineStartHour = timeLineEndHour;
							break;
						}
						
					}
					//2.1.b- NEXT
					for(TimeLine timeLine : chnlTimeLines)
					{
						int timeLineStartHour = TimeUtils.convert_hhaa_to_24(timeLine.getStartTime());
						int timeLineEndHour = timeLineStartHour + timeLine.getDuration();
						if(nextTimeLineStartHour == timeLineStartHour) 
						{
							com.cbc.domain.Channel domChnl = new com.cbc.domain.Channel(chnl);
							HubTimeLine nextHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
							nextList.add(nextHubTmLn);
							afterNextTimeLineStartHour = timeLineEndHour;
							break;
						}
						
					}
					//2.1.c- AFTER NEXT
					for(TimeLine timeLine : chnlTimeLines)
					{
						int timeLineStartHour = TimeUtils.convert_hhaa_to_24(timeLine.getStartTime());
						if(afterNextTimeLineStartHour == timeLineStartHour) 
						{
							com.cbc.domain.Channel domChnl = new com.cbc.domain.Channel(chnl);
							HubTimeLine afterNextHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
							afterNextList.add(afterNextHubTmLn);
							break;
						}
						
					}
					
				}
			}
		}
		
		
		
		hubTimeLineMap.put(Constants.TimeLineStages.NOW.name(), nowList);
		hubTimeLineMap.put(Constants.TimeLineStages.NEXT.name(), nextList);
		hubTimeLineMap.put(Constants.TimeLineStages.AFTER_NEXT.name(), afterNextList);
		
		return hubTimeLineMap;
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	public List<TimeLine> getTodayTimeLineByChannelId(int channelId)
	{
		List<TimeLine> chnlTimeLines = new ArrayList<TimeLine>();
		
		Channel chnl = channelRepo.findOne(channelId);
		
		if(chnl != null)
		{
			ScheduleDay today = getMappedScheduleDay(TimeUtils.getTodayDate());
			chnlTimeLines = timeLineRepo.findByChannelBeanAndScheduleDay(chnl, today);
		}
		else
		{
			LOGGER.error("channelId {"+channelId+"} is not found in DB");
		}
		
		
		return chnlTimeLines;
	}
	
	/**
	 * 
	 * @return
	 */
	public Schedule getSchedule()
	{
		
		// Each map entry will contain the the time lines list by the key channelName+dayId
		Map<String , List<TimeLine>> chnlDayTimeLinesMap = new HashMap<String , List<TimeLine>>();
		
		//1- get all channels
		List<Channel> allChannels = (List<Channel>) channelRepo.findAll();
		
		//2- get all days
		List<ScheduleDay> allDays = (List<ScheduleDay>) scheduleDayRepo.findAll();
		
		//3-get TimeLines list based on specific channel and specific day.
		if(allChannels != null  && !allChannels.isEmpty())
		{
			for(Channel chnl : allChannels)
			{
				if(allDays != null && !allDays.isEmpty())
				{
					for(ScheduleDay day : allDays)
					{
						List<TimeLine> chnlDayTimeLines = timeLineRepo.findByChannelBeanAndScheduleDay(chnl, day);
						String key = chnl.getChannelName()+day.getId();
						chnlDayTimeLinesMap.put(key, chnlDayTimeLines);
					}
				}
			}
		}
		
		return new Schedule(allChannels , allDays , chnlDayTimeLinesMap);
	}
	
	
}
