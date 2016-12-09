/**
 * 
 */
package com.cbc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.User;
import com.cbc.services.UserService;

/**
 * @author Mina Saleeb
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@Transactional
public class UsersRestController 
{
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> signUp(@RequestParam(required = true , value = "email") String email,
									@RequestParam(required = true , value = "mobile") String mobile,
									@RequestParam(required = true , value = "firstName") String firstName,
									@RequestParam(required = true , value = "lastName") String lastName,
									@RequestParam(required = false , value = "gender") String gender,
									@RequestParam(required = true , value = "password") String password)
	{
		if(!userService.validateUserData(email))
		{
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setMobileNumber(mobile);
		newUser.setPassword(password);
		newUser.setGender(gender);
		
		userService.createNewUser(newUser);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestParam(required = true , value = "userName") String userName,
			@RequestParam(required = true , value = "password") String password)
	{
		User user = userService.login(userName, password);
		if(user != null)
		{
			return new ResponseEntity<>(user.getId(),HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
