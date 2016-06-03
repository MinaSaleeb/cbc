/**
 * 
 */
package com.cbc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		domChnl.setPromoUrl(modChnl.getPromoUrl());
	}
	
	public static List<com.cbc.domain.Channel> mapChannelsList(List<com.cbc.model.Channel> modChannelList)
	{
		List<com.cbc.domain.Channel> domList = new ArrayList<com.cbc.domain.Channel>();
		if(modChannelList != null && !modChannelList.isEmpty())
		{
			for(com.cbc.model.Channel c : modChannelList)
			{
				domList.add(new com.cbc.domain.Channel(c));
			}
		}
		
		return domList;
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
		domProgram.setHideProgram(modProgram.isHideProgram());
	}
	
	public static List<com.cbc.domain.Program> mapProgramsList(List<com.cbc.model.Program> modProgramList)
	{
		List<com.cbc.domain.Program> domList = new ArrayList<com.cbc.domain.Program>();
		if(modProgramList != null && !modProgramList.isEmpty())
		{
			for(com.cbc.model.Program p : modProgramList)
			{
				if(!p.isHideProgram())
				{
					domList.add(new com.cbc.domain.Program(p));
				}
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
		if(modCbcNew.getNewsContent() != null)
		{
			domCbcNew.setContent(modCbcNew.getNewsContent().getContent());
		}
		domCbcNew.setVideoUrl(modCbcNew.getVideoUrl());
		domCbcNew.setType(modCbcNew.getType());
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
	
	
	public static void mapEpisode(com.cbc.model.Episode modEpisode , com.cbc.domain.Episode domEpisode)
	{
		domEpisode.setId(modEpisode.getId());
		domEpisode.setTitle(modEpisode.getTitle());
		domEpisode.setHubSelected(modEpisode.isHubSelected());
		domEpisode.setNumberOfViews(modEpisode.getNumberOfViews());
		domEpisode.setDisplayingDate(modEpisode.getDisplayingDate());
		domEpisode.setUrl(modEpisode.getUrl());
		domEpisode.setPhotoPath(modEpisode.getPhotoPath());
	}
	
	public static List<com.cbc.domain.Episode> mapEpisodesList(List<com.cbc.model.Episode> modEpisodesList)
	{
		List<com.cbc.domain.Episode> domList = new ArrayList<com.cbc.domain.Episode>();
		if(modEpisodesList != null && !modEpisodesList.isEmpty())
		{
			for(com.cbc.model.Episode e : modEpisodesList)
			{
				domList.add(new com.cbc.domain.Episode(e));
			}
		}
		
		return domList;
	}
	
	
	public static void mapProgramScene(com.cbc.model.ProgramScene modProgramScene , com.cbc.domain.ProgramScene domProgramScene)
	{
		domProgramScene.setId(modProgramScene.getId());
		domProgramScene.setTitle(modProgramScene.getTitle());
		domProgramScene.setHubSelected(modProgramScene.isHubSelected());
		domProgramScene.setDescription(modProgramScene.getDescription());
		domProgramScene.setPhotoPath(modProgramScene.getPhotoPath());
		domProgramScene.setVedioUrl(modProgramScene.getVedioUrl());
	}
	
	public static List<com.cbc.domain.ProgramScene> mapProgramSceneList(List<com.cbc.model.ProgramScene> modProgramSceneList)
	{
		List<com.cbc.domain.ProgramScene> domList = new ArrayList<com.cbc.domain.ProgramScene>();
		if(modProgramSceneList != null && !modProgramSceneList.isEmpty())
		{
			for(com.cbc.model.ProgramScene ps : modProgramSceneList)
			{
				domList.add(new com.cbc.domain.ProgramScene(ps));
			}
		}
		
		return domList;
	}
	
	public static void mapScheduleDay(com.cbc.model.ScheduleDay modScheduleDay , com.cbc.domain.ScheduleDay domScheduleDay)
	{
		domScheduleDay.setId(modScheduleDay.getId());
		domScheduleDay.setActualDate(modScheduleDay.getActualDate());
		
	}
	
	public static List<com.cbc.domain.ScheduleDay> mapScheduleDayList(List<com.cbc.model.ScheduleDay> modScheduleDayList)
	{
		List<com.cbc.domain.ScheduleDay> domList = new ArrayList<com.cbc.domain.ScheduleDay>();
		if(modScheduleDayList != null && !modScheduleDayList.isEmpty())
		{
			for(com.cbc.model.ScheduleDay sd : modScheduleDayList)
			{
				domList.add(new com.cbc.domain.ScheduleDay(sd));
			}
		}
		
		return domList;
	}
	
	public static void mapTimeLine(com.cbc.model.TimeLine modTimeLine , com.cbc.domain.TimeLine domTimeLine)
	{
		domTimeLine.setId(modTimeLine.getId());
		domTimeLine.setDuration(modTimeLine.getDuration());
		domTimeLine.setRepeated(modTimeLine.getIsRepeated() == 1?true:false);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String startDate = df.format(modTimeLine.getScheduleDay().getActualDate());
		domTimeLine.setStartTime(startDate+" "+modTimeLine.getStartTime());
		domTimeLine.setPlayingNow(modTimeLine.isPlayingNow());
		domTimeLine.setProgram(new com.cbc.domain.Program(modTimeLine.getProgramBean()));
	}
	
	public static List<com.cbc.domain.TimeLine> mapTimeLineList(List<com.cbc.model.TimeLine> modTimeLineList)
	{
		List<com.cbc.domain.TimeLine> domList = new ArrayList<com.cbc.domain.TimeLine>();
		if(modTimeLineList != null && !modTimeLineList.isEmpty())
		{
			for(com.cbc.model.TimeLine tl : modTimeLineList)
			{
				domList.add(new com.cbc.domain.TimeLine(tl));
			}
		}
		
		return domList;
	}
	
	public static void mapProgramPromo(com.cbc.model.ProgramPromo modProgramPromo , com.cbc.domain.ProgramPromo domProgramPromo)
	{
		domProgramPromo.setId(modProgramPromo.getId());
		domProgramPromo.setDescription(modProgramPromo.getDescription());
		domProgramPromo.setPromoUrl(modProgramPromo.getPromoUrl());
		domProgramPromo.setTitle(modProgramPromo.getTitle());
		domProgramPromo.setThumbnailPath(modProgramPromo.getThumbnailPath());
	}
	
	public static List<com.cbc.domain.ProgramPromo> mapProgramPromoList(List<com.cbc.model.ProgramPromo> modProgramPromoList)
	{
		List<com.cbc.domain.ProgramPromo> domList = new ArrayList<com.cbc.domain.ProgramPromo>();
		if(modProgramPromoList != null && !modProgramPromoList.isEmpty())
		{
			for(com.cbc.model.ProgramPromo pp : modProgramPromoList)
			{
				domList.add(new com.cbc.domain.ProgramPromo(pp));
			}
		}
		
		return domList;
	}
}
