package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRecipeCuisine is a Querydsl query type for RecipeCuisine
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecipeCuisine extends EntityPathBase<RecipeCuisine> {

    private static final long serialVersionUID = -1200405702L;

    public static final QRecipeCuisine recipeCuisine = new QRecipeCuisine("recipeCuisine");

    public final StringPath icon = createString("icon");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath image = createString("image");

    public final StringPath name = createString("name");

    public final ListPath<Recipe, QRecipe> recipes = this.<Recipe, QRecipe>createList("recipes", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public final StringPath thumbnailImage = createString("thumbnailImage");

    public QRecipeCuisine(String variable) {
        super(RecipeCuisine.class, forVariable(variable));
    }

    public QRecipeCuisine(Path<? extends RecipeCuisine> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecipeCuisine(PathMetadata<?> metadata) {
        super(RecipeCuisine.class, metadata);
    }

}

