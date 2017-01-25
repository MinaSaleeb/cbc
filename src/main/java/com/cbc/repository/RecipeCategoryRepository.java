/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cbc.model.RecipeCategory;

/**
 * @author Mina
 *
 */
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> 
{
	RecipeCategory findBySlug(String slug);
	
	@Query("SELECT c From RecipeCategory c")
	List<RecipeCategory> findAllWithSize(Pageable pageable);
}
