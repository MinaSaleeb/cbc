package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRecipeType is a Querydsl query type for RecipeType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecipeType extends EntityPathBase<RecipeType> {

    private static final long serialVersionUID = -1279038204L;

    public static final QRecipeType recipeType = new QRecipeType("recipeType");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath imagePath = createString("imagePath");

    public final ListPath<Recipe, QRecipe> recipes = this.<Recipe, QRecipe>createList("recipes", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public final StringPath typeName = createString("typeName");

    public QRecipeType(String variable) {
        super(RecipeType.class, forVariable(variable));
    }

    public QRecipeType(Path<? extends RecipeType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecipeType(PathMetadata<?> metadata) {
        super(RecipeType.class, metadata);
    }

}

