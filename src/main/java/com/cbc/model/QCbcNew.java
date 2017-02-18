package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCbcNew is a Querydsl query type for CbcNew
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCbcNew extends EntityPathBase<CbcNew> {

    private static final long serialVersionUID = 1418948664L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCbcNew cbcNew = new QCbcNew("cbcNew");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<NewsAdDiv, QNewsAdDiv> newsAdDivs = this.<NewsAdDiv, QNewsAdDiv>createList("newsAdDivs", NewsAdDiv.class, QNewsAdDiv.class, PathInits.DIRECT2);

    public final QNewsCategory newsCategory;

    public final StringPath photoPath = createString("photoPath");

    public final DateTimePath<java.util.Date> postingDate = createDateTime("postingDate", java.util.Date.class);

    public final StringPath slug = createString("slug");

    public final StringPath tags = createString("tags");

    public final StringPath thumbnailImage = createString("thumbnailImage");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath videoUrl = createString("videoUrl");

    public QCbcNew(String variable) {
        this(CbcNew.class, forVariable(variable), INITS);
    }

    public QCbcNew(Path<? extends CbcNew> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCbcNew(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCbcNew(PathMetadata<?> metadata, PathInits inits) {
        this(CbcNew.class, metadata, inits);
    }

    public QCbcNew(Class<? extends CbcNew> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.newsCategory = inits.isInitialized("newsCategory") ? new QNewsCategory(forProperty("newsCategory"), inits.get("newsCategory")) : null;
    }

}

