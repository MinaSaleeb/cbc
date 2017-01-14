/**
 * 
 */
package com.cbc.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.Recipe;
import com.cbc.model.RecipeCategory;
import com.cbc.model.RecipeCuisine;
import com.cbc.services.RecipesService;
import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
@Transactional
@CrossOrigin("*")
@RestController
@RequestMapping("/recipe")
public class RecipeRestController 
{
	private static final Logger LOGGER = Logger.getLogger(RecipeRestController.class);
	
	@Autowired
	private RecipesService recipesService;
	
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<com.cbc.domain.recipe.RecipeCategory>> getRecipesCategories()
	{
		List<RecipeCategory> categoriesList = recipesService.getAllRecipesCategories();
		if(categoriesList != null && !categoriesList.isEmpty())
		{
			return new ResponseEntity<List<com.cbc.domain.recipe.RecipeCategory>>(ModelToDomainMapper.mapRecipesCategoryList(categoriesList) , HttpStatus.OK);
		}
		
		return  new ResponseEntity<List<com.cbc.domain.recipe.RecipeCategory>>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/categories/{slug}/recipes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<com.cbc.domain.recipe.Recipe>> getRecipesByCategory(@PathVariable("slug") String slug)
	{
		List<Recipe> recipesList = recipesService.getRecipesByCategorySlug(slug);
		if(recipesList != null && !recipesList.isEmpty())
		{
			return new ResponseEntity<List<com.cbc.domain.recipe.Recipe>>(ModelToDomainMapper.mapRecipesList(recipesList), HttpStatus.OK);
		}
		
		return  new ResponseEntity<List<com.cbc.domain.recipe.Recipe>>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/mostViewed", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<com.cbc.domain.recipe.Recipe>> getMostViewedRecipes(@RequestParam(required = true , value = "size") int size)
	{
		return  new ResponseEntity<List<com.cbc.domain.recipe.Recipe>>(ModelToDomainMapper.mapRecipesList(recipesService.getMostViewedRecipes(size)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/selectedForYou", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<com.cbc.domain.recipe.Recipe>> getSelectedForYouRecipes(@RequestParam(required = true , value = "size") int size)
	{
		return  new ResponseEntity<List<com.cbc.domain.recipe.Recipe>>(ModelToDomainMapper.mapRecipesList(recipesService.getSelectedForYouRecipes(size)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/membersRecipes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<com.cbc.domain.recipe.Recipe>> getMembersRecipes(@RequestParam(required = true , value = "size") int size)
	{
		return  new ResponseEntity<List<com.cbc.domain.recipe.Recipe>>(ModelToDomainMapper.mapRecipesList(recipesService.getMembersRecipes(size)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cuisines", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<com.cbc.model.RecipeCuisine>> getRecipesCuisines()
	{
		List<RecipeCuisine> cuisinesList = recipesService.getAllRecipesCuisines();
		if(cuisinesList != null && !cuisinesList.isEmpty())
		{
			return new ResponseEntity<List<com.cbc.model.RecipeCuisine>>(cuisinesList , HttpStatus.OK);
		}
		
		return  new ResponseEntity<List<com.cbc.model.RecipeCuisine>>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value = "/today", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<com.cbc.domain.recipe.Recipe>> getTodayRecipes()
	{
		//return new ResponseEntity<List<TodayRecipeDataRow>>(recipesService.getTodayRecipes() , HttpStatus.OK);
		return new ResponseEntity<List<com.cbc.domain.recipe.Recipe>>(ModelToDomainMapper.mapRecipesList(recipesService.getTodayRecipes2()) , HttpStatus.OK);
	}
	
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<com.cbc.domain.recipe.Recipe> getRecipeById(@PathVariable("id") String recipeId)
	 {
		Recipe recipe = recipesService.getRecipeBySlug(recipeId);
		 
		 if(recipe == null)
		 {
			 LOGGER.error("recipeId {"+recipeId+"} is not found in DB");
			 return new ResponseEntity<com.cbc.domain.recipe.Recipe>(HttpStatus.NOT_FOUND);
		 }
		 
		 return new ResponseEntity<com.cbc.domain.recipe.Recipe>(new com.cbc.domain.recipe.Recipe(recipe) , HttpStatus.OK);
	 }
	
	 @RequestMapping(value = "/getByCheifId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.recipe.Recipe>> getRecipesByChieflId(@RequestParam(required = true , value = "cheifId") int cheifId)
	 {
		 return new ResponseEntity<List<com.cbc.domain.recipe.Recipe>>(ModelToDomainMapper.mapRecipesList(recipesService.getRecipesByCheifId(cheifId)), HttpStatus.OK);
	 }
	
	
	 @RequestMapping(value = "/{id}/rate", method = RequestMethod.PUT)
	 public ResponseEntity<?> rateRecipe(@PathVariable("id") long recipeId , @RequestParam(required = true , value = "ratingVal") float ratingVal)
	 {
		try 
		{
			recipesService.rateRecipe(recipeId, ratingVal);
		} catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/{id}/incrementViews", method = RequestMethod.PUT)
	 public ResponseEntity<?> increaseNumberOfViewsForRecipe(@PathVariable("id") long recipeId)
	 {
		try 
		{
			recipesService.incrementNumberOfViews(recipeId);
		} catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	 	@RequestMapping(value = "/foodTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<com.cbc.domain.recipe.FoodType>> getFoodTypes()
		{
			return  new ResponseEntity<List<com.cbc.domain.recipe.FoodType>>(ModelToDomainMapper.mapFoodTypesList(recipesService.getAllFoodTypes()), HttpStatus.OK);
		}
	 	
	 	@RequestMapping(value = "/foodTypes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<com.cbc.domain.recipe.FoodType> getFoodTypeById(@PathVariable("id") int id)
		{
			return  new ResponseEntity<com.cbc.domain.recipe.FoodType>(new com.cbc.domain.recipe.FoodType(recipesService.getFoodTypeById(id)), HttpStatus.OK);
		}
	 	
	 	@RequestMapping(value = "/foodItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<com.cbc.domain.recipe.FoodItem>> getFoodItems()
		{
			return  new ResponseEntity<List<com.cbc.domain.recipe.FoodItem>>(ModelToDomainMapper.mapFoodItemsList(recipesService.getAllFoodItems()), HttpStatus.OK);
		}
	 	
	 	@RequestMapping(value = "/foodItems/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<com.cbc.domain.recipe.FoodItem> getFoodItemById(@PathVariable("id") long id)
		{
			return  new ResponseEntity<com.cbc.domain.recipe.FoodItem>(new com.cbc.domain.recipe.FoodItem(recipesService.getFoodItemById(id)), HttpStatus.OK);
		}
}
