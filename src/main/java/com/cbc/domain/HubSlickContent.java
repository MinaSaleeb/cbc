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

	/**
	 * @param tuplesList
	 */
	public HubSlickContent(List<MediaContentTuple> tuplesList) 
	{
		super();
		this.tuplesList = tuplesList;
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
	
	
}
