/**
 * 
 */
package com.cbc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cbc.model.User;

/**
 * @author Mina Saleeb
 *
 */
public interface UserRepository extends CrudRepository<User, Long> 
{
	User findByEmailAndPassword(String email ,String password);
	
	User findByEmail(String email);
}
