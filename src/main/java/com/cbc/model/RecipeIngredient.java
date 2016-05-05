package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recipe_ingredients database table.
 * 
 */
@Entity
@Table(name="recipe_ingredients")
@NamedQuery(name="RecipeIngredient.findAll", query="SELECT r FROM RecipeIngredient r")
public class RecipeIngredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Column(name="ingredient_content")
	private String ingredientContent;

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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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

}