package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRecipeIngredient is a Querydsl query type for RecipeIngredient
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecipeIngredient extends EntityPathBase<RecipeIngredient> {

    private static final long serialVersionUID = 1292914715L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecipeIngredient recipeIngredient = new QRecipeIngredient("recipeIngredient");

    public final QFoodItem foodItem;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ingredientContent = createString("ingredientContent");

    public final QMeasureUnit measureUnit;

    public final NumberPath<Double> quantity = createNumber("quantity", Double.class);

    public final QRecipe recipeBean;

    public final StringPath tags = createString("tags");

    public QRecipeIngredient(String variable) {
        this(RecipeIngredient.class, forVariable(variable), INITS);
    }

    public QRecipeIngredient(Path<? extends RecipeIngredient> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRecipeIngredient(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRecipeIngredient(PathMetadata<?> metadata, PathInits inits) {
        this(RecipeIngredient.class, metadata, inits);
    }

    public QRecipeIngredient(Class<? extends RecipeIngredient> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodItem = inits.isInitialized("foodItem") ? new QFoodItem(forProperty("foodItem"), inits.get("foodItem")) : null;
        this.measureUnit = inits.isInitialized("measureUnit") ? new QMeasureUnit(forProperty("measureUnit")) : null;
        this.recipeBean = inits.isInitialized("recipeBean") ? new QRecipe(forProperty("recipeBean"), inits.get("recipeBean")) : null;
    }

}

