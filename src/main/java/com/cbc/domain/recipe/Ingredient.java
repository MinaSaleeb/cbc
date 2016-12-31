/**
 * 
 */
package com.cbc.domain.recipe;

/**
 * @author Mina
 *
 */
public class Ingredient
{
	private String content;

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
	 * @param content
	 */
	public Ingredient(String content) {
		super();
		this.content = content;
	}
	
	
}
