/**
 * 
 */
package com.cbc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Mina Saleeb
 *
 */
@Entity
@Table(name = "recipe_cuisines")
public class RecipeCuisine implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(length = 500)
	private String image;
	
	@Column(length = 500)
	private String name;
	
	@Column(name = "thumbnail_image",length = 500)
	private String thumbnailImage;
	
	@Column(name = "thumbnail_img",length = 500)
	private String icon;
	
	@ManyToMany
	@JoinTable(name = "recipe_in_cuisine", joinColumns = { @JoinColumn(name = "Cuisines_id") }, inverseJoinColumns = {
			@JoinColumn(name = "recepies_id") })
	private List<Recipe> recipes;

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
