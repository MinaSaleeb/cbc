package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the food_suppliers database table.
 * 
 */
@Entity
@Table(name="food_suppliers")
@NamedQuery(name="FoodSupplier.findAll", query="SELECT f FROM FoodSupplier f")
public class FoodSupplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="supplier_logo_path")
	private String supplierLogoPath;

	@Column(name="supplier_name")
	private String supplierName;

	//bi-directional many-to-one association to FoodItem
	@OneToMany(mappedBy="foodSupplier")
	private List<FoodItem> foodItems;

	public FoodSupplier() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSupplierLogoPath() {
		return this.supplierLogoPath;
	}

	public void setSupplierLogoPath(String supplierLogoPath) {
		this.supplierLogoPath = supplierLogoPath;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<FoodItem> getFoodItems() {
		return this.foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public FoodItem addFoodItem(FoodItem foodItem) {
		getFoodItems().add(foodItem);
		foodItem.setFoodSupplier(this);

		return foodItem;
	}

	public FoodItem removeFoodItem(FoodItem foodItem) {
		getFoodItems().remove(foodItem);
		foodItem.setFoodSupplier(null);

		return foodItem;
	}

}