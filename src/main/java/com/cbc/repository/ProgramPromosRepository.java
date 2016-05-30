/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.ProgramPromo;

/**
 * @author Mina Saleeb
 *
 */
public interface ProgramPromosRepository extends CrudRepository<ProgramPromo, Long> 
{
	@Query("select pp from ProgramPromo pp Where pp.programBean.id= :programId")
	List<ProgramPromo> findByProgramId(@Param("programId") int programId);
}
