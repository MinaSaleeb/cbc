/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Widget;

/**
 * @author Mina Saleeb
 *
 */
public interface WidgetRepository extends CrudRepository<Widget, Integer> 
{
	Widget findByName(String name);
	
	Widget findBySlug(String slug);
}
