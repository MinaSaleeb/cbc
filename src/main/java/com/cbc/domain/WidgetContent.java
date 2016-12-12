/**
 * 
 */
package com.cbc.domain;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina
 *
 */
public class WidgetContent 
{
	private long id;
	
	private String htmlContent;
	
	private String contentUrl;
	
	private String contentUrlType;
	
	public WidgetContent(com.cbc.model.WidgetContent wc) 
	{
		super();
		ModelToDomainMapper.mapWidgetContent(wc, this);
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
	 * @return the contentUrlType
	 */
	public String getContentUrlType() {
		return contentUrlType;
	}

	/**
	 * @param contentUrlType the contentUrlType to set
	 */
	public void setContentUrlType(String contentUrlType) {
		this.contentUrlType = contentUrlType;
	}
}
