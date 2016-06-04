/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbc.model.CbcNew;
import com.cbc.model.Channel;
import com.cbc.model.ChannelsAdDiv;
import com.cbc.model.NewsAdDiv;
import com.cbc.model.NewsCategoriesAdDiv;
import com.cbc.model.NewsCategory;
import com.cbc.repository.CBCNewsRepository;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.NewsCategoryRepository;

/**
 * @author Mina Saleeb
 *
 */
@Service
@Transactional
public class CBCNewsService 
{
	private static final Logger LOGGER = Logger.getLogger(CBCNewsService.class);
	
	@Autowired
	private CBCNewsRepository cBCNewsRepo;
	
	@Autowired
	private NewsCategoryRepository newsCategoryRepo;
	
	@Autowired
	private ChannelRepository channelRepo;
	
	@Autowired
	private AdDivsPropagationService adDivsPropagationService;
	
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
			newsList = cBCNewsRepo.findByNewsCategoryOrderByPostingDateDesc(category);
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
	
	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<CbcNew> findNewsWzVideosByCategoryId(int categoryId)
	{
		return cBCNewsRepo.findNewsWzVideosByCategoryId(categoryId);
	}
	
	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	public CbcNew getFeaturedNewsByCategoryId(int categoryId)
	{
		NewsCategory category = newsCategoryRepo.findOne(categoryId);
		
		CbcNew n = null;
		
		if(category != null)
		{
			n = category.getFeaturedNews();
		}
		else
		{
			LOGGER.error("newsCategoryId {"+categoryId+"} is not found in DB");
		}
		
		return n;
	}
	
	/**
	 * 
	 * @param categoryId
	 * @param size
	 * @return
	 */
	public List<CbcNew> findNMostLatestNewsBycategoryId(int categoryId, int size)
	{
		Pageable pageSize = new PageRequest(0, size > 1 ?size:1);
		return cBCNewsRepo.findNMostLatestNewsBycategoryId(categoryId, pageSize);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<CbcNew> findVarietyNews()
	{
		List<NewsCategory> cats = (List<NewsCategory>) newsCategoryRepo.findAll();
		List<CbcNew> ns = new ArrayList<CbcNew>();
		Pageable pageSize = new PageRequest(1, 10);
		if(cats != null && !cats.isEmpty())
		{
			for(NewsCategory cat : cats)
			{
				ns.addAll(cBCNewsRepo.findNMostLatestNewsBycategoryId(cat.getId(), pageSize));
			}
		}
		return ns;
	}
	
	/**
	 * 
	 * @param newId
	 * @return
	 */
	public Map<String , String> getNewAds(long newId)
	{
		Map<String , String> newAdsmap = new HashMap<String , String>();
		
		CbcNew n = cBCNewsRepo.findOne(newId);
		
		if(n == null)
		 {
			 LOGGER.error("newId {"+newId+"} is not found in DB");
		 }
		 else
		 {
			 List<NewsAdDiv> nAds = n.getNewsAdDivs();
			 NewsCategory nCategory = n.getNewsCategory();
			 List<NewsCategoriesAdDiv> categoryAds = nCategory != null?nCategory.getNewsCategoryAdDivs():null;
			 Channel categoryChannel = nCategory != null? nCategory.getChannelBean():null;
			 List<ChannelsAdDiv> chnlAds = categoryChannel != null?categoryChannel.getChannelsAdDivs():null;
			 Set<String> checkedDivCodes = adDivsPropagationService.getAdDivsCodes();
			 if(nAds != null && !nAds.isEmpty())
			 {
				 for(NewsAdDiv ad :nAds)
				 {
					 newAdsmap.put(ad.getAdDiv().getDivCode(), ad.getAdScript());
				 }
			 }
			 
			 if(categoryAds != null && !categoryAds.isEmpty())
			 {
				 adDivsPropagationService.checkMissingNewsCategoryAdDivsFromTree(categoryAds,newAdsmap,checkedDivCodes);
			 }
			 
			 if(chnlAds != null && !chnlAds.isEmpty())
			 {
				 	adDivsPropagationService.checkMissingChnlAdDivsFromTree(chnlAds,newAdsmap,checkedDivCodes);
			 }
		 }
		return newAdsmap;
	}
	
	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	public Map<String , String> getNewCategoryAds(int categoryId)
	{
		Map<String , String> newsCategoryAdsmap = new HashMap<String , String>();
		
		NewsCategory nc = newsCategoryRepo.findOne(categoryId);
		
		if(nc == null)
		 {
			 LOGGER.error("categoryId {"+categoryId+"} is not found in DB");
		 }
		 else
		 {
			 List<NewsCategoriesAdDiv> categoryAds = nc.getNewsCategoryAdDivs();
			 Channel categoryChannel = nc.getChannelBean();
			 List<ChannelsAdDiv> chnlAds = categoryChannel != null?categoryChannel.getChannelsAdDivs():null;
			 Set<String> checkedDivCodes = adDivsPropagationService.getAdDivsCodes();
			 
			 if(categoryAds != null && !categoryAds.isEmpty())
			 {
					for(NewsCategoriesAdDiv ad : categoryAds) // category ads
					{
						newsCategoryAdsmap.put(ad.getAdDiv().getDivCode(), ad.getAdScript());
					}
			 }
			 
			 if(chnlAds != null && !chnlAds.isEmpty())
			 {
				 adDivsPropagationService.checkMissingChnlAdDivsFromTree(chnlAds,newsCategoryAdsmap,checkedDivCodes);
			 }
		 }
		return newsCategoryAdsmap;
	}
	
	
	
}
