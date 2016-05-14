/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbc.model.CbcNew;
import com.cbc.model.Channel;
import com.cbc.model.NewsCategory;
import com.cbc.repository.CBCNewsRepository;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.NewsCategoryRepository;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class CBCNewsService 
{
	private static final Logger LOGGER = Logger.getLogger(CBCNewsService.class);
	
	@Autowired
	private CBCNewsRepository cBCNewsRepo;
	
	@Autowired
	private NewsCategoryRepository newsCategoryRepo;
	
	@Autowired
	private ChannelRepository channelRepo;
	
	/**
	 * 
	 * @return
	 */
	public List<NewsCategory> getCbcNewsCategories()
	{
		return (List<NewsCategory>) newsCategoryRepo.findAll();
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	public List<NewsCategory> getCbcNewsCategoriesByChannelId(int channelId)
	{
		List<NewsCategory> categoriesList = new ArrayList<NewsCategory>();
		
		Channel chnl = channelRepo.findOne(channelId);
		
		if(chnl != null)
		{
			categoriesList = newsCategoryRepo.findByChannelBean(chnl);
		}
		else
		{
			LOGGER.error("channelId {"+channelId+"} is not found in DB");
		}
		
		return categoriesList;
	}
	
	/**
	 * 
	 * @param newsCategoryId
	 * @return
	 */
	public List<CbcNew> getCbcNewsByCategoryId(int newsCategoryId)
	{
		List<CbcNew> newsList = new ArrayList<CbcNew>();
		
		NewsCategory category = newsCategoryRepo.findOne(newsCategoryId);
		
		if(category != null)
		{
			newsList = cBCNewsRepo.findByNewsCategory(category);
		}
		else
		{
			LOGGER.error("newsCategoryId {"+newsCategoryId+"} is not found in DB");
		}
		
		return newsList;
	}
	
	
	/**
	 * 
	 * @param newId
	 * @return
	 */
	public CbcNew getCbcNewsById(long newId)
	{
		return cBCNewsRepo.findOne(newId);
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	public List<CbcNew> getCbcNewsByChannelId(int channelId)
	{
		return cBCNewsRepo.findByChannelId(channelId);
	}
	
}
