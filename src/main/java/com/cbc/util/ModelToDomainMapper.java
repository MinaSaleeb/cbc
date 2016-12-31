/**
 * 
 */
package com.cbc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cbc.domain.recipe.Ingredient;
import com.cbc.domain.recipe.RecipeType;
import com.cbc.domain.recipe.Step;

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
		domProgram.setSchedule(modProgram.getSchedule());
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
		domCbcNew.setId(modCbcNew.getSlug() != null && !"".equals(modCbcNew.getSlug()) ? modCbcNew.getSlug() : String.valueOf(modCbcNew.getId()));
		domCbcNew.setTitle(modCbcNew.getTitle());
		domCbcNew.setDescription(modCbcNew.getDescription());
		domCbcNew.setPostingDate(modCbcNew.getPostingDate());
		domCbcNew.setPhotoPath(modCbcNew.getPhotoPath());
		/*
		if(modCbcNew.getNewsContent() != null)
		{
			domCbcNew.setContent(modCbcNew.getNewsContent().getContent());
		}
		*/
		domCbcNew.setVideoUrl(modCbcNew.getVideoUrl());
		domCbcNew.setType(modCbcNew.getType());
		domCbcNew.setThumbnail(modCbcNew.getThumbnailImage());
		List<String> tagsList = new ArrayList<String>();
		String tags = modCbcNew.getTags();
		if(tags != null && !tags.isEmpty())
		{
			tagsList.addAll(Arrays.asList(tags.split("\\^")));
		}
		domCbcNew.setTags(tagsList);
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
		domNewsCategory.setBgImage(modNewsCategory.getBgImage());
		List<com.cbc.model.NewsCategory> subCategories = modNewsCategory.getSubCategories();
		if(subCategories != null && !subCategories.isEmpty())
		{
			List<com.cbc.domain.NewsCategory> domSubCats = new ArrayList<com.cbc.domain.NewsCategory>();
			for(com.cbc.model.NewsCategory cat : subCategories)
			{
				domSubCats.add(new com.cbc.domain.NewsCategory(cat));
			}
			domNewsCategory.setSubCategories(domSubCats);
		}
	}
	
	public static List<com.cbc.domain.NewsCategory> mapNewsCategoryList(List<com.cbc.model.NewsCategory> modNewsCategoryList)
	{
		List<com.cbc.domain.NewsCategory> domList = new ArrayList<com.cbc.domain.NewsCategory>();
		if(modNewsCategoryList != null && !modNewsCategoryList.isEmpty())
		{
			for(com.cbc.model.NewsCategory n : modNewsCategoryList)
			{
				//filter child categories from first level
				if(n.getParentCategory() == null)
				{
					domList.add(new com.cbc.domain.NewsCategory(n));
				}
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
		if(modTimeLine.getProgramBean() != null)
		{
			domTimeLine.setProgram(new com.cbc.domain.Program(modTimeLine.getProgramBean()));
		}
		else
		{
			domTimeLine.setProgram(new com.cbc.domain.Program(modTimeLine.getStaticProgramImage(), modTimeLine.getStaticProgramImage(), modTimeLine.getStaticProgramImage(), modTimeLine.getStaticProgramTitle()));
		}
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
	
	public static void mapProgramTab(com.cbc.model.ProgramTab modProgramTab , com.cbc.domain.ProgramTab domProgramTab)
	{
		domProgramTab.setId(modProgramTab.getId());
		domProgramTab.setName(modProgramTab.getName());
		domProgramTab.setContentType(modProgramTab.getContentType());
		domProgramTab.setContents(mapProgramTabContentsList(modProgramTab.getProgramTabContents()));
		List<com.cbc.model.ProgramTab> subTabs = modProgramTab.getChildTabs();
		if(subTabs != null && !subTabs.isEmpty())
		{
			List<com.cbc.domain.ProgramTab> domSubChilds = new ArrayList<com.cbc.domain.ProgramTab>();
			for(com.cbc.model.ProgramTab tab : subTabs)
			{
				domSubChilds.add(new com.cbc.domain.ProgramTab(tab));
			}
			domProgramTab.setChildTabs(domSubChilds);
		}
	}
	
	public static void mapProgramTabContent(com.cbc.model.ProgramTabContent modProgramTabc , com.cbc.domain.ProgramTabContent domProgramTabc)
	{
		domProgramTabc.setId(modProgramTabc.getId());
		domProgramTabc.setTitle(modProgramTabc.getTitle());
		domProgramTabc.setDescription(modProgramTabc.getDescription());
		domProgramTabc.setContentUrl(modProgramTabc.getContentUrl());
		domProgramTabc.setThumbnail(modProgramTabc.getThumbnailImage());
		domProgramTabc.setContentType(modProgramTabc.getContentType());
		domProgramTabc.setHtmlContent(modProgramTabc.getHtmlContent());
		
	}
	
	public static List<com.cbc.domain.ProgramTab> mapProgramTabsList(List<com.cbc.model.ProgramTab> modProgramTabList)
	{
		List<com.cbc.domain.ProgramTab> domList = new ArrayList<com.cbc.domain.ProgramTab>();
		if(modProgramTabList != null && !modProgramTabList.isEmpty())
		{
			for(com.cbc.model.ProgramTab pt : modProgramTabList)
			{
				//filter child tabs from first level
				if(pt.getParentTab() == null)
				{
					domList.add(new com.cbc.domain.ProgramTab(pt));
				}
			}
		}
		
		return domList;
	}
	
	public static List<com.cbc.domain.ProgramTabContent> mapProgramTabContentsList(List<com.cbc.model.ProgramTabContent> modProgramTabCntsList)
	{
		List<com.cbc.domain.ProgramTabContent> domList = new ArrayList<com.cbc.domain.ProgramTabContent>();
		if(modProgramTabCntsList != null && !modProgramTabCntsList.isEmpty())
		{
			for(com.cbc.model.ProgramTabContent ptc : modProgramTabCntsList)
			{
				domList.add(new com.cbc.domain.ProgramTabContent(ptc));
			}
		}
		
		return domList;
	}
	
	public static void mapWidget(com.cbc.model.Widget modWidget , com.cbc.domain.Widget domWidget)
	{
		domWidget.setId(modWidget.getId());
		domWidget.setName(modWidget.getName());
		domWidget.setWidgetContents(mapWidgetContentsList(modWidget.getWidgetContents()));
	}
	
	public static List<com.cbc.domain.WidgetContent> mapWidgetContentsList(List<com.cbc.model.WidgetContent> modWidgetCntsList)
	{
		List<com.cbc.domain.WidgetContent> domList = new ArrayList<com.cbc.domain.WidgetContent>();
		if(modWidgetCntsList != null && !modWidgetCntsList.isEmpty())
		{
			for(com.cbc.model.WidgetContent wc : modWidgetCntsList)
			{
				domList.add(new com.cbc.domain.WidgetContent(wc));
			}
		}
		
		return domList;
	}
	
	public static void mapWidgetContent(com.cbc.model.WidgetContent modWidgetContent , com.cbc.domain.WidgetContent domWidgetContent)
	{
		domWidgetContent.setId(modWidgetContent.getId());
		domWidgetContent.setContentUrl(modWidgetContent.getContentUrl());;
		domWidgetContent.setContentUrlType(modWidgetContent.getContentUrlType());
		domWidgetContent.setHtmlContent(modWidgetContent.getHtmlContent());	
	}
	
	public static List<com.cbc.domain.Widget> mapWidgetsList(List<com.cbc.model.Widget> modWidgetList)
	{
		List<com.cbc.domain.Widget> domList = new ArrayList<com.cbc.domain.Widget>();
		if(modWidgetList != null && !modWidgetList.isEmpty())
		{
			for(com.cbc.model.Widget w : modWidgetList)
			{
				domList.add(new com.cbc.domain.Widget(w));
			}
		}
		
		return domList;
	}
	
	public static void mapRecipesCategory(com.cbc.model.RecipeCategory modRecipesCategory , com.cbc.domain.recipe.RecipeCategory domRecipesCategory)
	{
		domRecipesCategory.setId(modRecipesCategory.getSlug());
		domRecipesCategory.setName(modRecipesCategory.getName());
		domRecipesCategory.setImage(modRecipesCategory.getImage());
		List<com.cbc.model.RecipeCategory> subCategories = modRecipesCategory.getSubCategories();
		if(subCategories != null && !subCategories.isEmpty())
		{
			List<com.cbc.domain.recipe.RecipeCategory> domSubCats = new ArrayList<com.cbc.domain.recipe.RecipeCategory>();
			for(com.cbc.model.RecipeCategory cat : subCategories)
			{
				domSubCats.add(new com.cbc.domain.recipe.RecipeCategory(cat));
			}
			domRecipesCategory.setSubCategories(domSubCats);
		}
	}
	
	public static List<com.cbc.domain.recipe.RecipeCategory> mapRecipesCategoryList(List<com.cbc.model.RecipeCategory> modRecipesCategoryList)
	{
		List<com.cbc.domain.recipe.RecipeCategory> domList = new ArrayList<com.cbc.domain.recipe.RecipeCategory>();
		if(modRecipesCategoryList != null && !modRecipesCategoryList.isEmpty())
		{
			for(com.cbc.model.RecipeCategory n : modRecipesCategoryList)
			{
				//filter child categories from first level
				if(n.getParentCategory() == null)
				{
					domList.add(new com.cbc.domain.recipe.RecipeCategory(n));
				}
			}
		}
		
		
		
		
		return domList;
	}
	
	public static void mapRecipe(com.cbc.model.Recipe modRecipe , com.cbc.domain.recipe.Recipe domRecipe)
	{
		domRecipe.setId(modRecipe.getId());
		domRecipe.setSlug(modRecipe.getSlug());
		domRecipe.setTitle(modRecipe.getTitle());
		domRecipe.setRating(modRecipe.getDisplayedRating());
		//Images
		List<String> images = new ArrayList<String>();
		images.add(modRecipe.getPhotoPath());
		domRecipe.setImages(images);
		//Tags
		List<String> tagsList = new ArrayList<String>();
		String tags = modRecipe.getTags();
		if(tags != null && !tags.isEmpty())
		{
			tagsList.addAll(Arrays.asList(tags.split("\\^")));
		}
		domRecipe.setTags(tagsList);
		//Program
		if(modRecipe.getProgramBean() != null)
		{
			domRecipe.setProgramName(modRecipe.getProgramBean().getTitle());
		}
		//Chief
		if(modRecipe.getPresenter() != null)
		{
			domRecipe.setChiefName(modRecipe.getPresenter().getName());
		}
		//category
		if(modRecipe.getRecipeCategory() != null)
		{
			domRecipe.setCategory(modRecipe.getRecipeCategory().getName());
		}
		//Cuisine
		if(modRecipe.getCuisine() != null)
		{
			domRecipe.setCuisine(modRecipe.getCuisine().getName());
		}
		//User
		if(modRecipe.getUserBean() != null)
		{
			domRecipe.setUserName(modRecipe.getUserBean().getFirstName()+" "+modRecipe.getUserBean().getLastName());
		}
		//Type
		if(modRecipe.getRecipeType() != null)
		{
			domRecipe.setType(new RecipeType(modRecipe.getRecipeType().getTypeName(), modRecipe.getRecipeType().getImagePath()));
		}
		//Steps
		List<Step> steps = new ArrayList<Step>();
		List<com.cbc.model.RecipeStep> modSteps = modRecipe.getRecipeSteps();
		if(modSteps != null  && !modSteps.isEmpty())
		{
			for(com.cbc.model.RecipeStep modStep : modSteps)
			{
				steps.add(new Step(modStep.getStepContent(), modStep.getStartTime(), modStep.getEndTime()));
			}
		}
		domRecipe.setSteps(steps);
		//Ingredients
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		List<com.cbc.model.RecipeIngredient> modIngredients = modRecipe.getRecipeIngredients();
		if(modIngredients != null  && !modIngredients.isEmpty())
		{
			for(com.cbc.model.RecipeIngredient modIngredient : modIngredients)
			{
				ingredients.add(new Ingredient(modIngredient.getIngredientContent()));
			}
		}
		domRecipe.setIngredients(ingredients);
	}
	
	public static List<com.cbc.domain.recipe.Recipe> mapRecipesList(List<com.cbc.model.Recipe> modRecipesList)
	{
		List<com.cbc.domain.recipe.Recipe> domList = new ArrayList<com.cbc.domain.recipe.Recipe>();
		if(modRecipesList != null && !modRecipesList.isEmpty())
		{
			for(com.cbc.model.Recipe r : modRecipesList)
			{
				domList.add(new com.cbc.domain.recipe.Recipe(r));
			}
		}
		return domList;
	}
}
