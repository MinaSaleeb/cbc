/**
 * 
 */
package com.cbc.domain.recipe;

import java.util.ArrayList;
import java.util.List;

import com.cbc.domain.Presenter;

/**
 * @author Mina Saleeb
 *
 */
public class Chief extends Presenter 
{
	private List<Recipe> recipes;
	
	public Chief(com.cbc.model.Presenter p, boolean includeRecipes, Integer numOfIncludedRecipes) 
	{
		super(p);
		if(includeRecipes)
		{
			if(p.getRecipes() != null && !p.getRecipes().isEmpty())
			{
				recipes = new ArrayList<Recipe>();
				for(com.cbc.model.Recipe r : numOfIncludedRecipes != null?p.getRecipes().subList(0,p.getRecipes().size() <= numOfIncludedRecipes ? p.getRecipes().size() : numOfIncludedRecipes) : p.getRecipes())
				{
					//filter child Recipes from first level
					if(r.getParentRecipe() == null)
					{
						recipes.add(new com.cbc.domain.recipe.Recipe(r));
					}
				}
			}
		}
	}

	/**
	 * @return the recipes
	 */
	public List<Recipe> getRecipes() {
		return recipes;
	}

	/**
	 * @param recipes the recipes to set
	 */
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}
