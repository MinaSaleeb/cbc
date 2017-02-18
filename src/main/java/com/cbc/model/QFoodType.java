package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFoodType is a Querydsl query type for FoodType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFoodType extends EntityPathBase<FoodType> {

    private static final long serialVersionUID = 2054509268L;

    public static final QFoodType foodType = new QFoodType("foodType");

    public final ListPath<FoodItem, QFoodItem> foodItems = this.<FoodItem, QFoodItem>createList("foodItems", FoodItem.class, QFoodItem.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath typeName = createString("typeName");

    public QFoodType(String variable) {
        super(FoodType.class, forVariable(variable));
    }

    public QFoodType(Path<? extends FoodType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodType(PathMetadata<?> metadata) {
        super(FoodType.class, metadata);
    }

}

