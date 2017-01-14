package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recipe_ingredients database table.
 * 
 */
@Entity
@Table(name="recipe_ingredients")
public class RecipeIngredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="ingredient_content")
	private String ingredientContent;
	
	private String tags;

	//bi-directional many-to-one association to FoodItem
	@ManyToOne
	@JoinColumn(name="linked_food_item")
	private FoodItem foodItem;

	//bi-directional many-to-one association to Recipe
	@ManyToOne
	@JoinColumn(name="recipe")
	private Recipe recipeBean;

	public RecipeIngredient() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIngredientContent() {
		return this.ingredientContent;
	}

	public void setIngredientContent(String ingredientContent) {
		this.ingredientContent = ingredientContent;
	}

	public FoodItem getFoodItem() {
		return this.foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public Recipe getRecipeBean() {
		return this.recipeBean;
	}

	public void setRecipeBean(Recipe recipeBean) {
		this.recipeBean = recipeBean;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

}