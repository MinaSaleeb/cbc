package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramTabContent is a Querydsl query type for ProgramTabContent
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramTabContent extends EntityPathBase<ProgramTabContent> {

    private static final long serialVersionUID = -1906315732L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgramTabContent programTabContent = new QProgramTabContent("programTabContent");

    public final StringPath contentType = createString("contentType");

    public final StringPath contentUrl = createString("contentUrl");

    public final StringPath description = createString("description");

    public final StringPath htmlContent = createString("htmlContent");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProgramTab programTabBean;

    public final StringPath thumbnailImage = createString("thumbnailImage");

    public final StringPath title = createString("title");

    public QProgramTabContent(String variable) {
        this(ProgramTabContent.class, forVariable(variable), INITS);
    }

    public QProgramTabContent(Path<? extends ProgramTabContent> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramTabContent(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramTabContent(PathMetadata<?> metadata, PathInits inits) {
        this(ProgramTabContent.class, metadata, inits);
    }

    public QProgramTabContent(Class<? extends ProgramTabContent> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.programTabBean = inits.isInitialized("programTabBean") ? new QProgramTab(forProperty("programTabBean"), inits.get("programTabBean")) : null;
    }

}

