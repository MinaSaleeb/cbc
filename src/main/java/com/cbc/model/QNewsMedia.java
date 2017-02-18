package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QNewsMedia is a Querydsl query type for NewsMedia
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QNewsMedia extends EntityPathBase<NewsMedia> {

    private static final long serialVersionUID = 669737525L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewsMedia newsMedia = new QNewsMedia("newsMedia");

    public final QCbcNew cbcNew;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imagePath = createString("imagePath");

    public QNewsMedia(String variable) {
        this(NewsMedia.class, forVariable(variable), INITS);
    }

    public QNewsMedia(Path<? extends NewsMedia> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsMedia(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsMedia(PathMetadata<?> metadata, PathInits inits) {
        this(NewsMedia.class, metadata, inits);
    }

    public QNewsMedia(Class<? extends NewsMedia> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cbcNew = inits.isInitialized("cbcNew") ? new QCbcNew(forProperty("cbcNew"), inits.get("cbcNew")) : null;
    }

}

