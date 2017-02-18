/**
 * 
 */
package com.cbc.domain.recipe;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina
 *
 */
public class Ingredient
{
	private String content;
	private String quantity;
	private String measureUnit;
	private FoodItem foodItem;
	

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
	public Ingredient(com.cbc.model.RecipeIngredient ri) {
		super();
		ModelToDomainMapper.mapRecipeIngredient(ri, this);
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the measureUnit
	 */
	public String getMeasureUnit() {
		return measureUnit;
	}

	/**
	 * @param measureUnit the measureUnit to set
	 */
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	/**
	 * @return the foodItem
	 */
	public FoodItem getFoodItem() {
		return foodItem;
	}

	/**
	 * @param foodItem the foodItem to set
	 */
	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}
	
	
}
