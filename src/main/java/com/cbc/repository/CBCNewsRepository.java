/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.CbcNew;
import com.cbc.model.NewsCategory;

import java.util.List;

/**
 * @author Mina Saleeb
 *
 */
public interface CBCNewsRepository extends CrudRepository<CbcNew, Long> 
{
	List<CbcNew> findByNewsCategory(NewsCategory newsCategory);
}
