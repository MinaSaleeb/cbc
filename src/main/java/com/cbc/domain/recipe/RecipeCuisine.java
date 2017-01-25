/**
 * 
 */
package com.cbc.domain.recipe;

import java.util.List;

import com.cbc.domain.recipe.Recipe;
import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina
 *
 */
public class RecipeCuisine
{
	private int id;
	
	private String image;
	
	private String name;
	
	private String thumbnailImage;
	
	private String icon;
	
	private List<Recipe> recipes;

	/**
	 * 
	 */
	public RecipeCuisine(com.cbc.model.RecipeCuisine c, boolean includeRecipes, Integer numOfIncludedRecipes) {
		super();
		ModelToDomainMapper.mapRecipeCuisine(c, this, includeRecipes, numOfIncludedRecipes);
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
