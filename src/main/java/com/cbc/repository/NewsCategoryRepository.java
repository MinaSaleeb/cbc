/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Channel;
import com.cbc.model.NewsCategory;
import java.util.List;

/**
 * @author Mina Saleeb
 *
 */
public interface NewsCategoryRepository extends CrudRepository<NewsCategory, Integer> 
{
	List<NewsCategory> findByChannelBean(Channel chnl);
}
