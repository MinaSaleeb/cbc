/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Channel;

/**
 * @author Mina Saleeb
 *
 */
public interface ChannelRepository extends CrudRepository<Channel, Integer> 
{
	
}
