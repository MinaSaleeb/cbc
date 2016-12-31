package com.cbc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the recipe_categories database table.
 * 
 */
@Entity
@Table(name="recipe_categories", uniqueConstraints = {@UniqueConstraint(columnNames = {"slug"})})
public class RecipeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;
	
	@Column(length = 500)
	private String image;
	
	@Column(length = 500)
	@NotNull
	private String slug;
	
	//bi-directional many-to-one association to RecipeCategory
	@ManyToOne
	@JoinColumn(name="parent_category")
	private RecipeCategory parentCategory;

	//bi-directional many-to-one association to RecipeCategory
	@OneToMany(mappedBy="parentCategory")
	private List<RecipeCategory> subCategories;

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

	public RecipeCategory getParentCategory() {
		return this.parentCategory;
	}

	public void setParentCategory(RecipeCategory parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<RecipeCategory> getSubCategories() {
		return this.subCategories;
	}

	public void setSubCategories(List<RecipeCategory> recipeCategories) {
		this.subCategories = recipeCategories;
	}

	public RecipeCategory addRecipeCategory(RecipeCategory recipeCategory) {
		getSubCategories().add(recipeCategory);
		recipeCategory.setParentCategory(this);

		return recipeCategory;
	}

	public RecipeCategory removeRecipeCategory(RecipeCategory recipeCategory) {
		getSubCategories().remove(recipeCategory);
		recipeCategory.setParentCategory(null);

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
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

}