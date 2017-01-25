/**
 * 
 */
package com.cbc.domain;

import javax.persistence.Column;

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
	
	private String title;
	
	private String slug;
	
	private String description;
	
	private String thumbnailImage;
	
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
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
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
	 * @return the thumbnailImage
	 */
	public String getThumbnailImage() {
		return thumbnailImage;
	}

	/**
	 * @param thumbnailImage the thumbnailImage to set
	 */
	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
}
