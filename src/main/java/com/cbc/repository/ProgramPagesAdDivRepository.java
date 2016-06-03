/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cbc.model.ProgramPagesAdDiv;

/**
 * @author Mina Saleeb
 *
 */
public interface ProgramPagesAdDivRepository extends CrudRepository<ProgramPagesAdDiv, Long> 
{
	@Query("select ppads from ProgramPagesAdDiv ppads Where ppads.programBean.id= :programId AND ppads.programPage.id= :pageCode")
	List<ProgramPagesAdDiv> findByPrmIdAndPageCode(@Param("programId") int programId, @Param("pageCode") String pageCode);
}
