package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRecipeCategory is a Querydsl query type for RecipeCategory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecipeCategory extends EntityPathBase<RecipeCategory> {

    private static final long serialVersionUID = 1173857736L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecipeCategory recipeCategory = new QRecipeCategory("recipeCategory");

    public final StringPath icon = createString("icon");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath image = createString("image");

    public final StringPath name = createString("name");

    public final QRecipeCategory parentCategory;

    public final ListPath<Recipe, QRecipe> recipes = this.<Recipe, QRecipe>createList("recipes", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public final StringPath slug = createString("slug");

    public final ListPath<RecipeCategory, QRecipeCategory> subCategories = this.<RecipeCategory, QRecipeCategory>createList("subCategories", RecipeCategory.class, QRecipeCategory.class, PathInits.DIRECT2);

    public final StringPath thumbnailImage = createString("thumbnailImage");

    public QRecipeCategory(String variable) {
        this(RecipeCategory.class, forVariable(variable), INITS);
    }

    public QRecipeCategory(Path<? extends RecipeCategory> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRecipeCategory(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRecipeCategory(PathMetadata<?> metadata, PathInits inits) {
        this(RecipeCategory.class, metadata, inits);
    }

    public QRecipeCategory(Class<? extends RecipeCategory> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentCategory = inits.isInitialized("parentCategory") ? new QRecipeCategory(forProperty("parentCategory"), inits.get("parentCategory")) : null;
    }

}

