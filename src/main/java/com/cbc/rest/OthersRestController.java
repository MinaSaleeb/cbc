/**
 * 
 */
package com.cbc.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.CitizenService;
import com.cbc.repository.CitizenServiceRepository;

/**
 * @author Mina Saleeb
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/others")
public class OthersRestController 
{
	private static final Logger LOGGER = Logger.getLogger(OthersRestController.class);
	
	@Autowired
	private CitizenServiceRepository citizenServiceRepo;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/citizen_services", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<CitizenService>> listCitizenServices()
	 {
		List<CitizenService> citizenServices = (List<CitizenService>) citizenServiceRepo.findAll();
		
		if(citizenServices == null || citizenServices.isEmpty())
		 {
			 LOGGER.error("No Citizen Services in DB");
			 return new ResponseEntity<List<CitizenService>>(HttpStatus.NO_CONTENT);
		 }
		 
		 return new ResponseEntity<List<CitizenService>>(citizenServices , HttpStatus.OK);
	 }
}
