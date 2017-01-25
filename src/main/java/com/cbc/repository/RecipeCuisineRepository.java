/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cbc.model.RecipeCuisine;

/**
 * @author Mina Saleeb
 *
 */
public interface RecipeCuisineRepository extends CrudRepository<RecipeCuisine, Integer> 
{
	@Query("SELECT c From RecipeCuisine c")
	List<RecipeCuisine> findAllWithSize(Pageable pageable);
}
