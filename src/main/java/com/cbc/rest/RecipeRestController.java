/**
 * 
 */
package com.cbc.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.services.RecipesService;

/**
 * @author Mina Saleeb
 *
 */
@RestController
@RequestMapping("/recipe")
public class RecipeRestController 
{
	private static final Logger LOGGER = Logger.getLogger(RecipeRestController.class);
	
	@Autowired
	private RecipesService recipesService;
	
	
	
	
}
