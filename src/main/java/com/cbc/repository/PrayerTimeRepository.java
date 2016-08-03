/**
 * 
 */
package com.cbc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.PrayerTime;

/**
 * @author Mina Saleeb
 *
 */
public interface PrayerTimeRepository extends CrudRepository<PrayerTime, Long>
{
	List<PrayerTime> findByPrayingDateBetweenOrderByPrayingDateAsc(Date  from, Date to);
}
