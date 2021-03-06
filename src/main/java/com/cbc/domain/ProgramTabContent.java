/**
 * 
 */
package com.cbc.domain;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class ProgramTabContent 
{

	private long id;
	
	private String description;
	
	private String title;
	
	private String contentUrl;
	
	private String thumbnail;
	
	private String contentType;
	
	private String htmlContent;


	public ProgramTabContent(com.cbc.model.ProgramTabContent ptc) 
	{
		super();
		ModelToDomainMapper.mapProgramTabContent(ptc, this);
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
	 * @return the contentUrl
	 */
	public String getContentUrl() {
		return contentUrl;
	}


	/**
	 * @param contentUrl the contentUrl to set
	 */
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}


	/**
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}


	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}


	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	/**
	 * @return the htmlContent
	 */
	public String getHtmlContent() {
		return htmlContent;
	}


	/**
	 * @param htmlContent the htmlContent to set
	 */
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	
	
}
