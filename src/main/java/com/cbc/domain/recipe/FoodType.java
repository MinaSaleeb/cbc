/**
 * 
 */
package com.cbc.domain.recipe;

import java.util.List;

import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina
 *
 */
public class FoodType 
{
	private int id;
	private String name;
	private List<FoodItem> items;
	

	public FoodType(com.cbc.model.FoodType ft) {
		super();
		ModelToDomainMapper.mapFoodType(ft, this);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the items
	 */
	public List<FoodItem> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<FoodItem> items) {
		this.items = items;
	}
	
	
}
