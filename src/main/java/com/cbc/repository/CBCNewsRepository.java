/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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
	
	@Query("SELECT n FROM CbcNew n WHERE n.newsCategory.channelBean.id = :channelId")
	List<CbcNew> findByChannelId(@Param("channelId") int channelId);
	
	@Query("SELECT n FROM CbcNew n WHERE n.newsCategory.id= :categoryId AND n.videoUrl IS NOT NULL")
	List<CbcNew> findNewsWzVideosByCategoryId(@Param("categoryId") int categoryId);
}
