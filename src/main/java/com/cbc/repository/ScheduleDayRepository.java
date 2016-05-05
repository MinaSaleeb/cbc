/**
 * 
 */
package com.cbc.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.ScheduleDay;

/**
 * @author Mina Saleeb
 *
 */
public interface ScheduleDayRepository extends CrudRepository<ScheduleDay, Integer> 
{
	ScheduleDay findByActualDate(Date actualDate);
}
