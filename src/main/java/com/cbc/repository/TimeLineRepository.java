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
	
	@Query("SELECT tl FROM TimeLine tl WHERE tl.channelBean.id = :channelId AND tl.scheduleDay.actualDate BETWEEN :fromDate AND :toDate")
	List<TimeLine> findByChannelIdAndDays(@Param("channelId") int channelId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
