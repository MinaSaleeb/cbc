/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Episode;

/**
 * @author Mina Saleeb
 *
 */
public interface EpisodeRepository extends CrudRepository<Episode, Long> 
{
	@Query("select e from Episode e order by RAND()")
	List<Episode> findRandomEpisodes(Pageable pageable);
}