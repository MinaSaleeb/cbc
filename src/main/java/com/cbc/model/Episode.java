package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the episodes database table.
 * 
 */
@Entity
@Table(name="episodes")
public class Episode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="number_of_views")
	private BigInteger numberOfViews;

	private String title;

	private String url;
	
	@Temporal(TemporalType.DATE)
	@Column(name="displaying_date")
	private Date displayingDate;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="program")
	private Program programBean;

	//bi-directional many-to-one association to Recipe
	@OneToMany(mappedBy="episodeBean")
	private List<Recipe> recipes;

	public Episode() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	/**
	 * @return the displayingDate
	 */
	public Date getDisplayingDate() {
		return displayingDate;
	}

	/**
	 * @param displayingDate the displayingDate to set
	 */
	public void setDisplayingDate(Date displayingDate) {
		this.displayingDate = displayingDate;
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