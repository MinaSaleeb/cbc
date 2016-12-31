/**
 * 
 */
package com.cbc.domain.recipe;

import java.util.List;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class RecipeCategory 
{
	private String id;

	private String name;
	
	private String image;
	
	private List<RecipeCategory> subCategories;
	
	public RecipeCategory(com.cbc.model.RecipeCategory cat) 
	{
		super();
		ModelToDomainMapper.mapRecipesCategory(cat, this);
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the subCategories
	 */
	public List<RecipeCategory> getSubCategories() {
		return subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(List<RecipeCategory> subCategories) {
		this.subCategories = subCategories;
	} 
	
	
}
