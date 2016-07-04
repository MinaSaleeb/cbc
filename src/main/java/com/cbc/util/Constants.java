/**
 * 
 */
package com.cbc.util;

/**
 * @author Mina Saleeb
 *
 */
public interface Constants 
{
	public static enum TimeLineStages
	{
		NOW,
		NEXT,
		AFTER_NEXT
	}
	
	public static enum MostViewedType
	{
		VEDIO,
		IMAGE,
		PROGRAM,
		PROMO
	}
	
	public static enum NewsType
	{
		NORMAL,
		VIDEO,
		GALLERY
	}
	
	public static final String PAGE_NUMBER_PARAM_NAME = "pageNumber";
	
	public static final String PAGE_SIZE_PARAM_NAME = "size";
}
