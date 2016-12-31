/**
 * 
 */
package com.cbc.domain.recipe;

/**
 * @author Mina
 *
 */
public class RecipeType
{
	private String name;
	private String image;
	/**
	 * @param name
	 * @param image
	 */
	public RecipeType(String name, String image) {
		super();
		this.name = name;
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
}

