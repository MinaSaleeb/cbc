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
	
	@Column(name="photo_path_1")
	private String photoPath1;
	
	@Column(name="photo_path_2")
	private String photoPath2;
	
	@Column(name="photo_path_3")
	private String photoPath3;
	
	private String slug;
	
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

	/**
	 * @return the photoPath1
	 */
	public String getPhotoPath1() {
		return photoPath1;
	}

	/**
	 * @param photoPath1 the photoPath1 to set
	 */
	public void setPhotoPath1(String photoPath1) {
		this.photoPath1 = photoPath1;
	}

	/**
	 * @return the photoPath2
	 */
	public String getPhotoPath2() {
		return photoPath2;
	}

	/**
	 * @param photoPath2 the photoPath2 to set
	 */
	public void setPhotoPath2(String photoPath2) {
		this.photoPath2 = photoPath2;
	}

	/**
	 * @return the photoPath3
	 */
	public String getPhotoPath3() {
		return photoPath3;
	}

	/**
	 * @param photoPath3 the photoPath3 to set
	 */
	public void setPhotoPath3(String photoPath3) {
		this.photoPath3 = photoPath3;
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