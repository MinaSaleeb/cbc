/**
 * 
 */
package com.cbc.domain;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class ProgramPromo 
{
	private long id;

	private String description;

	private String promoUrl;

	private String title;
	
	
	

	/**
	 * 
	 */
	public ProgramPromo(com.cbc.model.ProgramPromo pp) 
	{
		super();
		ModelToDomainMapper.mapProgramPromo(pp, this);
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the promoUrl
	 */
	public String getPromoUrl() {
		return promoUrl;
	}

	/**
	 * @param promoUrl the promoUrl to set
	 */
	public void setPromoUrl(String promoUrl) {
		this.promoUrl = promoUrl;
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
