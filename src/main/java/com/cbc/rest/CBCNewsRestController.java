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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.CbcNew;
import com.cbc.model.NewsCategory;
import com.cbc.model.Presenter;
import com.cbc.services.CBCNewsService;

/**
 * @author Mina Saleeb
 *
 */
@RestController
@RequestMapping("/news")
public class CBCNewsRestController 
{
	private static final Logger LOGGER = Logger.getLogger(CBCNewsRestController.class);
	
	@Autowired
	private CBCNewsService cBCNewsService;
	
	/*
	@RequestMapping(value = "/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Carousel> getByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		
	 }
	 */
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NewsCategory>> getCbcNewsCategories()
	{
		List<NewsCategory> categoriesList = cBCNewsService.getCbcNewsCategories();
		if(categoriesList != null && !categoriesList.isEmpty())
		{
			return new ResponseEntity<List<NewsCategory>>(categoriesList , HttpStatus.OK);
		}
		
		return  new ResponseEntity<List<NewsCategory>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	@RequestMapping(value = "/categories/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<NewsCategory>> getCbcNewsCategoriesByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		List<NewsCategory> categoriesList = cBCNewsService.getCbcNewsCategoriesByChannelId(channelId);
		
		if(categoriesList != null && !categoriesList.isEmpty())
		{
			return new ResponseEntity<List<NewsCategory>>(categoriesList , HttpStatus.OK);
		}
		
		return  new ResponseEntity<List<NewsCategory>>(HttpStatus.NO_CONTENT);
	 }
	
	
	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/getByCategoryId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<CbcNew>> getByCategoryId(@RequestParam(required = true , value = "categoryId") int categoryId)
	 {
		List<CbcNew> newsList = cBCNewsService.getCbcNewsByCategoryId(categoryId);
		
		if(newsList != null && !newsList.isEmpty())
		{
			return new ResponseEntity<List<CbcNew>>(newsList , HttpStatus.OK);
		}
		
		return  new ResponseEntity<List<CbcNew>>(HttpStatus.NO_CONTENT);
		
	 }
	
	/**
	 * 
	 * @param newId
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<CbcNew> getNewById(@PathVariable("id") int newId)
	 {
		CbcNew cbcNew = cBCNewsService.getCbcNewsById(newId);
		
		if(cbcNew == null)
		{
			LOGGER.error("newId {"+newId+"} is not found in DB");
			return new ResponseEntity<CbcNew>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<CbcNew>(cbcNew , HttpStatus.OK);
	 }
	
	
	 @RequestMapping(value = "/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<CbcNew>> getByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		 return new ResponseEntity<List<CbcNew>>(cBCNewsService.getCbcNewsByChannelId(channelId) , HttpStatus.OK);
	 }
}
