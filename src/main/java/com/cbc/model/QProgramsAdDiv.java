package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramsAdDiv is a Querydsl query type for ProgramsAdDiv
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramsAdDiv extends EntityPathBase<ProgramsAdDiv> {

    private static final long serialVersionUID = -2101525597L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgramsAdDiv programsAdDiv = new QProgramsAdDiv("programsAdDiv");

    public final QAdDiv adDiv;

    public final StringPath adScript = createString("adScript");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProgram programBean;

    public QProgramsAdDiv(String variable) {
        this(ProgramsAdDiv.class, forVariable(variable), INITS);
    }

    public QProgramsAdDiv(Path<? extends ProgramsAdDiv> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramsAdDiv(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramsAdDiv(PathMetadata<?> metadata, PathInits inits) {
        this(ProgramsAdDiv.class, metadata, inits);
    }

    public QProgramsAdDiv(Class<? extends ProgramsAdDiv> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.adDiv = inits.isInitialized("adDiv") ? new QAdDiv(forProperty("adDiv")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
    }

}

