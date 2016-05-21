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
}
