/**
 * 
 */
package com.cbc.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.CitizenService;
import com.cbc.model.Currency;
import com.cbc.model.ExternalPage;
import com.cbc.model.PrayerTime;
import com.cbc.model.UserAnswer;
import com.cbc.model.Widget;
import com.cbc.repository.CitizenServiceRepository;
import com.cbc.repository.CurrencyRepository;
import com.cbc.repository.ExternalPageRepository;
import com.cbc.repository.PrayerTimeRepository;
import com.cbc.repository.UserAnswerRepository;
import com.cbc.repository.WidgetRepository;

/**
 * @author Mina Saleeb
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/others")
@Transactional
public class OthersRestController 
{
	private static final Logger LOGGER = Logger.getLogger(OthersRestController.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private CitizenServiceRepository citizenServiceRepo;
	
	@Autowired
	private PrayerTimeRepository prayerTimeRepository;
	
	@Autowired
	private CurrencyRepository currencyRepository; 
	
	@Autowired
	private ExternalPageRepository externalPageRepository;
	
	@Autowired
	private UserAnswerRepository userAnswerRepository;
	
	@Autowired
	private WidgetRepository widgetRepo;
	
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
	
	@RequestMapping(value = "/external_page/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<ExternalPage> getExternalPageDate(@PathVariable("id") int companyId)
	 {
		ExternalPage externalPage = externalPageRepository.findOne(companyId);
		
		if(externalPage == null)
		 {
			 LOGGER.error("No externalPage in DB");
			 return new ResponseEntity<ExternalPage>(HttpStatus.NO_CONTENT);
		 }
		 
		 return new ResponseEntity<ExternalPage>(externalPage , HttpStatus.OK);
	 }
	
	
	@RequestMapping(value = "/question_answer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> postUserAnswer(@RequestParam(required = true , value = "userId") long userId,
			@RequestParam(required = true , value = "questionId") long questionId,
			@RequestParam(required = true , value = "answer") String answer)
	 {
		
		 UserAnswer userAnswer = new UserAnswer();
		 userAnswer.setUserId(userId);
		 userAnswer.setQuestionId(questionId);
		 userAnswer.setAnswer(answer);
		 
		 userAnswerRepository.save(userAnswer);
		 
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }
	
	@RequestMapping(value = "/prayerTimes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<PrayerTime>> getPrayerTimes(@RequestParam(required = true , value = "fromDate") String fromDate , @RequestParam(required = true , value = "toDate") String toDate) throws ParseException
	 {
		List<PrayerTime> prayingTimes = prayerTimeRepository.findByPrayingDateBetweenOrderByPrayingDateAsc(sdf.parse(fromDate), sdf.parse(toDate));
		
		if(prayingTimes == null || prayingTimes.isEmpty())
		 {
			 LOGGER.error("No Prayer Times in DB");
			 return new ResponseEntity<List<PrayerTime>>(HttpStatus.NO_CONTENT);
		 }
		 
		 return new ResponseEntity<List<PrayerTime>>(prayingTimes , HttpStatus.OK);
	 }
	
	 @RequestMapping(value = "/currencies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Currency>> listCurrencies()
	 {
		List<Currency> currencies = (List<Currency>)currencyRepository.findAll();
		
		if(currencies == null || currencies.isEmpty())
		 {
			 LOGGER.error("No Currencies in DB");
			 return new ResponseEntity<List<Currency>>(HttpStatus.NO_CONTENT);
		 }
		
		return new ResponseEntity<List<Currency>>(currencies , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/widget/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<com.cbc.domain.Widget> getWidgetByName(@PathVariable("name") String name)
	 {
		 Widget w = widgetRepo.findByName(name);
		 if(w != null)
		 {
			 return new ResponseEntity<com.cbc.domain.Widget>(new com.cbc.domain.Widget(w) , HttpStatus.OK); 
		 }
		 
		 return new ResponseEntity<com.cbc.domain.Widget>(HttpStatus.NOT_FOUND);
		 
	 }
}
