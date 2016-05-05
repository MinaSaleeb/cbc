/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

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
}
