/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.ProgramScene;

/**
 * @author Mina Saleeb
 *
 */
public interface ProgramSceneRepository extends CrudRepository<ProgramScene, Integer> 
{
	@Query("select ps from ProgramScene ps order by RAND()")
	List<ProgramScene> findRandomProgramScene(Pageable pageable);
	
	List<ProgramScene> findByHubSelected(boolean hubSelected);
	
	@Query("select ps from ProgramScene ps Where ps.programBean.id= :programId")
	List<ProgramScene> findByProgramId(@Param("programId") int programId);
}
