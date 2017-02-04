/**
 * 
 */
package com.cbc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.SelectedItemForYou;

/**
 * @author Mina
 *
 */
public interface SelectedItemForYouRepository extends CrudRepository<SelectedItemForYou, Long> 
{
	List<SelectedItemForYou> findByStatusOrderByOrderAsc(short status);
}
