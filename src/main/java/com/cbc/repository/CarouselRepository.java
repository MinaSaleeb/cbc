/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.Carousel;
import com.cbc.model.Channel;

/**
 * @author Mina Saleeb
 *
 */
public interface CarouselRepository extends CrudRepository<Carousel, Integer> 
{
	Carousel findByChannelBean(Channel channel);
	
	@Query("SELECT c FROM Carousel c WHERE c.channelBean.id = :channelId")
	Carousel findByChannelId(@Param("channelId") int channelId);
}
