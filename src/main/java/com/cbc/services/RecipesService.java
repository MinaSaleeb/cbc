/**
 * 
 */
package com.cbc.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.repository.RecipeRepository;

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
	
	
}
