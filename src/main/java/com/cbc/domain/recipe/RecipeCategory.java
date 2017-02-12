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
	
	private String thumbnailImage;
	
	private String icon;
	
	private List<RecipeCategory> subCategories;
	
	private List<Recipe> recipes;
	
	public RecipeCategory(com.cbc.model.RecipeCategory cat,boolean includeRecipes,Integer numOfIncludedRecipes) 
	{
		super();
		ModelToDomainMapper.mapRecipesCategory(cat, this,includeRecipes,numOfIncludedRecipes);
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

	/**
	 * @return the recipes
	 */
	public List<Recipe> getRecipes() {
		return recipes;
	}

	/**
	 * @param recipes the recipes to set
	 */
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
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
	
	
}
