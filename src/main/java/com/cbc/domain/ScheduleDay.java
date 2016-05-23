/**
 * 
 */
package com.cbc.domain;

import java.util.Date;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class ScheduleDay 
{
	private int id;

	private Date actualDate;
	
	

	/**
	 * 
	 */
	public ScheduleDay(com.cbc.model.ScheduleDay sd) 
	{
		super();
		ModelToDomainMapper.mapScheduleDay(sd, this);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the actualDate
	 */
	public Date getActualDate() {
		return actualDate;
	}

	/**
	 * @param actualDate the actualDate to set
	 */
	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}
	
	

}
