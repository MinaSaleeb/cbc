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
		domPresenter.setIcon(modPresenter.getPhotoPath1());
		domPresenter.setThumbnailImage(modPresenter.getPhotoPath2());
		domPresenter.setImage(modPresenter.getPhotoPath3());
		domPresenter.setSlug(modPresenter.getSlug());
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
		domProgram.setIcon(modProgram.getCircleImagePath());
		domProgram.setThumbnailImage(modProgram.getHalfCircleImagePath());
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
		if(modCbcNew.getNewsCategory() != null)
		{
			domCbcNew.setCategoryId(String.valueOf(modCbcNew.getNewsCategory().getId()));
			domCbcNew.setCategoryName(modCbcNew.getNewsCategory().getCategoryName());
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
	
	public static void mapWidget(com.cbc.model.Widget modWidget , com.cbc.domain.Widget domWidget, boolean withContents)
	{
		domWidget.setId(modWidget.getId());
		domWidget.setName(modWidget.getName());
		domWidget.setType(modWidget.getType());
		domWidget.setImage(modWidget.getImage());
		domWidget.setSlug(modWidget.getSlug());
		domWidget.setUrl(modWidget.getUrl());
		if(withContents)
		{
			domWidget.setWidgetContents(mapWidgetContentsList(modWidget.getWidgetContents()));
		}
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
		domWidgetContent.setTitle(modWidgetContent.getTitle());
		domWidgetContent.setSlug(modWidgetContent.getSlug());
		domWidgetContent.setDescription(modWidgetContent.getDescription());
		domWidgetContent.setThumbnailImage(modWidgetContent.getThumbnailImage());
	}
	
	public static List<com.cbc.domain.Widget> mapWidgetsList(List<com.cbc.model.Widget> modWidgetList, boolean withContents)
	{
		List<com.cbc.domain.Widget> domList = new ArrayList<com.cbc.domain.Widget>();
		if(modWidgetList != null && !modWidgetList.isEmpty())
		{
			for(com.cbc.model.Widget w : modWidgetList)
			{
				domList.add(new com.cbc.domain.Widget(w, withContents));
			}
		}
		
		return domList;
	}
	
	public static void mapRecipesCategory(com.cbc.model.RecipeCategory modRecipesCategory , com.cbc.domain.recipe.RecipeCategory domRecipesCategory,boolean includeRecipes,Integer numOfIncludedRecipes)
	{
		domRecipesCategory.setId(modRecipesCategory.getSlug());
		domRecipesCategory.setName(modRecipesCategory.getName());
		domRecipesCategory.setImage(modRecipesCategory.getImage());
		domRecipesCategory.setThumbnailImage(modRecipesCategory.getThumbnailImage());
		domRecipesCategory.setIcon(modRecipesCategory.getIcon());
		List<com.cbc.model.RecipeCategory> subCategories = modRecipesCategory.getSubCategories();
		if(subCategories != null && !subCategories.isEmpty())
		{
			List<com.cbc.domain.recipe.RecipeCategory> domSubCats = new ArrayList<com.cbc.domain.recipe.RecipeCategory>();
			for(com.cbc.model.RecipeCategory cat : subCategories)
			{
				domSubCats.add(new com.cbc.domain.recipe.RecipeCategory(cat, includeRecipes, numOfIncludedRecipes));
			}
			domRecipesCategory.setSubCategories(domSubCats);
		}
		if(includeRecipes)
		{
			if(modRecipesCategory.getRecipes() != null && !modRecipesCategory.getRecipes().isEmpty())
			{
				List<com.cbc.domain.recipe.Recipe> recipes = new ArrayList<com.cbc.domain.recipe.Recipe>();
				for(com.cbc.model.Recipe r : numOfIncludedRecipes != null?modRecipesCategory.getRecipes().subList(0,modRecipesCategory.getRecipes().size() <= numOfIncludedRecipes ? modRecipesCategory.getRecipes().size() : numOfIncludedRecipes) : modRecipesCategory.getRecipes())
				{
					recipes.add(new com.cbc.domain.recipe.Recipe(r));
				}
				domRecipesCategory.setRecipes(recipes);
			}
		}
	}
	
	public static List<com.cbc.domain.recipe.RecipeCategory> mapRecipesCategoryList(List<com.cbc.model.RecipeCategory> modRecipesCategoryList,boolean includeRecipes,Integer numOfIncludedRecipes)
	{
		List<com.cbc.domain.recipe.RecipeCategory> domList = new ArrayList<com.cbc.domain.recipe.RecipeCategory>();
		if(modRecipesCategoryList != null && !modRecipesCategoryList.isEmpty())
		{
			for(com.cbc.model.RecipeCategory n : modRecipesCategoryList)
			{
				//filter child categories from first level
				if(n.getParentCategory() == null)
				{
					domList.add(new com.cbc.domain.recipe.RecipeCategory(n, includeRecipes, numOfIncludedRecipes));
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
		domRecipe.setDescription(modRecipe.getDescription());
		domRecipe.setUrl(modRecipe.getUrl());
		domRecipe.setUrlType(modRecipe.getUrlType());
		domRecipe.setRating(modRecipe.getDisplayedRating());
		//Images
		List<String> images = new ArrayList<String>();
		images.add(modRecipe.getPhotoPath());
		domRecipe.setImages(images);
		domRecipe.setThumbnailImage(modRecipe.getThumbnailImage());
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
		if(modRecipe.getCategories() != null && !modRecipe.getCategories().isEmpty())
		{
			domRecipe.setCategory(modRecipe.getCategories().get(0).getName());
		}
		//Cuisine
		if(modRecipe.getCuisines() != null && !modRecipe.getCuisines().isEmpty())
		{
			domRecipe.setCuisine(modRecipe.getCuisines().get(0).getName());
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
				Ingredient ingr = new Ingredient(modIngredient);
				//if(modIngredient.getFoodItem() != null) ingr.setContent(ingr.getContent()+" "+modIngredient.getFoodItem().getItemName());
				ingredients.add(ingr);
			}
		}
		domRecipe.setIngredients(ingredients);
		//Sub Recipes
		List<com.cbc.model.Recipe> subRecipes = modRecipe.getSubRecipes();
		if(subRecipes != null && !subRecipes.isEmpty())
		{
			List<com.cbc.domain.recipe.Recipe> domSubRecipes = new ArrayList<com.cbc.domain.recipe.Recipe>();
			for(com.cbc.model.Recipe r : subRecipes)
			{
				domSubRecipes.add(new com.cbc.domain.recipe.Recipe(r));
			}
			domRecipe.setSubRecipes(domSubRecipes);
		}
	}
	
	public static List<com.cbc.domain.recipe.Recipe> mapRecipesList(List<com.cbc.model.Recipe> modRecipesList)
	{
		List<com.cbc.domain.recipe.Recipe> domList = new ArrayList<com.cbc.domain.recipe.Recipe>();
		if(modRecipesList != null && !modRecipesList.isEmpty())
		{
			for(com.cbc.model.Recipe r : modRecipesList)
			{
				//filter child Recipes from first level
				if(r.getParentRecipe() == null)
				{
					domList.add(new com.cbc.domain.recipe.Recipe(r));
				}
			}
		}
		return domList;
	}
	
	public static void  mapFoodItem(com.cbc.model.FoodItem modFoodItem, com.cbc.domain.recipe.FoodItem domFoodItem)
	{
		domFoodItem.setId(modFoodItem.getId());
		domFoodItem.setItemName(modFoodItem.getItemName());
		domFoodItem.setFromPrice(modFoodItem.getFromPrice());
		domFoodItem.setToPrice(modFoodItem.getFromPrice());
		domFoodItem.setNumberOfCalories(modFoodItem.getNumberOfCalories());
		domFoodItem.setDescription(modFoodItem.getDescription());
		domFoodItem.setAdImage(modFoodItem.getAdImage());
		domFoodItem.setUrl(modFoodItem.getUrl());
		domFoodItem.setAmount(modFoodItem.getAmount());
		if(modFoodItem.getMeasureUnit() != null)
		{
			domFoodItem.setMeasureUnit(modFoodItem.getMeasureUnit().getName());
		}
	}
	
	public static void  mapFoodType(com.cbc.model.FoodType modFoodType, com.cbc.domain.recipe.FoodType domFoodType)
	{
		domFoodType.setId(modFoodType.getId());
		domFoodType.setName(modFoodType.getTypeName());
		List<com.cbc.domain.recipe.FoodItem> items = new ArrayList<com.cbc.domain.recipe.FoodItem>();
		if(modFoodType.getFoodItems() != null && !modFoodType.getFoodItems().isEmpty())
		{
			for(com.cbc.model.FoodItem fi : modFoodType.getFoodItems())
			{
				items.add(new com.cbc.domain.recipe.FoodItem(fi));
			}
		}
		domFoodType.setItems(items);
	}
	
	public static List<com.cbc.domain.recipe.FoodType> mapFoodTypesList(List<com.cbc.model.FoodType> modFoodTypesList)
	{
		List<com.cbc.domain.recipe.FoodType> domList = new ArrayList<com.cbc.domain.recipe.FoodType>();
		if(modFoodTypesList != null && !modFoodTypesList.isEmpty())
		{
			for(com.cbc.model.FoodType ft : modFoodTypesList)
			{
				domList.add(new com.cbc.domain.recipe.FoodType(ft));
			}
		}
		return domList;
	}
	
	public static List<com.cbc.domain.recipe.FoodItem> mapFoodItemsList(List<com.cbc.model.FoodItem> modFoodItemsList)
	{
		List<com.cbc.domain.recipe.FoodItem> domList = new ArrayList<com.cbc.domain.recipe.FoodItem>();
		if(modFoodItemsList != null && !modFoodItemsList.isEmpty())
		{
			for(com.cbc.model.FoodItem fi : modFoodItemsList)
			{
				domList.add(new com.cbc.domain.recipe.FoodItem(fi));
			}
		}
		return domList;
	}
	
	public static void  mapRecipeCuisine(com.cbc.model.RecipeCuisine modRecipeCuisine, com.cbc.domain.recipe.RecipeCuisine domRecipeCuisine,boolean includeRecipes,Integer numOfIncludedRecipes)
	{
		domRecipeCuisine.setId(modRecipeCuisine.getId());
		domRecipeCuisine.setName(modRecipeCuisine.getName());
		domRecipeCuisine.setThumbnailImage(modRecipeCuisine.getThumbnailImage());
		domRecipeCuisine.setImage(modRecipeCuisine.getImage());
		domRecipeCuisine.setIcon(modRecipeCuisine.getIcon());
		if(includeRecipes)
		{
			if(modRecipeCuisine.getRecipes() != null && !modRecipeCuisine.getRecipes().isEmpty())
			{
				List<com.cbc.domain.recipe.Recipe> recipes = new ArrayList<com.cbc.domain.recipe.Recipe>();
				for(com.cbc.model.Recipe r : numOfIncludedRecipes != null?modRecipeCuisine.getRecipes().subList(0,modRecipeCuisine.getRecipes().size() <= numOfIncludedRecipes ? modRecipeCuisine.getRecipes().size() : numOfIncludedRecipes) : modRecipeCuisine.getRecipes())
				{
					recipes.add(new com.cbc.domain.recipe.Recipe(r));
				}
				domRecipeCuisine.setRecipes(recipes);
			}
		}
	}
	
	public static List<com.cbc.domain.recipe.RecipeCuisine> mapRecipeCuisinesList(List<com.cbc.model.RecipeCuisine> modRecipeCuisinesList,boolean includeRecipes,Integer numOfIncludedRecipes)
	{
		List<com.cbc.domain.recipe.RecipeCuisine> domList = new ArrayList<com.cbc.domain.recipe.RecipeCuisine>();
		if(modRecipeCuisinesList != null && !modRecipeCuisinesList.isEmpty())
		{
			for(com.cbc.model.RecipeCuisine c : modRecipeCuisinesList)
			{
				domList.add(new com.cbc.domain.recipe.RecipeCuisine(c,includeRecipes,numOfIncludedRecipes));
			}
		}
		return domList;
	}
	
	public static void  mapSelectedItem(com.cbc.model.SelectedItemForYou modSltdItm, com.cbc.domain.SelectedItem domSltdItm)
	{
		domSltdItm.setItemId(modSltdItm.getItemId());
		domSltdItm.setItemType(modSltdItm.getItemType());
		domSltdItm.setOrder(modSltdItm.getOrder());
		domSltdItm.setStatus(modSltdItm.getStatus());
	}
	
	public static List<com.cbc.domain.recipe.Chief> mapChiefsList(List<com.cbc.model.Presenter> modChiefsList,boolean includeRecipes,Integer numOfIncludedRecipes)
	{
		List<com.cbc.domain.recipe.Chief> domList = new ArrayList<com.cbc.domain.recipe.Chief>();
		if(modChiefsList != null && !modChiefsList.isEmpty())
		{
			for(com.cbc.model.Presenter p : modChiefsList)
			{
				domList.add(new com.cbc.domain.recipe.Chief(p, includeRecipes, numOfIncludedRecipes));
			}
		}
		
		return domList;
	}
	
	public static void  mapRecipeIngredient(com.cbc.model.RecipeIngredient modRecipeIngredient, com.cbc.domain.recipe.Ingredient domRecipeIngredient)
	{
		domRecipeIngredient.setContent(modRecipeIngredient.getIngredientContent());
		domRecipeIngredient.setQuantity(String.valueOf(modRecipeIngredient.getQuantity()));
		if(modRecipeIngredient.getMeasureUnit() != null)
		{
			domRecipeIngredient.setMeasureUnit(modRecipeIngredient.getMeasureUnit().getName());
		}
		
		if(modRecipeIngredient.getFoodItem() != null)
		{
			domRecipeIngredient.setFoodItem(new com.cbc.domain.recipe.FoodItem(modRecipeIngredient.getFoodItem()));
		}
	}
}
