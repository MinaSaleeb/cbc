package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the food_items database table.
 * 
 */
@Entity
@Table(name="food_items")
public class FoodItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="from_price")
	private double fromPrice;

	@Column(name="item_name")
	private String itemName;

	@Column(name="to_price")
	private double toPrice;
	
	@Column(name="number_of_calories")
	private double numberOfCalories;
	
	@Column(name="ad_image", length = 500)
	private String adImage;
	
	@Column(length = 500)
	private String url;
	
	@Column(length = 800)
	private String description;

	//bi-directional many-to-one association to FoodSupplier
	@ManyToOne
	@JoinColumn(name="supplier")
	private FoodSupplier foodSupplier;

	//bi-directional many-to-one association to FoodType
	@ManyToOne
	@JoinColumn(name="food_type")
	private FoodType foodType;

	//bi-directional many-to-one association to RecipeIngredient
	@OneToMany(mappedBy="foodItem")
	private List<RecipeIngredient> recipeIngredients;
	
	@ManyToOne
	@JoinColumn(name="measure_unit")
	private MeasureUnit measureUnit;
	
	private double amount;
	
	@Column(name = "thumbnail_img",length = 500)
	private String thumbnailImage;
	
	@Column(name = "alternative_names",length = 1000)
	private String alternativeNames;
	
	public FoodItem() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getFromPrice() {
		return this.fromPrice;
	}

	public void setFromPrice(double fromPrice) {
		this.fromPrice = fromPrice;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getToPrice() {
		return this.toPrice;
	}

	public void setToPrice(double toPrice) {
		this.toPrice = toPrice;
	}

	public FoodSupplier getFoodSupplier() {
		return this.foodSupplier;
	}

	public void setFoodSupplier(FoodSupplier foodSupplier) {
		this.foodSupplier = foodSupplier;
	}

	public FoodType getFoodType() {
		return this.foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public List<RecipeIngredient> getRecipeIngredients() {
		return this.recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	public RecipeIngredient addRecipeIngredient(RecipeIngredient recipeIngredient) {
		getRecipeIngredients().add(recipeIngredient);
		recipeIngredient.setFoodItem(this);

		return recipeIngredient;
	}

	public RecipeIngredient removeRecipeIngredient(RecipeIngredient recipeIngredient) {
		getRecipeIngredients().remove(recipeIngredient);
		recipeIngredient.setFoodItem(null);

		return recipeIngredient;
	}

	/**
	 * @return the numberOfCalories
	 */
	public double getNumberOfCalories() {
		return numberOfCalories;
	}

	/**
	 * @param numberOfCalories the numberOfCalories to set
	 */
	public void setNumberOfCalories(double numberOfCalories) {
		this.numberOfCalories = numberOfCalories;
	}

	/**
	 * @return the adImage
	 */
	public String getAdImage() {
		return adImage;
	}

	/**
	 * @param adImage the adImage to set
	 */
	public void setAdImage(String adImage) {
		this.adImage = adImage;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the measureUnit
	 */
	public MeasureUnit getMeasureUnit() {
		return measureUnit;
	}

	/**
	 * @param measureUnit the measureUnit to set
	 */
	public void setMeasureUnit(MeasureUnit measureUnit) {
		this.measureUnit = measureUnit;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the thumbnailImage
	 */
	public String getThumbnailImage() {
		return thumbnailImage;
	}

	/**
	 * @param thumbnailImage the thumbnailImage to set
	 */
	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	/**
	 * @return the alternativeNames
	 */
	public String getAlternativeNames() {
		return alternativeNames;
	}

	/**
	 * @param alternativeNames the alternativeNames to set
	 */
	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

}