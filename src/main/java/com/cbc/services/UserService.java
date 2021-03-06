/**
 * 
 */
package com.cbc.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.model.User;
import com.cbc.repository.UserRepository;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class UserService 
{
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean signUp()
	{
		boolean success = true;
		
		return success;
	}
	
	public User login(String userEmail, String password)
	{
		return userRepository.findByEmailAndPassword(userEmail, password);
	}
	
	public boolean validateUserData(String userEmail)
	{
		boolean valid = true; 
		
		if(userRepository.findByEmail(userEmail) != null)
		{
			valid = false;
		}
		
		return valid;
	}
	
	public void createNewUser(User newUser)
	{
		userRepository.save(newUser);
	}
}
