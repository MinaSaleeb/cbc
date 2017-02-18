package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFoodSupplier is a Querydsl query type for FoodSupplier
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFoodSupplier extends EntityPathBase<FoodSupplier> {

    private static final long serialVersionUID = -1938071450L;

    public static final QFoodSupplier foodSupplier = new QFoodSupplier("foodSupplier");

    public final ListPath<FoodItem, QFoodItem> foodItems = this.<FoodItem, QFoodItem>createList("foodItems", FoodItem.class, QFoodItem.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath supplierLogoPath = createString("supplierLogoPath");

    public final StringPath supplierName = createString("supplierName");

    public QFoodSupplier(String variable) {
        super(FoodSupplier.class, forVariable(variable));
    }

    public QFoodSupplier(Path<? extends FoodSupplier> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodSupplier(PathMetadata<?> metadata) {
        super(FoodSupplier.class, metadata);
    }

}

