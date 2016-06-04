/**
 * 
 */
package com.cbc.rest;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbc.model.CbcNew;
import com.cbc.model.NewsCategory;
import com.cbc.services.CBCNewsService;
import com.cbc.util.ModelToDomainMapper;

/**
 * @author Mina Saleeb
 *
 */
@CrossOrigin("*")
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
	public ResponseEntity<List<com.cbc.domain.NewsCategory>> getCbcNewsCategories()
	{
		List<NewsCategory> categoriesList = cBCNewsService.getCbcNewsCategories();
		if(categoriesList != null && !categoriesList.isEmpty())
		{
			return new ResponseEntity<List<com.cbc.domain.NewsCategory>>(ModelToDomainMapper.mapNewsCategoryList(categoriesList) , HttpStatus.OK);
		}
		
		return  new ResponseEntity<List<com.cbc.domain.NewsCategory>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	@RequestMapping(value = "/categories/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.NewsCategory>> getCbcNewsCategoriesByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		List<NewsCategory> categoriesList = cBCNewsService.getCbcNewsCategoriesByChannelId(channelId);
		
		if(categoriesList != null && !categoriesList.isEmpty())
		{
			return new ResponseEntity<List<com.cbc.domain.NewsCategory>>(ModelToDomainMapper.mapNewsCategoryList(categoriesList) , HttpStatus.OK);
		}
		
		return  new ResponseEntity<List<com.cbc.domain.NewsCategory>>(HttpStatus.NO_CONTENT);
	 }
	
	
	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/getByCategoryId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.CbcNew>> getByCategoryId(@RequestParam(required = true , value = "categoryId") int categoryId)
	 {
		List<CbcNew> newsList = cBCNewsService.getCbcNewsByCategoryId(categoryId);
		
		if(newsList != null && !newsList.isEmpty())
		{
			return new ResponseEntity<List<com.cbc.domain.CbcNew>>(ModelToDomainMapper.mapCbcNewsList(newsList) , HttpStatus.OK);
		}
		
		return  new ResponseEntity<List<com.cbc.domain.CbcNew>>(HttpStatus.NO_CONTENT);
		
	 }
	
	/**
	 * 
	 * @param newId
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<com.cbc.domain.CbcNew> getNewById(@PathVariable("id") int newId)
	 {
		CbcNew cbcNew = cBCNewsService.getCbcNewsById(newId);
		
		if(cbcNew == null)
		{
			LOGGER.error("newId {"+newId+"} is not found in DB");
			return new ResponseEntity<com.cbc.domain.CbcNew>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<com.cbc.domain.CbcNew>(new com.cbc.domain.CbcNew(cbcNew) , HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/{id}/ads", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Map<String , String>> getNewAdsById(@PathVariable("id") int newId)
	 {
		return new ResponseEntity<Map<String , String>>(cBCNewsService.getNewAds(newId) , HttpStatus.OK);
	 }
	
	 @RequestMapping(value = "/getByChannelId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.CbcNew>> getByChannelId(@RequestParam(required = true , value = "channelId") int channelId)
	 {
		 return new ResponseEntity<List<com.cbc.domain.CbcNew>>(ModelToDomainMapper.mapCbcNewsList(cBCNewsService.getCbcNewsByChannelId(channelId)) , HttpStatus.OK);
	 }
	 
	 
	 @RequestMapping(value = "/wzVideos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.CbcNew>> findNewsWzVideosByCategoryId(@RequestParam(required = true , value = "categoryId") int categoryId)
	 {
		return new ResponseEntity<List<com.cbc.domain.CbcNew>>(ModelToDomainMapper.mapCbcNewsList(cBCNewsService.findNewsWzVideosByCategoryId(categoryId)) , HttpStatus.OK);
	 }
	 
	 
	 @RequestMapping(value = "/categories/{categoryId}/featuredNews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<com.cbc.domain.CbcNew> getFeaturedNewsByCategoryId(@PathVariable("categoryId") int categoryId)
	 {
		 	CbcNew n = cBCNewsService.getFeaturedNewsByCategoryId(categoryId);
			if(n != null)
			{
				return new ResponseEntity<com.cbc.domain.CbcNew>(new com.cbc.domain.CbcNew(n) , HttpStatus.OK);
			}
			
			return  new ResponseEntity<com.cbc.domain.CbcNew>(HttpStatus.NO_CONTENT);
	 }
	 @RequestMapping(value = "/categories/{categoryId}/ads", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Map<String , String>> getCategoryAdsById(@PathVariable("categoryId") int categoryId)
	 {
		 return new ResponseEntity<Map<String , String>>(cBCNewsService.getNewCategoryAds(categoryId) , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/categories/{categoryId}/latestNews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.CbcNew>> findNMostLatestNewsBycategoryId(@PathVariable("categoryId") int categoryId, @RequestParam(required = true , value = "size") int size)
	 {
		 return new ResponseEntity<List<com.cbc.domain.CbcNew>>(ModelToDomainMapper.mapCbcNewsList(cBCNewsService.findNMostLatestNewsBycategoryId(categoryId, size)) , HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/varietyNews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<com.cbc.domain.CbcNew>> getVarietyNews()
	 {
		 return new ResponseEntity<List<com.cbc.domain.CbcNew>>(ModelToDomainMapper.mapCbcNewsList(cBCNewsService.findVarietyNews()) , HttpStatus.OK);
	 }
	 
}
