/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.RecipeCategory;

/**
 * @author Mina
 *
 */
public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> 
{
	RecipeCategory findBySlug(String slug);
}
