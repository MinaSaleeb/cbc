/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.NewsCategory;

/**
 * @author Mina Saleeb
 *
 */
public interface NewsCategoryRepository extends CrudRepository<NewsCategory, Long> 
{

}
