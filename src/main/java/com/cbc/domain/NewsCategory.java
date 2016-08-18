/**
 * 
 */
package com.cbc.domain;

import java.util.List;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class NewsCategory 
{
	private int id;
	
	private String categoryName;
	
	private String bgImage;
	
	private NewsCategory parentCategory;
	
	private List<NewsCategory> subCategories;
	
	
	

	/**
	 * 
	 */
	public NewsCategory(com.cbc.model.NewsCategory cat) 
	{
		super();
		ModelToDomainMapper.mapNewsCategory(cat, this);
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
	 * @return the bgImage
	 */
	public String getBgImage() {
		return bgImage;
	}

	/**
	 * @param bgImage the bgImage to set
	 */
	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}

	/**
	 * @return the parentCategory
	 */
	public NewsCategory getParentCategory() {
		return parentCategory;
	}

	/**
	 * @param parentCategory the parentCategory to set
	 */
	public void setParentCategory(NewsCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	/**
	 * @return the subCategories
	 */
	public List<NewsCategory> getSubCategories() {
		return subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(List<NewsCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
	
}
