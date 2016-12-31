/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cbc.domain.TodayRecipeDataRow;
import com.cbc.model.Recipe;
import com.cbc.model.RecipeCategory;
import com.cbc.model.RecipeCuisine;
import com.cbc.repository.RecipeCategoryRepository;
import com.cbc.repository.RecipeCuisineRepository;
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
	
	@Autowired
	private RecipeCategoryRepository recipeCategoryRepo;
	
	@Autowired
	private RecipeCuisineRepository recipeCuisineRepo;
	
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
	
	public List<Recipe> getTodayRecipes2()
	{
		return  recipeRepo.findByRecipeDate(TimeUtils.getTodayDate());
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
		PageRequest page = new PageRequest(0, 20);
		return recipeRepo.findByCheifId(cheifId, page);
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
	
	public void incrementNumberOfViews(long recipeId) throws Exception
	{
		Recipe recipe = recipeRepo.findOne(recipeId);
		
		if(recipe != null)
		{
			recipe.setNumberOfViews(recipe.getNumberOfViews()+1);
			recipeRepo.save(recipe);
		}
		else
		{
			LOGGER.error("recipeId {"+recipeId+"} is not found in DB");
			throw new Exception();
		}
	}
	
	public List<RecipeCategory> getAllRecipesCategories()
	{
		return (List<RecipeCategory>) recipeCategoryRepo.findAll();
	}
	
	public RecipeCategory getRecipeCategoryBySlug(String slug)
	{
		return recipeCategoryRepo.findBySlug(slug.trim());
	}
	
	public List<RecipeCuisine> getAllRecipesCuisines()
	{
		return (List<RecipeCuisine>) recipeCuisineRepo.findAll();
	}
	
	public Recipe getRecipeBySlug(String slug)
	{
		return recipeRepo.findBySlug(slug.trim());
	}
	
	public List<Recipe> getRecipesByCategorySlug(String slug)
	{
		RecipeCategory cat = getRecipeCategoryBySlug(slug);
		
		return cat.getRecipes();
	}
	
	public List<Recipe> getMostViewedRecipes(int size)
	{
		PageRequest page = new PageRequest(0, size);
		return recipeRepo.getMostViewed(page);
	}
	
	public List<Recipe> getSelectedForYouRecipes(int size)
	{
		PageRequest page = new PageRequest(0, size);
		return recipeRepo.findBySelectedForUOrderByRecipeDateDesc(true, page);
	}
	
	public List<Recipe> getMembersRecipes(int size)
	{
		PageRequest page = new PageRequest(0, size);
		return recipeRepo.getMembersRecipes(page);
	}
}
