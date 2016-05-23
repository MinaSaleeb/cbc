/**
 * 
 */
package com.cbc.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mina Saleeb
 *
 */
public class ModelToDomainMapper 
{
	public static void mapChannel(com.cbc.model.Channel modChnl , com.cbc.domain.Channel domChnl)
	{
		domChnl.setId(modChnl.getId());
		domChnl.setChannelName(modChnl.getChannelName());
		domChnl.setChannelImage(modChnl.getChannelImage());
		domChnl.setChannelBgImage(modChnl.getChannelBgImage());
		domChnl.setLiveStreamingUrl(modChnl.getLiveStreamingUrl());
		domChnl.setHubCarouelImage(modChnl.getHubCarouelImage());
	}
	
	
	public static void mapPresenter(com.cbc.model.Presenter modPresenter , com.cbc.domain.Presenter domPresenter)
	{
		domPresenter.setId(modPresenter.getId());
		domPresenter.setName(modPresenter.getName());
		domPresenter.setDescription(modPresenter.getDescription());
		domPresenter.setPhotoPath(modPresenter.getPhotoPath());
	}
	
	public static void mapProgram(com.cbc.model.Program modProgram , com.cbc.domain.Program domProgram)
	{
		domProgram.setId(modProgram.getId());
		domProgram.setTitle(modProgram.getTitle());
		domProgram.setDescription(modProgram.getDescription());
		domProgram.setImageXPath(modProgram.getImageXPath());
		domProgram.setImage1xPath(modProgram.getImage1xPath());
		domProgram.setImage2xPath(modProgram.getImage2xPath());
		domProgram.setImageBgPath(modProgram.getImageBgPath());
		domProgram.setRecipeRatingImagePath(modProgram.getRecipeRatingImagePath());
	}
	
	public static List<com.cbc.domain.Program> mapProgramsList(List<com.cbc.model.Program> modProgramList)
	{
		List<com.cbc.domain.Program> domList = new ArrayList<com.cbc.domain.Program>();
		if(modProgramList != null && !modProgramList.isEmpty())
		{
			for(com.cbc.model.Program p : modProgramList)
			{
				domList.add(new com.cbc.domain.Program(p));
			}
		}
		
		return domList;
	}
	
	
	public static void mapCBCNew(com.cbc.model.CbcNew modCbcNew , com.cbc.domain.CbcNew domCbcNew)
	{
		domCbcNew.setId(modCbcNew.getId());
		domCbcNew.setTitle(modCbcNew.getTitle());
		domCbcNew.setDescription(modCbcNew.getDescription());
		domCbcNew.setPostingDate(modCbcNew.getPostingDate());
		domCbcNew.setPhotoPath(modCbcNew.getPhotoPath());
		domCbcNew.setContent(modCbcNew.getNewsContent().getContent());
	}
	
	public static List<com.cbc.domain.CbcNew> mapCbcNewsList(List<com.cbc.model.CbcNew> modCbcNewList)
	{
		List<com.cbc.domain.CbcNew> domList = new ArrayList<com.cbc.domain.CbcNew>();
		if(modCbcNewList != null && !modCbcNewList.isEmpty())
		{
			for(com.cbc.model.CbcNew n : modCbcNewList)
			{
				domList.add(new com.cbc.domain.CbcNew(n));
			}
		}
		
		return domList;
	}
	
	
	public static void mapNewsCategory(com.cbc.model.NewsCategory modNewsCategory , com.cbc.domain.NewsCategory domNewsCategory)
	{
		domNewsCategory.setId(modNewsCategory.getId());
		domNewsCategory.setCategoryName(modNewsCategory.getCategoryName());
		
	}
	
	public static List<com.cbc.domain.NewsCategory> mapNewsCategoryList(List<com.cbc.model.NewsCategory> modNewsCategoryList)
	{
		List<com.cbc.domain.NewsCategory> domList = new ArrayList<com.cbc.domain.NewsCategory>();
		if(modNewsCategoryList != null && !modNewsCategoryList.isEmpty())
		{
			for(com.cbc.model.NewsCategory n : modNewsCategoryList)
			{
				domList.add(new com.cbc.domain.NewsCategory(n));
			}
		}
		
		return domList;
	}
	
}
