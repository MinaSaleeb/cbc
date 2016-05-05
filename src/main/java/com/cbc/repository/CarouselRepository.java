/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Carousel;
import com.cbc.model.Channel;

/**
 * @author Mina Saleeb
 *
 */
public interface CarouselRepository extends CrudRepository<Carousel, Integer> 
{
	Carousel findByChannelBean(Channel channel);
}
