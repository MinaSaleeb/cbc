package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the recipe_categories database table.
 * 
 */
@Entity
@Table(name="recipe_categories")
@NamedQuery(name="RecipeCategory.findAll", query="SELECT r FROM RecipeCategory r")
public class RecipeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to RecipeCategory
	@ManyToOne
	@JoinColumn(name="parent_category")
	private RecipeCategory recipeCategory;

	//bi-directional many-to-one association to RecipeCategory
	@OneToMany(mappedBy="recipeCategory")
	private List<RecipeCategory> recipeCategories;

	//bi-directional many-to-one association to Recipe
	@OneToMany(mappedBy="recipeCategory")
	private List<Recipe> recipes;

	public RecipeCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RecipeCategory getRecipeCategory() {
		return this.recipeCategory;
	}

	public void setRecipeCategory(RecipeCategory recipeCategory) {
		this.recipeCategory = recipeCategory;
	}

	public List<RecipeCategory> getRecipeCategories() {
		return this.recipeCategories;
	}

	public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
		this.recipeCategories = recipeCategories;
	}

	public RecipeCategory addRecipeCategory(RecipeCategory recipeCategory) {
		getRecipeCategories().add(recipeCategory);
		recipeCategory.setRecipeCategory(this);

		return recipeCategory;
	}

	public RecipeCategory removeRecipeCategory(RecipeCategory recipeCategory) {
		getRecipeCategories().remove(recipeCategory);
		recipeCategory.setRecipeCategory(null);

		return recipeCategory;
	}

	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public Recipe addRecipe(Recipe recipe) {
		getRecipes().add(recipe);
		recipe.setRecipeCategory(this);

		return recipe;
	}

	public Recipe removeRecipe(Recipe recipe) {
		getRecipes().remove(recipe);
		recipe.setRecipeCategory(null);

		return recipe;
	}

}