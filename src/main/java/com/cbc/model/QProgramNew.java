package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramNew is a Querydsl query type for ProgramNew
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramNew extends EntityPathBase<ProgramNew> {

    private static final long serialVersionUID = -894967912L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgramNew programNew = new QProgramNew("programNew");

    public final QCbcNew cbcNew;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProgram programBean;

    public QProgramNew(String variable) {
        this(ProgramNew.class, forVariable(variable), INITS);
    }

    public QProgramNew(Path<? extends ProgramNew> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramNew(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramNew(PathMetadata<?> metadata, PathInits inits) {
        this(ProgramNew.class, metadata, inits);
    }

    public QProgramNew(Class<? extends ProgramNew> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cbcNew = inits.isInitialized("cbcNew") ? new QCbcNew(forProperty("cbcNew"), inits.get("cbcNew")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
    }

}

