/**
 * 
 */
package com.cbc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author Mina Saleeb
 *
 */
public class TimeUtils 
{
	
	private static final Logger LOGGER = Logger.getLogger(TimeUtils.class);
	
	/**
	 * 
	 * @return
	 */
	public static Date getTodayDate()
	{
		Date today = Calendar.getInstance().getTime();
		
		return today;
	}
	
	public static Date getTomorrowDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		
		return tomorrow;
	}
	
	public static Date getYesterdayDate()
	{
	     return new Date(System.currentTimeMillis()-24*60*60*1000);
	}
	
	/**
	 * 
	 * @return
	 */
	public static float getCurrentHourAs_24()
	{
		Calendar rightNow = Calendar.getInstance();
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		int minutes = rightNow.get(Calendar.MINUTE);
		float t = hour + minutes/60;
		return t;
	}
	
	/**
	 * 
	 * @param hhaaTime
	 * @return
	 */
	public static float convert_hhaa_to_24(String hhaaTime)
	{
		int time_24 = 0;
		float t = 0.0f;
		if(hhaaTime != null & !hhaaTime.isEmpty())
		{
			SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
			try
			{
				Date date = parseFormat.parse(hhaaTime);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				time_24 = calendar.get(Calendar.HOUR_OF_DAY);
				int minutes = calendar.get(Calendar.MINUTE);
				t = time_24 + minutes/60;
			} catch (ParseException e) {
				LOGGER.error("Error while formatting {"+hhaaTime+"} to date");
				e.printStackTrace();
			}
		}
		
		
		return t;
	}
}
