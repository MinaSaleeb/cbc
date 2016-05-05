package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the episodes database table.
 * 
 */
@Entity
@Table(name="episodes")
@NamedQuery(name="Episode.findAll", query="SELECT e FROM Episode e")
public class Episode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Column(name="number_of_views")
	private BigInteger numberOfViews;

	private String title;

	private String url;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="program")
	private Program programBean;

	//bi-directional many-to-one association to Recipe
	@OneToMany(mappedBy="episodeBean")
	private List<Recipe> recipes;

	public Episode() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getNumberOfViews() {
		return this.numberOfViews;
	}

	public void setNumberOfViews(BigInteger numberOfViews) {
		this.numberOfViews = numberOfViews;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Program getProgramBean() {
		return this.programBean;
	}

	public void setProgramBean(Program programBean) {
		this.programBean = programBean;
	}

	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public Recipe addRecipe(Recipe recipe) {
		getRecipes().add(recipe);
		recipe.setEpisodeBean(this);

		return recipe;
	}

	public Recipe removeRecipe(Recipe recipe) {
		getRecipes().remove(recipe);
		recipe.setEpisodeBean(null);

		return recipe;
	}

}