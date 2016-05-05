package com.cbc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recipe_steps database table.
 * 
 */
@Entity
@Table(name="recipe_steps")
@NamedQuery(name="RecipeStep.findAll", query="SELECT r FROM RecipeStep r")
public class RecipeStep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Column(name="end_time")
	private double endTime;

	@Column(name="start_time")
	private double startTime;

	@Column(name="step_content")
	private String stepContent;

	//bi-directional many-to-one association to Recipe
	@ManyToOne
	@JoinColumn(name="recipe")
	private Recipe recipeBean;

	public RecipeStep() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getEndTime() {
		return this.endTime;
	}

	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	public double getStartTime() {
		return this.startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public String getStepContent() {
		return this.stepContent;
	}

	public void setStepContent(String stepContent) {
		this.stepContent = stepContent;
	}

	public Recipe getRecipeBean() {
		return this.recipeBean;
	}

	public void setRecipeBean(Recipe recipeBean) {
		this.recipeBean = recipeBean;
	}

}