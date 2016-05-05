/**
 * 
 */
package com.cbc.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.Program;
import com.cbc.services.ProgramsService;

/**
 * @author Mina Saleeb
 *
 */
@RestController
@RequestMapping("/program")
public class ProgramsRestController 
{
	private static final Logger LOGGER = Logger.getLogger(ProgramsRestController.class);
	
	@Autowired
	private ProgramsService programsService;
	
	
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	 @RequestMapping(value = "/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Program>> getByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		 List<Program> prgrms = new ArrayList<>();
		 try 
		 {
			
			prgrms = programsService.retrieveProgramsByChannel(channelId);
		 } 
		 catch (Exception e) 
		 {
			LOGGER.error("Error in retrieving programs list by channelId {"+channelId+"}");
			e.printStackTrace();
			return new ResponseEntity<List<Program>>(HttpStatus.NOT_FOUND);
		}
		 
		 return new ResponseEntity<List<Program>>(prgrms , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Program> getProgramById(@PathVariable("id") int programId)
	 {
		 Program prgrm = null;
		 try 
		 {
			
			 prgrm = programsService.retrieveProgramById(programId);
		 } 
		 catch (Exception e) 
		 {
			LOGGER.error("Error in retrieving program by programId {"+programId+"}");
			e.printStackTrace();
			return new ResponseEntity<Program>(HttpStatus.NOT_FOUND);
		}
		 
		 return new ResponseEntity<Program>(prgrm , HttpStatus.OK);
	 }
}
