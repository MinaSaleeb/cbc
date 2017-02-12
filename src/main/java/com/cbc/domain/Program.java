/**
 * 
 */
package com.cbc.domain;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class Program 
{
	private int id;

	private String description;

	private String image1xPath;

	private String image2xPath;

	private String imageBgPath;

	private String imageXPath;
	
	private String icon;
	
	private String thumbnailImage;
	
	private String recipeRatingImagePath;

	private String title;
	
	private boolean hideProgram;
	
	private String schedule;

	/**
	 * @return the schedule
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * @param schedule the schedule to set
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	/**
	 * 
	 */
	public Program(com.cbc.model.Program p) 
	{
		super();
		ModelToDomainMapper.mapProgram(p , this);
	}

	/**
	 * @param image1xPath
	 * @param image2xPath
	 * @param imageXPath
	 * @param title
	 */
	public Program(String image1xPath, String image2xPath, String imageXPath, String title) {
		super();
		this.image1xPath = image1xPath;
		this.image2xPath = image2xPath;
		this.imageXPath = imageXPath;
		this.title = title;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the image1xPath
	 */
	public String getImage1xPath() {
		return image1xPath;
	}

	/**
	 * @param image1xPath the image1xPath to set
	 */
	public void setImage1xPath(String image1xPath) {
		this.image1xPath = image1xPath;
	}

	/**
	 * @return the image2xPath
	 */
	public String getImage2xPath() {
		return image2xPath;
	}

	/**
	 * @param image2xPath the image2xPath to set
	 */
	public void setImage2xPath(String image2xPath) {
		this.image2xPath = image2xPath;
	}

	/**
	 * @return the imageBgPath
	 */
	public String getImageBgPath() {
		return imageBgPath;
	}

	/**
	 * @param imageBgPath the imageBgPath to set
	 */
	public void setImageBgPath(String imageBgPath) {
		this.imageBgPath = imageBgPath;
	}

	/**
	 * @return the imageXPath
	 */
	public String getImageXPath() {
		return imageXPath;
	}

	/**
	 * @param imageXPath the imageXPath to set
	 */
	public void setImageXPath(String imageXPath) {
		this.imageXPath = imageXPath;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
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

	/**
	 * @return the recipeRatingImagePath
	 */
	public String getRecipeRatingImagePath() {
		return recipeRatingImagePath;
	}

	/**
	 * @param recipeRatingImagePath the recipeRatingImagePath to set
	 */
	public void setRecipeRatingImagePath(String recipeRatingImagePath) {
		this.recipeRatingImagePath = recipeRatingImagePath;
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
	 * @return the hideProgram
	 */
	public boolean isHideProgram() {
		return hideProgram;
	}

	/**
	 * @param hideProgram the hideProgram to set
	 */
	public void setHideProgram(boolean hideProgram) {
		this.hideProgram = hideProgram;
	}
	
	
	
}
