package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the food_types database table.
 * 
 */
@Entity
@Table(name="food_types")
@NamedQuery(name="FoodType.findAll", query="SELECT f FROM FoodType f")
public class FoodType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="type_name")
	private String typeName;

	//bi-directional many-to-one association to FoodItem
	@OneToMany(mappedBy="foodType")
	private List<FoodItem> foodItems;

	public FoodType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<FoodItem> getFoodItems() {
		return this.foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public FoodItem addFoodItem(FoodItem foodItem) {
		getFoodItems().add(foodItem);
		foodItem.setFoodType(this);

		return foodItem;
	}

	public FoodItem removeFoodItem(FoodItem foodItem) {
		getFoodItems().remove(foodItem);
		foodItem.setFoodType(null);

		return foodItem;
	}

}