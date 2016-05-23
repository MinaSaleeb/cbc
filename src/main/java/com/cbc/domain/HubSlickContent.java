/**
 * 
 */
package com.cbc.domain;

import java.util.List;

/**
 * @author Mina Saleeb
 *
 */
public class HubSlickContent 
{
	private List<MediaContentTuple> slickItemsList;
	private String title;
	/**
	 * @param tuplesList
	 */
	public HubSlickContent(String title , List<MediaContentTuple> tuplesList) 
	{
		super();
		this.slickItemsList = tuplesList;
		this.title = title;
	}

	

	/**
	 * @return the slickItemsList
	 */
	public List<MediaContentTuple> getSlickItemsList() {
		return slickItemsList;
	}



	/**
	 * @param slickItemsList the slickItemsList to set
	 */
	public void setSlickItemsList(List<MediaContentTuple> slickItemsList) {
		this.slickItemsList = slickItemsList;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
