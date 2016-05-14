/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.CbcNew;
import com.cbc.model.ProgramNew;

/**
 * @author Mina Saleeb
 *
 */
public interface ProgramNewsRepository extends CrudRepository<ProgramNew, Long> 
{
	@Query("SELECT prgmNws.cbcNew FROM ProgramNew prgmNws WHERE prgmNws.programBean.id = :programId")
	List<CbcNew> findByProgramId(@Param("programId") int programId);
}
