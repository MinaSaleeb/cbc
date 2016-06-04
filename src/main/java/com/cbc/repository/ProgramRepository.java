/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Program;

/**
 * @author Mina Saleeb
 *
 */
public interface ProgramRepository extends CrudRepository<Program, Integer> 
{
	List<Program> findByHubSelected(boolean hubSelected);
}
