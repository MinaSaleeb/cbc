/**
 * 
 */
package com.cbc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.Channel;
import com.cbc.model.ScheduleDay;
import com.cbc.model.TimeLine;

/**
 * @author Mina Saleeb
 *
 */
public interface TimeLineRepository extends CrudRepository<TimeLine, Long> 
{
	List<TimeLine> findByChannelBeanAndScheduleDay(Channel channelBean,ScheduleDay scheduleDay);
	
	List<TimeLine> findByChannelBeanAndScheduleDayAndStartTimeEndingWith(Channel channelBean,ScheduleDay scheduleDay, String startTimePattern);
	
	@Query("SELECT tl FROM TimeLine tl WHERE tl.channelBean.id = :channelId AND (tl.scheduleDay.actualDate >= :fromDate AND tl.scheduleDay.actualDate <= :toDate)")
	List<TimeLine> findByChannelIdAndDays(@Param("channelId") int channelId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query("SELECT tl FROM TimeLine tl WHERE tl.channelBean.id = :channelId AND tl.scheduleDay.id = :dayId")
	List<TimeLine> findByChannelIdAndDayId(@Param("channelId") int channelId, @Param("dayId") int dayId);
	
}
