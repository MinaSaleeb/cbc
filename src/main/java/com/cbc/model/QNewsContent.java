package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QNewsContent is a Querydsl query type for NewsContent
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QNewsContent extends EntityPathBase<NewsContent> {

    private static final long serialVersionUID = -616573302L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewsContent newsContent = new QNewsContent("newsContent");

    public final QCbcNew cbcNew;

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QNewsContent(String variable) {
        this(NewsContent.class, forVariable(variable), INITS);
    }

    public QNewsContent(Path<? extends NewsContent> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsContent(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsContent(PathMetadata<?> metadata, PathInits inits) {
        this(NewsContent.class, metadata, inits);
    }

    public QNewsContent(Class<? extends NewsContent> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cbcNew = inits.isInitialized("cbcNew") ? new QCbcNew(forProperty("cbcNew"), inits.get("cbcNew")) : null;
    }

}

