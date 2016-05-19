/**
 * 
 */
package com.cbc.domain;

import java.util.List;

/**
 * @author MondiaMedia
 *
 */
public class HubSlickContent 
{
	private List<MediaContentTuple> tuplesList;
	private String title;
	/**
	 * @param tuplesList
	 */
	public HubSlickContent(String title , List<MediaContentTuple> tuplesList) 
	{
		super();
		this.tuplesList = tuplesList;
		this.title = title;
	}

	/**
	 * @return the tuplesList
	 */
	public List<MediaContentTuple> getTuplesList() {
		return tuplesList;
	}

	/**
	 * @param tuplesList the tuplesList to set
	 */
	public void setTuplesList(List<MediaContentTuple> tuplesList) {
		this.tuplesList = tuplesList;
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
