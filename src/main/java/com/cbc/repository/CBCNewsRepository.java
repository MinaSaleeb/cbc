/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.CbcNew;
import com.cbc.model.NewsCategory;
import com.cbc.model.NewsContent;

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
	
	List<CbcNew> findByTitleContainingOrTagsContainingOrderByPostingDateDesc(String title, String tags, Pageable pageable);
	
	CbcNew findBySlug(String slug);
	
	@Query(value = "SELECT * "+
				   "FROM cbc_news n "+
				   "INNER JOIN ("+
				   					"SELECT category, max(posting_date) AS MaxDate "+
				   					"FROM cbc_news "+
				   					"GROUP BY category "+
				   				") nij "+
				  "ON n.category IN (SELECT nc.id FROM news_categories nc WHERE nc.channel = :channelId) AND n.posting_date = nij.MaxDate", nativeQuery =true)
	List<CbcNew> findLatestNewFromEachCatagoryByChannelId(@Param("channelId") int channelId);
	
	@Query(value = "SELECT n FROM CbcNew n WHERE n.newsCategory.id= :categoryId AND n.type IN (:type) ORDER BY n.postingDate DESC")
	List<CbcNew> findNewsByCatagoryAndType(@Param("categoryId") int categoryId, @Param("type") List<String> type, Pageable pageable);
	
	@Query("SELECT n FROM CbcNew n ORDER BY n.postingDate DESC")
	List<CbcNew> findRSSNews(Pageable pageable);
	
	@Query(value = "SELECT * FROM cbc_news n  WHERE n.tags REGEXP :tags AND n.id != :newsId ORDER BY n.posting_date DESC LIMIT 20", nativeQuery = true)
	List<CbcNew> getSimilarNews(@Param("tags") String tags,@Param("newsId") long newsId);
}
