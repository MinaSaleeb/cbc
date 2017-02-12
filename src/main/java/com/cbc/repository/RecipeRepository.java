/**
 * 
 */
package com.cbc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
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
	
	@Query("SELECT r FROM Recipe r WHERE r.presenter.id = :cheifId ORDER BY r.recipeDate DESC")
	List<Recipe> findByCheifId(@Param("cheifId") int cheifId, Pageable pageable);
	
	@Query(value = "SELECT * FROM recipes r WHERE r.cuisine = :cuisineId", nativeQuery = true)
	List<Recipe> findByCuisineId(@Param("cuisineId") int cuisineId);
	
	//List<Recipe> findByRecipeCategory(RecipeCategory recipeCategory);
	
	@Query(value = "SELECT r FROM Recipe r ORDER BY r.numberOfViews DESC")
	List<Recipe> getMostViewed(Pageable pageable);
	
	Recipe findBySlug(String slug);
	
	List<Recipe> findByStatus(short status);
	
	List<Recipe> findBySelectedForUOrderByRecipeDateDesc(boolean selectedForU, Pageable pageable);
	
	@Query(value = "SELECT r FROM Recipe r WHERE r.userBean IS NOT NULL AND r.status = 1 ORDER BY r.recipeDate DESC")
	List<Recipe> getMembersRecipes(Pageable pageable);
}
