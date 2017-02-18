package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRecipeStep is a Querydsl query type for RecipeStep
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecipeStep extends EntityPathBase<RecipeStep> {

    private static final long serialVersionUID = -1279073130L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecipeStep recipeStep = new QRecipeStep("recipeStep");

    public final NumberPath<Double> endTime = createNumber("endTime", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QRecipe recipeBean;

    public final NumberPath<Double> startTime = createNumber("startTime", Double.class);

    public final StringPath stepContent = createString("stepContent");

    public QRecipeStep(String variable) {
        this(RecipeStep.class, forVariable(variable), INITS);
    }

    public QRecipeStep(Path<? extends RecipeStep> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRecipeStep(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRecipeStep(PathMetadata<?> metadata, PathInits inits) {
        this(RecipeStep.class, metadata, inits);
    }

    public QRecipeStep(Class<? extends RecipeStep> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.recipeBean = inits.isInitialized("recipeBean") ? new QRecipe(forProperty("recipeBean"), inits.get("recipeBean")) : null;
    }

}

