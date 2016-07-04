/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.NewsCategory;

/**
 * @author Mina Saleeb
 *
 */
public interface NewsCategoryRepository extends CrudRepository<NewsCategory, Integer> 
{
	@Query(value="SELECT * FROM news_categories nc WHERE nc.channel = :channelId", nativeQuery=true)
	List<NewsCategory> findByChannelId(@Param("channelId") int channelId);
}
