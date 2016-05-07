package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the presenters database table.
 * 
 */
@Entity
@Table(name="presenters")
public class Presenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	@Column(name="photo_path")
	private String photoPath;

	//bi-directional many-to-one association to Recipe
	@OneToMany(mappedBy="presenter")
	private List<Recipe> recipes;

	//bi-directional many-to-many association to Program
	@ManyToMany(mappedBy="presenters")
	private List<Program> programs;

	public Presenter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public Recipe addRecipe(Recipe recipe) {
		getRecipes().add(recipe);
		recipe.setPresenter(this);

		return recipe;
	}

	public Recipe removeRecipe(Recipe recipe) {
		getRecipes().remove(recipe);
		recipe.setPresenter(null);

		return recipe;
	}

	public List<Program> getPrograms() {
		return this.programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

}