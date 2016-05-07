/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Recipe;

/**
 * @author Mina Saleeb
 *
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> 
{

}
