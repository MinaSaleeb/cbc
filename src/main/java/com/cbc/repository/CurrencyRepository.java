/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.Currency;

/**
 * @author Mina Saleeb
 *
 */
public interface CurrencyRepository extends CrudRepository<Currency, Integer> 
{

}
