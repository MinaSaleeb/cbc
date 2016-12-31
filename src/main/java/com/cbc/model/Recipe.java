package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the recipes database table.
 * 
 */
@Entity
@Table(name="recipes")
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="avg_rating")
	private float avgRating;

	@Column(name="is_selected_for_u")
	private boolean selectedForU;

	@Column(name="number_of_rates")
	private int numberOfRates;

	@Column(name="photo_path")
	private String photoPath;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="recipe_date")
	private Date recipeDate;

	private String tags;

	private String title;
	
	private short status;
	
	@Column(length = 500, unique = true)
	@NotNull
	private String slug;
	
	@Column(name="number_of_views")
	private long numberOfViews;
	
	@Transient
	private float displayedRating;

	//bi-directional many-to-one association to Episode
	@ManyToOne
	@JoinColumn(name="episode")
	private Episode episodeBean;

	//bi-directional many-to-one association to Presenter
	@ManyToOne
	@JoinColumn(name="chief")
	private Presenter presenter;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="program")
	private Program programBean;

	//bi-directional many-to-one association to RecipeCategory
	@ManyToOne
	@JoinColumn(name="category")
	private RecipeCategory recipeCategory;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user")
	private User userBean;

	//bi-directional many-to-one association to RecipeIngredient
	@OneToMany(mappedBy="recipeBean")
	private List<RecipeIngredient> recipeIngredients;

	//bi-directional many-to-one association to RecipeStep
	@OneToMany(mappedBy="recipeBean")
	private List<RecipeStep> recipeSteps;

	//bi-directional many-to-one association to RecipeType
	@ManyToOne
	@JoinColumn(name="recipe_type")
	private RecipeType recipeType;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="recipes2")
	private List<User> users;
	
	@ManyToOne
	@JoinColumn(name="cuisine")
	private RecipeCuisine cuisine;

	public Recipe() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getAvgRating() {
		return this.avgRating;
	}

	public void setAvgRating(float avgRating) {
		this.avgRating = avgRating;
	}

	public boolean isSelectedForU() {
		return this.selectedForU;
	}

	public void setSelectedForU(boolean isSelectedForU) {
		this.selectedForU = isSelectedForU;
	}

	public int getNumberOfRates() {
		return this.numberOfRates;
	}

	public void setNumberOfRates(int numberOfRates) {
		this.numberOfRates = numberOfRates;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Date getRecipeDate() {
		return this.recipeDate;
	}

	public void setRecipeDate(Date recipeDate) {
		this.recipeDate = recipeDate;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Episode getEpisodeBean() {
		return this.episodeBean;
	}

	public void setEpisodeBean(Episode episodeBean) {
		this.episodeBean = episodeBean;
	}

	public Presenter getPresenter() {
		return this.presenter;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public Program getProgramBean() {
		return this.programBean;
	}

	public void setProgramBean(Program programBean) {
		this.programBean = programBean;
	}

	public RecipeCategory getRecipeCategory() {
		return this.recipeCategory;
	}

	public void setRecipeCategory(RecipeCategory recipeCategory) {
		this.recipeCategory = recipeCategory;
	}

	public User getUserBean() {
		return this.userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

	public List<RecipeIngredient> getRecipeIngredients() {
		return this.recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	/**
	 * @return the cuisine
	 */
	public RecipeCuisine getCuisine() {
		return cuisine;
	}

	/**
	 * @param cuisine the cuisine to set
	 */
	public void setCuisine(RecipeCuisine cuisine) {
		this.cuisine = cuisine;
	}

	public RecipeIngredient addRecipeIngredient(RecipeIngredient recipeIngredient) {
		getRecipeIngredients().add(recipeIngredient);
		recipeIngredient.setRecipeBean(this);

		return recipeIngredient;
	}

	public RecipeIngredient removeRecipeIngredient(RecipeIngredient recipeIngredient) {
		getRecipeIngredients().remove(recipeIngredient);
		recipeIngredient.setRecipeBean(null);

		return recipeIngredient;
	}

	public List<RecipeStep> getRecipeSteps() {
		return this.recipeSteps;
	}

	public void setRecipeSteps(List<RecipeStep> recipeSteps) {
		this.recipeSteps = recipeSteps;
	}

	public RecipeStep addRecipeStep(RecipeStep recipeStep) {
		getRecipeSteps().add(recipeStep);
		recipeStep.setRecipeBean(this);

		return recipeStep;
	}

	public RecipeStep removeRecipeStep(RecipeStep recipeStep) {
		getRecipeSteps().remove(recipeStep);
		recipeStep.setRecipeBean(null);

		return recipeStep;
	}

	public RecipeType getRecipeType() {
		return this.recipeType;
	}

	public void setRecipeType(RecipeType recipeType) {
		this.recipeType = recipeType;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the displayedRating
	 */
	@Transient
	public float getDisplayedRating() 
	{
		return avgRating/numberOfRates;
	}

	/**
	 * @return the status
	 */
	public short getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(short status) {
		this.status = status;
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

	/**
	 * @return the numberOfViews
	 */
	public long getNumberOfViews() {
		return numberOfViews;
	}

	/**
	 * @param numberOfViews the numberOfViews to set
	 */
	public void setNumberOfViews(long numberOfViews) {
		this.numberOfViews = numberOfViews;
	}

}