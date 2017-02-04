/**
 * 
 */
package com.cbc.rest;

import java.awt.ItemSelectable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.cbc.domain.SelectedItem;
import com.cbc.model.CbcNew;
import com.cbc.model.CitizenService;
import com.cbc.model.Currency;
import com.cbc.model.ExternalPage;
import com.cbc.model.PrayerTime;
import com.cbc.model.Program;
import com.cbc.model.Recipe;
import com.cbc.model.SelectedItemForYou;
import com.cbc.model.UserAnswer;
import com.cbc.model.Widget;
import com.cbc.repository.CBCNewsRepository;
import com.cbc.repository.CitizenServiceRepository;
import com.cbc.repository.CurrencyRepository;
import com.cbc.repository.ExternalPageRepository;
import com.cbc.repository.PrayerTimeRepository;
import com.cbc.repository.ProgramRepository;
import com.cbc.repository.RecipeRepository;
import com.cbc.repository.SelectedItemForYouRepository;
import com.cbc.repository.UserAnswerRepository;
import com.cbc.repository.WidgetRepository;
import com.cbc.util.ModelToDomainMapper;

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
	
	@Autowired
	private SelectedItemForYouRepository SelectedItemForYouRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	@Autowired
	private CBCNewsRepository cBCNewsRepo;
	
	@Autowired
	private ProgramRepository programRepo;
	
	
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
	 
//	 @RequestMapping(value = "/widget/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	 public ResponseEntity<com.cbc.domain.Widget> getWidgetByName(@PathVariable("name") String name)
//	 {
//		 Widget w = widgetRepo.findByName(name);
//		 if(w != null)
//		 {
//			 return new ResponseEntity<com.cbc.domain.Widget>(new com.cbc.domain.Widget(w, true) , HttpStatus.OK); 
//		 }
//		 
//		 return new ResponseEntity<com.cbc.domain.Widget>(HttpStatus.NOT_FOUND);
//		 
//	 }
//	 
	 @RequestMapping(value = "/widget/{slug}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<com.cbc.domain.Widget> getWidgetBySlug(@PathVariable("slug") String slug)
	 {
		 Widget w = widgetRepo.findBySlug(slug);
		 if(w != null)
		 {
			 return new ResponseEntity<com.cbc.domain.Widget>(new com.cbc.domain.Widget(w, true) , HttpStatus.OK); 
		 }
		 
		 return new ResponseEntity<com.cbc.domain.Widget>(HttpStatus.NOT_FOUND);
		 
	 }
	 
	 @RequestMapping(value = "/widgets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.Widget>> getWidgets()
	 {
		 List<Widget> wl = (List<Widget>) widgetRepo.findAll();
		 if(wl != null && !wl.isEmpty())
		 {
			 return new ResponseEntity<List<com.cbc.domain.Widget>>(ModelToDomainMapper.mapWidgetsList(wl, false), HttpStatus.OK); 
		 }
		 
		 return new ResponseEntity<List<com.cbc.domain.Widget>>(HttpStatus.NO_CONTENT);
		 
	 }
	 
	 @RequestMapping(value = "/selectedItemsForU", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.SelectedItem>> getSelectedItemsForU()
	 {
		 List<SelectedItemForYou> dbSlctdItms = SelectedItemForYouRepo.findByStatusOrderByOrderAsc((short)1);
		 
		 if(dbSlctdItms != null && !dbSlctdItms.isEmpty())
		 {
			 List<SelectedItem> resultList = new ArrayList<>();
			 
			 for(SelectedItemForYou dbsltItm : dbSlctdItms)
			 {
				 SelectedItem domSlctItm = new SelectedItem(dbsltItm);
				 String itemType = domSlctItm.getItemType() != null ? domSlctItm.getItemType() : "";
				 if("PROGRAM".equalsIgnoreCase(itemType))
				 {
					 Program item = programRepo.findOne(new Integer(dbsltItm.getItemId()));
					if(item != null)
					{
						domSlctItm.setImage(item.getImage2xPath());
						domSlctItm.setTitle(item.getTitle());
					}
				 }
				 else if ("WIDGET".equalsIgnoreCase(itemType)) 
				 {
					Widget item = widgetRepo.findOne(new Integer(dbsltItm.getItemId()));
					if(item != null)
					{
						domSlctItm.setImage(item.getImage());
						domSlctItm.setTitle(item.getName());
					}
				 }
				 else if ("RECIPE".equalsIgnoreCase(itemType)) 
				 {
					Recipe item = recipeRepo.findOne(new Long(dbsltItm.getItemId()));
					if(item != null)
					{
						domSlctItm.setImage(item.getThumbnailImage());
						domSlctItm.setTitle(item.getTitle());
					}
				 }
				 else if ("NEWS".equalsIgnoreCase(itemType)) 
				 {
					CbcNew item = cBCNewsRepo.findOne(new Long(dbsltItm.getItemId()));
					if(item != null)
					{
						domSlctItm.setImage(item.getThumbnailImage());
						domSlctItm.setTitle(item.getTitle());
					}
				 }
				 resultList.add(domSlctItm);
			 }
			 return new ResponseEntity<List<com.cbc.domain.SelectedItem>>(resultList,HttpStatus.OK);
		 }
		
		 return new ResponseEntity<List<com.cbc.domain.SelectedItem>>(HttpStatus.NO_CONTENT);
		 
	 }
}
