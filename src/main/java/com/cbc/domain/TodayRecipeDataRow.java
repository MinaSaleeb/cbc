/**
 * 
 */
package com.cbc.domain;

import com.cbc.model.Presenter;
import com.cbc.model.Program;
import com.cbc.model.Recipe;

/**
 * @author Mina Saleeb
 *
 */
public class TodayRecipeDataRow 
{
	private String chiefName;
	
	private String programName;
	
	private String recipeName;
	
	private long recipeId;

	/**
	 * @param recipeId
	 */
	public TodayRecipeDataRow(Recipe recipe) 
	{
		super();
		this.recipeId = recipe.getId();
		this.recipeName = recipe.getTitle();
		Presenter chief = recipe.getPresenter();
		if(chief != null)
		{
			this.chiefName = chief.getName();
		}
		Program program = recipe.getProgramBean();
		if(program != null)
		{
			this.programName = program.getTitle();
		}
	}

	/**
	 * @return the chiefName
	 */
	public String getChiefName() {
		return chiefName;
	}

	/**
	 * @param chiefName the chiefName to set
	 */
	public void setChiefName(String chiefName) {
		this.chiefName = chiefName;
	}

	/**
	 * @return the programName
	 */
	public String getProgramName() {
		return programName;
	}

	/**
	 * @param programName the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/**
	 * @return the recipeName
	 */
	public String getRecipeName() {
		return recipeName;
	}

	/**
	 * @param recipeName the recipeName to set
	 */
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	/**
	 * @return the recipeId
	 */
	public long getRecipeId() {
		return recipeId;
	}

	/**
	 * @param recipeId the recipeId to set
	 */
	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	} 
	
	
}
