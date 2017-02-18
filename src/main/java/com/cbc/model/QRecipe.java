package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRecipe is a Querydsl query type for Recipe
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecipe extends EntityPathBase<Recipe> {

    private static final long serialVersionUID = 1851182762L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecipe recipe = new QRecipe("recipe");

    public final NumberPath<Float> avgRating = createNumber("avgRating", Float.class);

    public final ListPath<RecipeCategory, QRecipeCategory> categories = this.<RecipeCategory, QRecipeCategory>createList("categories", RecipeCategory.class, QRecipeCategory.class, PathInits.DIRECT2);

    public final ListPath<RecipeCuisine, QRecipeCuisine> cuisines = this.<RecipeCuisine, QRecipeCuisine>createList("cuisines", RecipeCuisine.class, QRecipeCuisine.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final QEpisode episodeBean;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> numberOfRates = createNumber("numberOfRates", Integer.class);

    public final NumberPath<Long> numberOfViews = createNumber("numberOfViews", Long.class);

    public final QRecipe parentRecipe;

    public final StringPath photoPath = createString("photoPath");

    public final QPresenter presenter;

    public final QProgram programBean;

    public final DateTimePath<java.util.Date> recipeDate = createDateTime("recipeDate", java.util.Date.class);

    public final ListPath<RecipeIngredient, QRecipeIngredient> recipeIngredients = this.<RecipeIngredient, QRecipeIngredient>createList("recipeIngredients", RecipeIngredient.class, QRecipeIngredient.class, PathInits.DIRECT2);

    public final ListPath<RecipeStep, QRecipeStep> recipeSteps = this.<RecipeStep, QRecipeStep>createList("recipeSteps", RecipeStep.class, QRecipeStep.class, PathInits.DIRECT2);

    public final QRecipeType recipeType;

    public final BooleanPath selectedForU = createBoolean("selectedForU");

    public final StringPath slug = createString("slug");

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final ListPath<Recipe, QRecipe> subRecipes = this.<Recipe, QRecipe>createList("subRecipes", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public final StringPath tags = createString("tags");

    public final StringPath thumbnailImage = createString("thumbnailImage");

    public final StringPath title = createString("title");

    public final StringPath url = createString("url");

    public final StringPath urlType = createString("urlType");

    public final QUser userBean;

    public final ListPath<User, QUser> users = this.<User, QUser>createList("users", User.class, QUser.class, PathInits.DIRECT2);

    public QRecipe(String variable) {
        this(Recipe.class, forVariable(variable), INITS);
    }

    public QRecipe(Path<? extends Recipe> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRecipe(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRecipe(PathMetadata<?> metadata, PathInits inits) {
        this(Recipe.class, metadata, inits);
    }

    public QRecipe(Class<? extends Recipe> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.episodeBean = inits.isInitialized("episodeBean") ? new QEpisode(forProperty("episodeBean"), inits.get("episodeBean")) : null;
        this.parentRecipe = inits.isInitialized("parentRecipe") ? new QRecipe(forProperty("parentRecipe"), inits.get("parentRecipe")) : null;
        this.presenter = inits.isInitialized("presenter") ? new QPresenter(forProperty("presenter")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
        this.recipeType = inits.isInitialized("recipeType") ? new QRecipeType(forProperty("recipeType")) : null;
        this.userBean = inits.isInitialized("userBean") ? new QUser(forProperty("userBean")) : null;
    }

}

