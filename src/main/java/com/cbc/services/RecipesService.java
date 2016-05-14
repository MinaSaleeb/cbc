/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.domain.TodayRecipeDataRow;
import com.cbc.model.Recipe;
import com.cbc.repository.RecipeRepository;
import com.cbc.util.TimeUtils;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class RecipesService 
{
	private static final Logger LOGGER = Logger.getLogger(RecipesService.class);
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	/**
	 * 
	 * @return
	 */
	public List<TodayRecipeDataRow> getTodayRecipes()
	{
		List<TodayRecipeDataRow> todayRecipeList = new ArrayList<TodayRecipeDataRow>();
		
		List<Recipe> todayRecipes = recipeRepo.findByRecipeDate(TimeUtils.getTodayDate());
		
		if(todayRecipes != null && !todayRecipes.isEmpty())
		{
			for(Recipe recipe : todayRecipes)
			{
				TodayRecipeDataRow recipeRow = new TodayRecipeDataRow(recipe);
				if(recipeRow.getProgramName() != null && recipeRow.getChiefName() != null)
				{
					todayRecipeList.add(recipeRow);
				}
			}
		}
		
		return todayRecipeList;
	}
	
	/**
	 * 
	 * 
	 * @param recipeId
	 * @return
	 */
	public Recipe getRecipeById(long recipeId)
	{
		return recipeRepo.findOne(recipeId);
	}
	
	/**
	 * 
	 * @param cheifId
	 * @return
	 */
	public List<Recipe> getRecipesByCheifId(int cheifId)
	{
		return recipeRepo.findByCheifId(cheifId);
	}
	
	public void rateRecipe(long recipeId , float ratingVal) throws Exception
	{
		Recipe recipe = recipeRepo.findOne(recipeId);
		
		if(recipe != null)
		{
			recipe.setNumberOfRates(recipe.getNumberOfRates()+1);
			recipe.setAvgRating(recipe.getAvgRating()+ratingVal);
			recipeRepo.save(recipe);
		}
		else
		{
			LOGGER.error("recipeId {"+recipeId+"} is not found in DB");
			throw new Exception();
		}
	}
	
	
}
