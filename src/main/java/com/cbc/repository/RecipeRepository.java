/**
 * 
 */
package com.cbc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.Recipe;

/**
 * @author Mina Saleeb
 *
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> 
{
	List<Recipe> findByRecipeDate(Date recipeDate);
	
	@Query("SELECT r FROM Recipe r WHERE r.presenter.id = :cheifId")
	List<Recipe> findByCheifId(@Param("cheifId") int cheifId);
}
