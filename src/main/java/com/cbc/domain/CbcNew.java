/**
 * 
 */
package com.cbc.domain;

import java.util.Date;
import java.util.List;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class CbcNew 
{
	private String id;

	private String description;

	private String photoPath;
	
	private Date postingDate;

	private String title;
	
	private String categoryId;
	
	private String categoryName;
	
	private String content;
	
	private String videoUrl;
	
	private String type;
	
	private List<NewsImage> images;
	
	private List<String> tags;
	
	private String thumbnail;
	
	private CbcNew nextNew;
	
	private CbcNew previousNew;
	
	/**
	 * 
	 */
	public CbcNew(com.cbc.model.CbcNew n) 
	{
		super();
		ModelToDomainMapper.mapCBCNew(n , this);
	}
	
	public CbcNew(com.cbc.model.CbcNew n, String content) 
	{
		super();
		ModelToDomainMapper.mapCBCNew(n , this);
		this.content = content;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * @param photoPath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	/**
	 * @return the postingDate
	 */
	public Date getPostingDate() {
		return postingDate;
	}

	/**
	 * @param postingDate the postingDate to set
	 */
	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
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
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the videoUrl
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * @param videoUrl the videoUrl to set
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the images
	 */
	public List<NewsImage> getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(List<NewsImage> images) {
		this.images = images;
	}

	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
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
	 * @return the nextNew
	 */
	public CbcNew getNextNew() {
		return nextNew;
	}

	/**
	 * @param nextNew the nextNew to set
	 */
	public void setNextNew(CbcNew nextNew) {
		this.nextNew = nextNew;
	}

	/**
	 * @return the previousNew
	 */
	public CbcNew getPreviousNew() {
		return previousNew;
	}

	/**
	 * @param previousNew the previousNew to set
	 */
	public void setPreviousNew(CbcNew previousNew) {
		this.previousNew = previousNew;
	}
	
	
}
