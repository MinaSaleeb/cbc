/**
 * 
 */
package com.cbc.domain;

import com.cbc.util.Constants.MostViewedType;

/**
 * @author Mina Saleeb
 *
 */
public class MostViewed 
{
	private long id;
	private String url;
	private String title;
	private String description;
	private MostViewedType type;
	private String iconImage;
	/**
	 * @param url
	 */
	public MostViewed(String url) 
	{
		super();
		this.url = url;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the type
	 */
	public MostViewedType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(MostViewedType type) {
		this.type = type;
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
	 * @return the iconImage
	 */
	public String getIconImage() {
		return iconImage;
	}
	/**
	 * @param iconImage the iconImage to set
	 */
	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}
	
	
	
	
	
	
}
