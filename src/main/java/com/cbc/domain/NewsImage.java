/**
 * 
 */
package com.cbc.domain;

import java.io.Serializable;

/**
 * @author Mina Saleeb
 *
 */
public class NewsImage implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imageUrl;
	private String description;
	
	/**
	 * @param imageUrl
	 * @param description
	 */
	public NewsImage(String imageUrl, String description) 
	{
		super();
		this.imageUrl = imageUrl;
		this.description = description;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	
	
}
