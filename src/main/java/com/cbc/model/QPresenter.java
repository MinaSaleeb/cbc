package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPresenter is a Querydsl query type for Presenter
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPresenter extends EntityPathBase<Presenter> {

    private static final long serialVersionUID = -536222708L;

    public static final QPresenter presenter = new QPresenter("presenter");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath photoPath = createString("photoPath");

    public final StringPath photoPath1 = createString("photoPath1");

    public final StringPath photoPath2 = createString("photoPath2");

    public final StringPath photoPath3 = createString("photoPath3");

    public final ListPath<Program, QProgram> programs = this.<Program, QProgram>createList("programs", Program.class, QProgram.class, PathInits.DIRECT2);

    public final ListPath<Recipe, QRecipe> recipes = this.<Recipe, QRecipe>createList("recipes", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public final StringPath slug = createString("slug");

    public QPresenter(String variable) {
        super(Presenter.class, forVariable(variable));
    }

    public QPresenter(Path<? extends Presenter> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPresenter(PathMetadata<?> metadata) {
        super(Presenter.class, metadata);
    }

}

