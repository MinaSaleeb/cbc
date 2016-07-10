/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.Episode;

/**
 * @author Mina Saleeb
 *
 */
public interface EpisodeRepository extends CrudRepository<Episode, Long> 
{
	@Query("select e from Episode e INNER JOIN e.programBean.channels chnl WHERE chnl.id in (5 ,7) order by RAND()")
	List<Episode> findRandomEpisodes(Pageable pageable);
	
	@Query("select DISTINCT e from Episode e INNER JOIN e.programBean.channels chnl WHERE chnl.id in (5 ,7) AND e.programBean.hideProgram = false ORDER BY e.displayingDate DESC")
	List<Episode> findLatestEpisodes(Pageable pageable);
	
	List<Episode> findByHubSelected(boolean hubSelected);
	
	@Query("select e from Episode e Where e.programBean.id= :programId ORDER BY e.id DESC")
	List<Episode> findByProgramId(@Param("programId") int programId);
}
