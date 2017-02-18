package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFoodItem is a Querydsl query type for FoodItem
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFoodItem extends EntityPathBase<FoodItem> {

    private static final long serialVersionUID = 2054176429L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFoodItem foodItem = new QFoodItem("foodItem");

    public final StringPath adImage = createString("adImage");

    public final StringPath alternativeNames = createString("alternativeNames");

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final StringPath description = createString("description");

    public final QFoodSupplier foodSupplier;

    public final QFoodType foodType;

    public final NumberPath<Double> fromPrice = createNumber("fromPrice", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath itemName = createString("itemName");

    public final QMeasureUnit measureUnit;

    public final NumberPath<Double> numberOfCalories = createNumber("numberOfCalories", Double.class);

    public final ListPath<RecipeIngredient, QRecipeIngredient> recipeIngredients = this.<RecipeIngredient, QRecipeIngredient>createList("recipeIngredients", RecipeIngredient.class, QRecipeIngredient.class, PathInits.DIRECT2);

    public final StringPath thumbnailImage = createString("thumbnailImage");

    public final NumberPath<Double> toPrice = createNumber("toPrice", Double.class);

    public final StringPath url = createString("url");

    public QFoodItem(String variable) {
        this(FoodItem.class, forVariable(variable), INITS);
    }

    public QFoodItem(Path<? extends FoodItem> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFoodItem(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFoodItem(PathMetadata<?> metadata, PathInits inits) {
        this(FoodItem.class, metadata, inits);
    }

    public QFoodItem(Class<? extends FoodItem> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodSupplier = inits.isInitialized("foodSupplier") ? new QFoodSupplier(forProperty("foodSupplier")) : null;
        this.foodType = inits.isInitialized("foodType") ? new QFoodType(forProperty("foodType")) : null;
        this.measureUnit = inits.isInitialized("measureUnit") ? new QMeasureUnit(forProperty("measureUnit")) : null;
    }

}

