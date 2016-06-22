/**
 * 
 */
package com.cbc.domain;

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
	
	
}
