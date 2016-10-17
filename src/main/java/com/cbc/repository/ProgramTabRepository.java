/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.ProgramTab;

/**
 * @author Mina Saleeb
 *
 */
public interface ProgramTabRepository extends CrudRepository<ProgramTab, Integer>
{
	@Query("select pt from ProgramTab pt Where pt.programBean.id= :programId")
	List<ProgramTab> findByProgramId(@Param("programId") int programId);
}
