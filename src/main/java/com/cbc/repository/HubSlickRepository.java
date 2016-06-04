/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.cbc.model.HubSlick;

/**
 * @author Mina Saleeb
 *
 */
public interface HubSlickRepository extends CrudRepository<HubSlick, Integer> 
{

	List<HubSlick> findAll(Sort sort);
	
}
