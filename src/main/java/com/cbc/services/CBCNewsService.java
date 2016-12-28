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

import com.cbc.domain.NewsImage;
import com.cbc.model.CbcNew;
import com.cbc.model.Channel;
import com.cbc.model.ChannelsAdDiv;
import com.cbc.model.NewsAdDiv;
import com.cbc.model.NewsCategoriesAdDiv;
import com.cbc.model.NewsCategory;
import com.cbc.model.NewsContent;
import com.cbc.repository.CBCNewsRepository;
import com.cbc.repository.ChannelRepository;
import com.cbc.repository.NewsCategoryRepository;
import com.cbc.repository.NewsMediaRepository;
import com.cbc.repository.ProgramNewsRepository;
import com.cbc.util.Constants.NewsType;

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
	
	@Autowired
	private ProgramNewsRepository programNewsRepo;
	
	@Autowired
	private NewsMediaRepository newsMediaRepo;
	
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
		return newsCategoryRepo.findByChannelId(channelId);
	}
		
	/**
	 * 
	 * @param newsCategoryId
	 * @param page TODO
	 * @return
	 */
	public List<CbcNew> getCbcNewsByCategoryId(int newsCategoryId, Pageable page)
	{
		List<CbcNew> newsList = new ArrayList<CbcNew>();
		
		NewsCategory category = newsCategoryRepo.findOne(newsCategoryId);
		
		if(category != null)
		{
			newsList = cBCNewsRepo.findByNewsCategoryOrderByPostingDateDesc(category,page);
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
	 * @param slug
	 * @return
	 */
	public CbcNew getCbcNewsBySlug(String slug)
	{
		return cBCNewsRepo.findBySlug(slug);
	}
	
	/**
	 * 
	 * @param newId
	 * @return
	 */
	public NewsContent getNewsContentById(long newId)
	{
		return cBCNewsRepo.getNewsContentById(newId);
	}
	
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	public List<CbcNew> getCbcNewsByChannelId(int channelId, Pageable page)
	{
		return cBCNewsRepo.findByChannelId(channelId,page);
	}
	
	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<CbcNew> findNewsWzVideosByCategoryId(int categoryId, Pageable page)
	{
		return cBCNewsRepo.findNewsWzVideosByCategoryId(categoryId, page);
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
	public List<CbcNew> findNMostLatestNewsBycategoryId(int categoryId, Pageable page)
	{
		//Pageable pageSize = new PageRequest(0, size > 1 ?size:1);
		return cBCNewsRepo.findNMostLatestNewsBycategoryId(categoryId, page);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<CbcNew> findVarietyNews(Pageable page)
	{
		List<NewsCategory> cats = (List<NewsCategory>) newsCategoryRepo.findAll();
		List<CbcNew> ns = new ArrayList<CbcNew>();
		if(page.getPageSize() == 0 )
		{
			page = new PageRequest(0, 10);
		}
		
		if(cats != null && !cats.isEmpty())
		{
			for(NewsCategory cat : cats)
			{
				ns.addAll(cBCNewsRepo.findNMostLatestNewsBycategoryId(cat.getId(), page));
			}
		}
		return ns;
	}
	
	/**
	 * 
	 * @param newId
	 * @return
	 */
	public Map<String , String> getNewAds(String newId)
	{
		Map<String , String> newAdsmap = new HashMap<String , String>();
		
		CbcNew n = getCbcNewByIdentifier(newId);
		
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
	
	/**
	 * 
	 * @param channelId
	 * @param page
	 * @return
	 */
	public List<CbcNew> findRelatedToProgramsByChannelId(int channelId, Pageable page)
	{
		return programNewsRepo.findRelatedToProgramsByChannelId(channelId,page);
	}
	
	/**
	 * 
	 * @param title
	 * @param page
	 * @return
	 */
	public List<CbcNew> searchNewsByTitle(String title, Pageable page)
	{
		return cBCNewsRepo.findByTitleContainingOrTagsContainingOrderByPostingDateDesc(title,title ,page);
	}
	
	/**
	 * 
	 * @param newId
	 * @return
	 */
	public List<NewsImage> getNewImages(long newId)
	{
		List<Object[]> result = newsMediaRepo.findNewImagesById(newId);
		List<NewsImage> imagesList = new ArrayList<NewsImage>();
		if(result != null && !result.isEmpty())
		{
			for(Object[] row : result)
			{
				imagesList.add(new NewsImage((String)row[0], (String)row[1]));
			}
		}
		return imagesList;
	}
	
	/**
	 * 
	 * @param channelId
	 * @return
	 */
	public List<CbcNew> getLatestNewFromEachCatagoryByChannelId(int channelId)
	{
		return cBCNewsRepo.findLatestNewFromEachCatagoryByChannelId(channelId);
	}
	
	/**
	 * 
	 * @param categoryId
	 * @param type
	 * @param page
	 * @return
	 */
	public List<CbcNew> findNewsByCatagoryAndType(int categoryId, String type, Pageable page)
	{
		List<String> types = new ArrayList<String>();
		if(type == null || type.isEmpty())
		{
			StringBuilder sb = new StringBuilder();
			for(NewsType nt : NewsType.values())
			{
				types.add(nt.toString());
			}
		}
		else
		{
			types.add(type);
		}
		
		return cBCNewsRepo.findNewsByCatagoryAndType(categoryId, types, page);
	}
	
	public List<CbcNew> getRSSNewsList()
	{
		return cBCNewsRepo.findRSSNews(new PageRequest(0, 100));
	}
	
	public List<CbcNew> findSimilarNews(String newId)
	{
		CbcNew cbcNew = getCbcNewByIdentifier(newId);
		String tags = cbcNew.getTags();
		if(tags != null && !tags.isEmpty())
		{
			tags = tags.replace('^', '|');
		}
		return cBCNewsRepo.getSimilarNews(tags,cbcNew.getId());
	}
	
	public CbcNew findNextNew(int categoryId,long currentNewId)
	{
		return cBCNewsRepo.findNextNew(categoryId, currentNewId);
	}
	
	
	public CbcNew findPreviousNew(int categoryId,long currentNewId)
	{
		return cBCNewsRepo.findPreviousNew(categoryId, currentNewId);
	}
	
	public CbcNew getCbcNewByIdentifier(String newId)
	{
		CbcNew cbcNew = null;
		try  
		{
			long newIdLong = Long.parseLong(newId.trim());
			cbcNew = getCbcNewsById(newIdLong);
		} 
		catch (NumberFormatException nfe) 
		{
			cbcNew = getCbcNewsBySlug(newId.trim());
		}
		
		return cbcNew;
	}
	
	
}
