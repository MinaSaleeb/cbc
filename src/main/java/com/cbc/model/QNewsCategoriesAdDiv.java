package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QNewsCategoriesAdDiv is a Querydsl query type for NewsCategoriesAdDiv
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QNewsCategoriesAdDiv extends EntityPathBase<NewsCategoriesAdDiv> {

    private static final long serialVersionUID = 1328588227L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewsCategoriesAdDiv newsCategoriesAdDiv = new QNewsCategoriesAdDiv("newsCategoriesAdDiv");

    public final QAdDiv adDiv;

    public final StringPath adScript = createString("adScript");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QNewsCategory newsCategory;

    public QNewsCategoriesAdDiv(String variable) {
        this(NewsCategoriesAdDiv.class, forVariable(variable), INITS);
    }

    public QNewsCategoriesAdDiv(Path<? extends NewsCategoriesAdDiv> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsCategoriesAdDiv(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsCategoriesAdDiv(PathMetadata<?> metadata, PathInits inits) {
        this(NewsCategoriesAdDiv.class, metadata, inits);
    }

    public QNewsCategoriesAdDiv(Class<? extends NewsCategoriesAdDiv> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.adDiv = inits.isInitialized("adDiv") ? new QAdDiv(forProperty("adDiv")) : null;
        this.newsCategory = inits.isInitialized("newsCategory") ? new QNewsCategory(forProperty("newsCategory"), inits.get("newsCategory")) : null;
    }

}

