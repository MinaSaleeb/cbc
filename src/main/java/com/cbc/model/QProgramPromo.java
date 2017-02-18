package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramPromo is a Querydsl query type for ProgramPromo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramPromo extends EntityPathBase<ProgramPromo> {

    private static final long serialVersionUID = -1068474105L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgramPromo programPromo = new QProgramPromo("programPromo");

    public final StringPath description = createString("description");

    public final QHubSlick hubSlick;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProgram programBean;

    public final StringPath promoUrl = createString("promoUrl");

    public final StringPath thumbnailPath = createString("thumbnailPath");

    public final StringPath title = createString("title");

    public QProgramPromo(String variable) {
        this(ProgramPromo.class, forVariable(variable), INITS);
    }

    public QProgramPromo(Path<? extends ProgramPromo> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramPromo(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramPromo(PathMetadata<?> metadata, PathInits inits) {
        this(ProgramPromo.class, metadata, inits);
    }

    public QProgramPromo(Class<? extends ProgramPromo> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hubSlick = inits.isInitialized("hubSlick") ? new QHubSlick(forProperty("hubSlick")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
    }

}

