package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramCompitation is a Querydsl query type for ProgramCompitation
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramCompitation extends EntityPathBase<ProgramCompitation> {

    private static final long serialVersionUID = 600473779L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgramCompitation programCompitation = new QProgramCompitation("programCompitation");

    public final StringPath description = createString("description");

    public final StringPath id = createString("id");

    public final StringPath photoPath = createString("photoPath");

    public final QProgram programBean;

    public final StringPath title = createString("title");

    public QProgramCompitation(String variable) {
        this(ProgramCompitation.class, forVariable(variable), INITS);
    }

    public QProgramCompitation(Path<? extends ProgramCompitation> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramCompitation(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramCompitation(PathMetadata<?> metadata, PathInits inits) {
        this(ProgramCompitation.class, metadata, inits);
    }

    public QProgramCompitation(Class<? extends ProgramCompitation> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
    }

}

