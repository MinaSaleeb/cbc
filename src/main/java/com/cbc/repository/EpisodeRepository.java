/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Episode;

/**
 * @author Mina Saleeb
 *
 */
public interface EpisodeRepository extends CrudRepository<Episode, Long> 
{
	
}
