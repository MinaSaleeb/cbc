/**
 * 
 */
package com.cbc.domain.recipe;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
public class FoodItem 
{
	private long id;
	private double fromPrice;
	private String itemName;
	private double toPrice;
	private double numberOfCalories;
	private String adImage;
	private String url;
	private String description;
	private double amount;
	private String measureUnit;
	
	
	public FoodItem(com.cbc.model.FoodItem fi) {
		super();
		ModelToDomainMapper.mapFoodItem(fi, this);
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the fromPrice
	 */
	public double getFromPrice() {
		return fromPrice;
	}
	/**
	 * @param fromPrice the fromPrice to set
	 */
	public void setFromPrice(double fromPrice) {
		this.fromPrice = fromPrice;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the toPrice
	 */
	public double getToPrice() {
		return toPrice;
	}
	/**
	 * @param toPrice the toPrice to set
	 */
	public void setToPrice(double toPrice) {
		this.toPrice = toPrice;
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
	 * @return the measureUnit
	 */
	public String getMeasureUnit() {
		return measureUnit;
	}
	/**
	 * @param measureUnit the measureUnit to set
	 */
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	
	
	

}
