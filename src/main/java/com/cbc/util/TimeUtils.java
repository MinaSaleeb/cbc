/**
 * 
 */
package com.cbc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * @author Mina Saleeb
 *
 */
public class TimeUtils 
{
	
	private static final Logger LOGGER = Logger.getLogger(TimeUtils.class);
	
	private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
	private static final DateFormat dtf = new SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.ENGLISH);
	
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
		float t = hour + minutes/60.0f;
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
			SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
			try
			{
				Date date = parseFormat.parse(hhaaTime);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				time_24 = calendar.get(Calendar.HOUR_OF_DAY);
				int minutes = calendar.get(Calendar.MINUTE);
				t = time_24 + minutes/60.0f;
				/*
				if(t == 0.0)
				{
					t = 24.0f;
				}
				*/
			} catch (ParseException e) {
				LOGGER.error("Error while formatting {"+hhaaTime+"} to date");
				e.printStackTrace();
			}
		}
		
		
		return t;
	}
	
	/**
	 * 
	 * @param date
	 * @param hhaaTime
	 * @return
	 */
	public static Date getDateTime(Date date,String hhaaTime)
	{
		String dateTimeFormat = df.format(date)+" "+hhaaTime;
		Date result = null;
		try 
		{
			result = dtf.parse(dateTimeFormat);
		} catch (ParseException e) 
		{
			LOGGER.error("Faild to parse date : "+dateTimeFormat);
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static Date addMinuts(Date date,float duration)
	{
		Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 int minuts = (int) (60 * duration);
		 cal.add(Calendar.MINUTE, minuts);
		 
		 return cal.getTime();
	}
}
