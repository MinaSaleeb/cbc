/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Program;

/**
 * @author Mina Saleeb
 *
 */
public interface ProgramRepository extends CrudRepository<Program, Integer> 
{
	
}
