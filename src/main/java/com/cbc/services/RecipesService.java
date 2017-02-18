/**
 * 
 */
package com.cbc.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cbc.domain.SelectedItem;
import com.cbc.domain.TodayRecipeDataRow;
import com.cbc.model.FoodItem;
import com.cbc.model.FoodType;
import com.cbc.model.Presenter;
import com.cbc.model.QRecipe;
import com.cbc.model.QRecipeCategory;
import com.cbc.model.Recipe;
import com.cbc.model.RecipeCategory;
import com.cbc.model.RecipeCuisine;
import com.cbc.model.SelectedItemForYou;
import com.cbc.repository.FoodItemRepository;
import com.cbc.repository.FoodTypeRepository;
import com.cbc.repository.PresenterRepository;
import com.cbc.repository.RecipeCategoryRepository;
import com.cbc.repository.RecipeCuisineRepository;
import com.cbc.repository.RecipeRepository;
import com.cbc.repository.SelectedItemForYouRepository;
import com.cbc.util.Constants;
import com.cbc.util.Constants.ItemType;
import com.cbc.util.TimeUtils;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

/**
 * @author Mina Saleeb
 *
 */
@Service
public class RecipesService 
{
	private static final Logger LOGGER = Logger.getLogger(RecipesService.class);
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	@Autowired
	private RecipeCategoryRepository recipeCategoryRepo;
	
	@Autowired
	private RecipeCuisineRepository recipeCuisineRepo;
	
	@Autowired
	private FoodItemRepository foodItemRepository;
	
	@Autowired
	private FoodTypeRepository foodTypeRepository;
	
	@Autowired
	private PresenterRepository presenterRepository;
	
	@Autowired
	private SelectedItemForYouRepository SelectedItemForYouRepo;
	
	/**
	 * 
	 * @return
	 */
	public List<TodayRecipeDataRow> getTodayRecipes()
	{
		List<TodayRecipeDataRow> todayRecipeList = new ArrayList<TodayRecipeDataRow>();
		
		List<Recipe> todayRecipes = recipeRepo.findByRecipeDate(TimeUtils.getTodayDate());
		
		if(todayRecipes != null && !todayRecipes.isEmpty())
		{
			for(Recipe recipe : todayRecipes)
			{
				TodayRecipeDataRow recipeRow = new TodayRecipeDataRow(recipe);
				if(recipeRow.getProgramName() != null && recipeRow.getChiefName() != null)
				{
					todayRecipeList.add(recipeRow);
				}
			}
		}
		
		return todayRecipeList;
	}
	
	public List<Recipe> getTodayRecipes2()
	{
		List<SelectedItemForYou> dbSlctdItms = SelectedItemForYouRepo.findByItemTypeIgnoreCaseAndUpdateDateAndStatusOrderByOrderAsc(ItemType.RECIPE.toString(), TimeUtils.getTodayDate(), (short)1);
		 List<Recipe> resultList = new ArrayList<Recipe>();
		 if(dbSlctdItms != null && !dbSlctdItms.isEmpty())
		 {
			 for(SelectedItemForYou dbsltItm : dbSlctdItms)
			 {
				 SelectedItem domSlctItm = new SelectedItem(dbsltItm);
				 String itemType = domSlctItm.getItemType() != null ? domSlctItm.getItemType() : "";
				 if ("RECIPE".equalsIgnoreCase(itemType)) 
				 {
					Recipe item = recipeRepo.findOne(new Long(dbsltItm.getItemId()));
					if(item != null) resultList.add(item);
				 }
			 }
		 }
		
		return  resultList;
	}
	
	
	
	/**
	 * 
	 * 
	 * @param recipeId
	 * @return
	 */
	public Recipe getRecipeById(long recipeId)
	{
		return recipeRepo.findOne(recipeId);
	}
	
	/**
	 * 
	 * @param cheifId
	 * @return
	 */
	public List<Recipe> getRecipesByCheifId(int cheifId)
	{
		PageRequest page = new PageRequest(0, 20);
		return recipeRepo.findByCheifId(cheifId, page);
	}
	
	public void rateRecipe(long recipeId , float ratingVal) throws Exception
	{
		Recipe recipe = recipeRepo.findOne(recipeId);
		
		if(recipe != null)
		{
			recipe.setNumberOfRates(recipe.getNumberOfRates()+1);
			recipe.setAvgRating(recipe.getAvgRating()+ratingVal);
			recipeRepo.save(recipe);
		}
		else
		{
			LOGGER.error("recipeId {"+recipeId+"} is not found in DB");
			throw new Exception();
		}
	}
	
	public void incrementNumberOfViews(long recipeId) throws Exception
	{
		Recipe recipe = recipeRepo.findOne(recipeId);
		
		if(recipe != null)
		{
			recipe.setNumberOfViews(recipe.getNumberOfViews()+1);
			recipeRepo.save(recipe);
		}
		else
		{
			LOGGER.error("recipeId {"+recipeId+"} is not found in DB");
			throw new Exception();
		}
	}
	
	public List<RecipeCategory> getAllRecipesCategories(Integer size)
	{
		List<RecipeCategory> cats = new ArrayList<RecipeCategory>();
		if(size == null)
		{
			cats =  (List<RecipeCategory>) recipeCategoryRepo.findAll();
		}
		else if(size != null)
		{
			cats = recipeCategoryRepo.findAllWithSize(new PageRequest(0, size));
		}
		return cats;
	}
	
	public RecipeCategory getRecipeCategoryBySlug(String slug)
	{
		return recipeCategoryRepo.findBySlug(slug.trim());
	}
	
	public List<RecipeCuisine> getAllRecipesCuisines(Integer size)
	{
		List<RecipeCuisine> cuisines = new ArrayList<RecipeCuisine>();
		if(size == null)
		{
			cuisines =  (List<RecipeCuisine>) recipeCuisineRepo.findAll();
		}
		else if(size != null)
		{
			cuisines = recipeCuisineRepo.findAllWithSize(new PageRequest(0, size));
		}
		return cuisines;
	}
	
	public Recipe getRecipeBySlug(String slug)
	{
		return recipeRepo.findBySlug(slug.trim());
	}
	
	public List<Recipe> getRecipesByCategorySlug(String slug)
	{
		RecipeCategory cat = getRecipeCategoryBySlug(slug);
		
		return cat.getRecipes();
	}
	
	public List<Recipe> getMostViewedRecipes(int size)
	{
		PageRequest page = new PageRequest(0, size);
		return recipeRepo.getMostViewed(page);
	}
	
	public List<Recipe> getSelectedForYouRecipes(int size)
	{
		PageRequest page = new PageRequest(0, size);
		return recipeRepo.findBySelectedForUOrderByRecipeDateDesc(true, page);
	}
	
	public List<Recipe> getMembersRecipes(int size)
	{
		PageRequest page = new PageRequest(0, size);
		return recipeRepo.getMembersRecipes(page);
	}
	
	public List<FoodType> getAllFoodTypes()
	{
		return (List<FoodType>) foodTypeRepository.findAll();
	}
	
	public List<FoodItem> getAllFoodItems()
	{
		return (List<FoodItem>) foodItemRepository.findAll();
	}
	
	public FoodType getFoodTypeById(int id)
	{
		return foodTypeRepository.findOne(id);
	}
	
	public FoodItem getFoodItemById(long id)
	{
		return foodItemRepository.findOne(id);
	}
	
	public List<Presenter> getAllRecipesChiefs(Integer size)
	{
		List<Presenter> chiefs = new ArrayList<Presenter>();
		if(size == null)
		{
			chiefs =  presenterRepository.findByChannelId(Constants.SOFRA_CHANNEL_ID);
		}
		else if(size != null)
		{
			chiefs = presenterRepository.findByChannelIdWithSize(Constants.SOFRA_CHANNEL_ID, new PageRequest(0, size));
		}
		return chiefs;
	}
	
	public List<Recipe> searchRecipes(Integer categoryId, Integer chiefId, Integer cuisineId, Integer programId, String title)
	{
		QRecipe recipe = QRecipe.recipe;
		
		Predicate query = recipe.isNotNull();
		BooleanBuilder where = new BooleanBuilder();
		if(categoryId != null)
		{
			RecipeCategory category = recipeCategoryRepo.findOne(categoryId);
			if(category != null)
			{
				where.and(recipe.categories.contains(category));
			}
		}
		
		if(chiefId != null)
		{
			where.and(recipe.presenter.id.eq(chiefId));
		}
		
		if(cuisineId != null)
		{
			RecipeCuisine cuisine = recipeCuisineRepo.findOne(cuisineId);
			if(cuisine != null)
			{
				where.and(recipe.cuisines.contains(cuisine));
			}
		}
		
		if(programId != null)
		{
			where.and(recipe.programBean.id.eq(programId));
		}
		
		if(title != null && !title.isEmpty())
		{
			where.and(recipe.title.containsIgnoreCase(title).or(recipe.description.containsIgnoreCase(title)));
		}
		
		return (List<Recipe>) recipeRepo.findAll(where);
	}
}
