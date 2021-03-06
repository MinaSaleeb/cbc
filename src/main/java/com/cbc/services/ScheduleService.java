/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbc.domain.HubTimeLine;
import com.cbc.domain.Schedule;
import com.cbc.model.Channel;
import com.cbc.model.ScheduleDay;
import com.cbc.model.TimeLine;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.ScheduleDayRepository;
import com.cbc.repository.TimeLineRepository;
import com.cbc.util.Constants;
import com.cbc.util.ModelToDomainMapper;
import com.cbc.util.TimeUtils;

/**
 * @author Mina Saleeb
 *
 */
@Service
@Transactional
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
				List<TimeLine> chnlTimeLines = new ArrayList<TimeLine>();
				//To handle intersection
				if(2 > TimeUtils.getCurrentHourAs_24() && TimeUtils.getCurrentHourAs_24() >= 0)
				{
					ScheduleDay yesterday = getMappedScheduleDay(TimeUtils.getYesterdayDate());
					if(yesterday != null)
					{
						chnlTimeLines.addAll(timeLineRepo.findByChannelBeanAndScheduleDayAndStartTimeEndingWith(chnl, yesterday,"%PM%"));
					}
				}
				
				chnlTimeLines.addAll(timeLineRepo.findByChannelBeanAndScheduleDay(chnl, today));
				
				if(24 > TimeUtils.getCurrentHourAs_24() && TimeUtils.getCurrentHourAs_24() > 22)
				{
					ScheduleDay tomorrow = getMappedScheduleDay(TimeUtils.getTomorrowDate());
					if(tomorrow != null)
					{
						chnlTimeLines.addAll(timeLineRepo.findByChannelBeanAndScheduleDay(chnl, tomorrow));
					}
				}
				
				//2.1 - Specify what is displaying (now , next , after next) for the current channel.
				if(chnlTimeLines != null && !chnlTimeLines.isEmpty())
				{
					float nextTimeLineStartHour = TimeUtils.getCurrentHourAs_24();
					float afterNextTimeLineStartHour = TimeUtils.getCurrentHourAs_24();
					//2.1.a- NOW
					for(Iterator<TimeLine> iterator = chnlTimeLines.iterator(); iterator.hasNext();)
					{
						TimeLine timeLine = iterator.next();
						float currentHour = TimeUtils.getCurrentHourAs_24();
						float timeLineStartHour = TimeUtils.convert_hhaa_to_24(timeLine.getStartTime());
						float timeLineEndHour = timeLineStartHour + timeLine.getDuration();
						if(timeLineEndHour > 24 )
						{
							timeLineEndHour = timeLineEndHour-24;
							timeLineStartHour = timeLineStartHour-24;
							if(today.getId() == timeLine.getScheduleDay().getId())
							{
								currentHour = currentHour-24;
							}
						}
						if(currentHour >= timeLineStartHour && currentHour < timeLineEndHour) 
						{
							com.cbc.domain.Channel domChnl = new com.cbc.domain.Channel(chnl);
							HubTimeLine nowHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
							nowList.add(nowHubTmLn);
							nextTimeLineStartHour = timeLineEndHour == 24.0f?0.0f:timeLineEndHour;
							break;
						}
						else//For Optimization remove the time lines before now
						{
							//iterator.remove();
						}
						
					}
					//2.1.b- NEXT
					if(chnlTimeLines != null && !chnlTimeLines.isEmpty())
					{
						for(Iterator<TimeLine> iterator = chnlTimeLines.iterator(); iterator.hasNext();)
						{
							TimeLine timeLine = iterator.next();
							float timeLineStartHour = TimeUtils.convert_hhaa_to_24(timeLine.getStartTime());
							float timeLineEndHour = timeLineStartHour + timeLine.getDuration();
							if(timeLineEndHour > 24 )
							{
								timeLineEndHour = timeLineEndHour-24;
								timeLineStartHour = timeLineStartHour -24;
							}
							if(timeLineStartHour >= nextTimeLineStartHour) 
							{
								com.cbc.domain.Channel domChnl = new com.cbc.domain.Channel(chnl);
								HubTimeLine nextHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
								nextList.add(nextHubTmLn);
								afterNextTimeLineStartHour = timeLineEndHour;
								break;
							}
							else//For Optimization remove the time lines before now
							{
								//iterator.remove();
							}
						}
					}
					//2.1.c- AFTER NEXT
					if(chnlTimeLines != null && !chnlTimeLines.isEmpty())
					{
						for(TimeLine timeLine : chnlTimeLines)
						{
							float timeLineStartHour = TimeUtils.convert_hhaa_to_24(timeLine.getStartTime());
							if(timeLineStartHour >= afterNextTimeLineStartHour) 
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
		}
		
		
		
		hubTimeLineMap.put(Constants.TimeLineStages.NOW.name(), nowList);
		hubTimeLineMap.put(Constants.TimeLineStages.NEXT.name(), nextList);
		hubTimeLineMap.put(Constants.TimeLineStages.AFTER_NEXT.name(), afterNextList);
		
		return hubTimeLineMap;
	}
	
	public Map<String , List<HubTimeLine>> getHubTimeLineV2()
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
				List<TimeLine> chnlTimeLines = new ArrayList<TimeLine>();
				//Yesterday
				ScheduleDay yesterday = getMappedScheduleDay(TimeUtils.getYesterdayDate());
				if(yesterday != null)
				{
					//chnlTimeLines.addAll(timeLineRepo.findByChannelBeanAndScheduleDay(chnl, yesterday));
					chnlTimeLines.addAll(timeLineRepo.findByChannelIdAndDayId(chnl.getId(), yesterday.getId()));
				}
				
				//Today
				//chnlTimeLines.addAll(timeLineRepo.findByChannelBeanAndScheduleDay(chnl, today));
				if(today != null)
				{
					chnlTimeLines.addAll(timeLineRepo.findByChannelIdAndDayId(chnl.getId(), today.getId()));
				}
				
				//Tomorrow
				ScheduleDay tomorrow = getMappedScheduleDay(TimeUtils.getTomorrowDate());
				if(tomorrow != null)
				{
					//chnlTimeLines.addAll(timeLineRepo.findByChannelBeanAndScheduleDay(chnl, tomorrow));
					chnlTimeLines.addAll(timeLineRepo.findByChannelIdAndDayId(chnl.getId(), tomorrow.getId()));
				}
				
				
				//2.1 - Specify what is displaying (now , next , after next) for the current channel.
				if(chnlTimeLines != null && !chnlTimeLines.isEmpty())
				{
					//order the list by start date ASC
					Collections.sort(chnlTimeLines, new Comparator<TimeLine>(){
						@Override
						public int compare(TimeLine o1, TimeLine o2) {
							if (o1.getStartDateTime() == null || o2.getStartDateTime() == null)
							{
						        return 0;
							}
						      return o1.getStartDateTime().compareTo(o2.getStartDateTime());
						}});
					
					boolean isThereGap = true;
					List<TimeLine> afterNowchnlTimeLines = new ArrayList<TimeLine>();
					//2.1.a- NOW
					for(Iterator<TimeLine> iterator = chnlTimeLines.iterator(); iterator.hasNext();)
					{
						TimeLine timeLine = iterator.next();
						Date now = new Date();
						//NOW
						if((now.after(timeLine.getStartDateTime()) || now.equals(timeLine.getStartDateTime())) && now.before(timeLine.getEndDateTime()))
						{
							com.cbc.domain.Channel domChnl = new com.cbc.domain.Channel(chnl);
							HubTimeLine nowHubTmLn = null;
							if(timeLine.getProgramBean() != null)
							{
								nowHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
							}
							else
							{
								nowHubTmLn = new HubTimeLine(domChnl , timeLine.getStaticProgramTitle(), 0);
							}
							nowList.add(nowHubTmLn);
							if(iterator.hasNext()) //NEXT
							{
								timeLine = iterator.next();
								HubTimeLine nextHubTmLn = null;
								if(timeLine.getProgramBean() != null)
								{
									nextHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
								}
								else
								{
									nextHubTmLn = new HubTimeLine(domChnl , timeLine.getStaticProgramTitle(), 0);
								}
								nextList.add(nextHubTmLn);
							}
							
							if(iterator.hasNext()) //AFTER NEXT
							{
								timeLine = iterator.next();
								HubTimeLine afterNextHubTmLn = null;
								if(timeLine.getProgramBean() != null)
								{
									afterNextHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
								}
								else
								{
									afterNextHubTmLn = new HubTimeLine(domChnl , timeLine.getStaticProgramTitle(), 0);
								}
								afterNextList.add(afterNextHubTmLn);
							}
							isThereGap = false;
							break;
						}
						
						if(now.before(timeLine.getStartDateTime()))
						{
							afterNowchnlTimeLines.add(timeLine);
						}
					}
					
					if(isThereGap)
					{
						for(Iterator<TimeLine> iterator = afterNowchnlTimeLines.iterator(); iterator.hasNext();)
						{
							TimeLine timeLine = iterator.next();
							Date now = new Date();
							
							if((now.before(timeLine.getStartDateTime())))
							{
								com.cbc.domain.Channel domChnl = new com.cbc.domain.Channel(chnl);
								if(iterator.hasNext()) //NEXT
								{
									HubTimeLine nextHubTmLn = null;
									if(timeLine.getProgramBean() != null)
									{
										nextHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
									}
									else
									{
										nextHubTmLn = new HubTimeLine(domChnl , timeLine.getStaticProgramTitle(), 0);
									}
									nextList.add(nextHubTmLn);
								}
								
								if(iterator.hasNext()) //AFTER NEXT
								{
									timeLine = iterator.next();
									HubTimeLine afterNextHubTmLn = null;
									if(timeLine.getProgramBean() != null)
									{
										afterNextHubTmLn = new HubTimeLine(domChnl , timeLine.getProgramBean().getTitle() , timeLine.getProgramBean().getId());
									}
									else
									{
										afterNextHubTmLn = new HubTimeLine(domChnl , timeLine.getStaticProgramTitle(), 0);
									}
									afterNextList.add(afterNextHubTmLn);
								}
								break;
							}
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
		Map<String , List<com.cbc.domain.TimeLine>> chnlDayTimeLinesMap = new HashMap<String , List<com.cbc.domain.TimeLine>>();
		
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
						chnlDayTimeLinesMap.put(key, ModelToDomainMapper.mapTimeLineList(chnlDayTimeLines));
					}
				}
			}
		}
		
		return new Schedule(ModelToDomainMapper.mapChannelsList(allChannels) , ModelToDomainMapper.mapScheduleDayList(allDays) , chnlDayTimeLinesMap);
	}
	
	
	/**
	 * 
	 * @param channelId
	 * @param from
	 * @param to
	 * @return
	 */
	public List<TimeLine> getTimeLineByChannelIdAndDateRange(int channelId, Date from, Date to)
	{
		return timeLineRepo.findByChannelIdAndDays(channelId, from, to);
	}
	
	
}
