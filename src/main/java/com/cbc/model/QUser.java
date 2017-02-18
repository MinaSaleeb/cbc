package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 185269223L;

    public static final QUser user = new QUser("user");

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath mobileNumber = createString("mobileNumber");

    public final StringPath password = createString("password");

    public final ListPath<Recipe, QRecipe> recipes1 = this.<Recipe, QRecipe>createList("recipes1", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public final ListPath<Recipe, QRecipe> recipes2 = this.<Recipe, QRecipe>createList("recipes2", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata<?> metadata) {
        super(User.class, metadata);
    }

}

