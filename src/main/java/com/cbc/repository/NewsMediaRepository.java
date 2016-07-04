/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.NewsMedia;

/**
 * @author MondiaMedia
 *
 */
public interface NewsMediaRepository extends CrudRepository<NewsMedia, Long> 
{
	@Query(value = "SELECT nmi.image_path FROM news_media_items nmi WHERE nmi.new_id = :newsId" , nativeQuery = true)
	List<String> findNewImagesById(@Param("newsId") long newsId);
}
