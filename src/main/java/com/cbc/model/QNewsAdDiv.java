package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QNewsAdDiv is a Querydsl query type for NewsAdDiv
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QNewsAdDiv extends EntityPathBase<NewsAdDiv> {

    private static final long serialVersionUID = 658594751L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewsAdDiv newsAdDiv = new QNewsAdDiv("newsAdDiv");

    public final QAdDiv adDiv;

    public final StringPath adScript = createString("adScript");

    public final QCbcNew cbcNew;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QNewsAdDiv(String variable) {
        this(NewsAdDiv.class, forVariable(variable), INITS);
    }

    public QNewsAdDiv(Path<? extends NewsAdDiv> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsAdDiv(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsAdDiv(PathMetadata<?> metadata, PathInits inits) {
        this(NewsAdDiv.class, metadata, inits);
    }

    public QNewsAdDiv(Class<? extends NewsAdDiv> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.adDiv = inits.isInitialized("adDiv") ? new QAdDiv(forProperty("adDiv")) : null;
        this.cbcNew = inits.isInitialized("cbcNew") ? new QCbcNew(forProperty("cbcNew"), inits.get("cbcNew")) : null;
    }

}

