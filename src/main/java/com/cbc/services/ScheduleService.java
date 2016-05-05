/**
 * 
 */
package com.cbc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.domain.HubTimeLine;
import com.cbc.model.Channel;
import com.cbc.model.ScheduleDay;
import com.cbc.model.TimeLine;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.ScheduleDayRepository;
import com.cbc.repository.TimeLineRepository;
import com.cbc.util.Constants;

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
	public Date getTodayDate()
	{
		Date today = Calendar.getInstance().getTime();
		
		return today;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCurrentHourAs_24()
	{
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	
	/**
	 * 
	 * @param hhaaTime
	 * @return
	 */
	public int convert_hhaa_to_24(String hhaaTime)
	{
		int time_24 = 0;
		if(hhaaTime != null & !hhaaTime.isEmpty())
		{
			SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
			try
			{
				Date date = parseFormat.parse(hhaaTime);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				time_24 = calendar.get(Calendar.HOUR_OF_DAY);
			} catch (ParseException e) {
				LOGGER.error("Error while formatting {"+hhaaTime+"} to date");
				e.printStackTrace();
			}
		}
		
		
		return time_24;
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
			ScheduleDay today = getMappedScheduleDay(getTodayDate());
			//2- loop on each channel to get its schedule by today date
			for(Channel chnl : allChannels)
			{
				List<TimeLine> chnlTimeLines = timeLineRepo.findByChannelBeanAndScheduleDay(chnl, today);
				//2.1 - Specify what is displaying (now , next , after next) for the current channel.
				if(chnlTimeLines != null && !chnlTimeLines.isEmpty())
				{
					int currentHour = getCurrentHourAs_24();
					int nextTimeLineStartHour = 0;
					int afterNextTimeLineStartHour = 0;
					//2.1.a- NOW
					for(TimeLine timeLine : chnlTimeLines)
					{
						int timeLineStartHour = convert_hhaa_to_24(timeLine.getStartTime());
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
						int timeLineStartHour = convert_hhaa_to_24(timeLine.getStartTime());
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
						int timeLineStartHour = convert_hhaa_to_24(timeLine.getStartTime());
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
			ScheduleDay today = getMappedScheduleDay(getTodayDate());
			chnlTimeLines = timeLineRepo.findByChannelBeanAndScheduleDay(chnl, today);
		}
		else
		{
			LOGGER.error("channelId {"+channelId+"} is not found in DB");
		}
		
		
		return chnlTimeLines;
	}
	
	
}
