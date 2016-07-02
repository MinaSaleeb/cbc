/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.CbcNew;
import com.cbc.model.NewsCategory;
import com.cbc.model.NewsContent;

import java.util.List;

import javax.persistence.NamedNativeQuery;

/**
 * @author Mina Saleeb
 *
 */
public interface CBCNewsRepository extends CrudRepository<CbcNew, Long> 
{
	List<CbcNew> findByNewsCategoryOrderByPostingDateDesc(NewsCategory newsCategory, Pageable pageable);
	
	@Query("SELECT n FROM CbcNew n WHERE n.newsCategory.channelBean.id = :channelId ORDER BY n.postingDate DESC")
	List<CbcNew> findByChannelId(@Param("channelId") int channelId, Pageable pageable);
	
	@Query("SELECT n FROM CbcNew n WHERE n.newsCategory.id= :categoryId AND n.videoUrl IS NOT NULL AND LENGTH(n.videoUrl) > 0 ORDER BY n.postingDate DESC")
	List<CbcNew> findNewsWzVideosByCategoryId(@Param("categoryId") int categoryId, Pageable pageable);
	
	@Query("SELECT n FROM CbcNew n WHERE n.newsCategory.id= :categoryId ORDER BY n.postingDate DESC")
	List<CbcNew> findNMostLatestNewsBycategoryId(@Param("categoryId") int categoryId, Pageable pageable);
	
	@Query("SELECT nc FROM NewsContent nc WHERE nc.id= :newsId")
	NewsContent getNewsContentById(@Param("newsId") long newsId);
	
	List<CbcNew> findByTitleContainingOrderByPostingDateDesc(String title, Pageable pageable);
	
	@Query("SELECT n FROM CbcNew n WHERE n.title LIKE :title ORDER BY n.postingDate DESC")
	List<CbcNew> test(@Param("title") String title, Pageable pageable);
	
}
