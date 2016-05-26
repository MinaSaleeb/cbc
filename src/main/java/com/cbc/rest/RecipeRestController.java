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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.domain.TodayRecipeDataRow;
import com.cbc.model.Recipe;
import com.cbc.services.RecipesService;

/**
 * @author Mina Saleeb
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/recipe")
public class RecipeRestController 
{
	private static final Logger LOGGER = Logger.getLogger(RecipeRestController.class);
	
	@Autowired
	private RecipesService recipesService;
	
	@RequestMapping(value = "/today", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TodayRecipeDataRow>> getTodayRecipes()
	{
		return new ResponseEntity<List<TodayRecipeDataRow>>(recipesService.getTodayRecipes() , HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") long recipeId)
	 {
		Recipe recipe = recipesService.getRecipeById(recipeId);
		 
		 if(recipe == null)
		 {
			 LOGGER.error("recipeId {"+recipeId+"} is not found in DB");
			 return new ResponseEntity<Recipe>(HttpStatus.NOT_FOUND);
		 }
		 
		 return new ResponseEntity<Recipe>(recipe , HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/getByCheifId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Recipe>> getProgramsNamesByChannelId(@RequestParam(required = true , value = "cheifId") int cheifId)
	 {
		 return new ResponseEntity<List<Recipe>>(recipesService.getRecipesByCheifId(cheifId), HttpStatus.OK);
	 }
	
	
	@RequestMapping(value = "/{id}/rate", method = RequestMethod.PUT)
	 public ResponseEntity rateRecipe(@PathVariable("id") long recipeId , @RequestParam(required = true , value = "ratingVal") float ratingVal)
	 {
		try 
		{
			recipesService.rateRecipe(recipeId, ratingVal);
		} catch (Exception e) 
		{
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(HttpStatus.OK);
	 }
}
