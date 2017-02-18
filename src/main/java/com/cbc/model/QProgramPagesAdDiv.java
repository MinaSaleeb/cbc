package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramPagesAdDiv is a Querydsl query type for ProgramPagesAdDiv
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramPagesAdDiv extends EntityPathBase<ProgramPagesAdDiv> {

    private static final long serialVersionUID = -813340910L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgramPagesAdDiv programPagesAdDiv = new QProgramPagesAdDiv("programPagesAdDiv");

    public final QAdDiv adDiv;

    public final StringPath adScript = createString("adScript");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProgram programBean;

    public final QProgramPage programPage;

    public QProgramPagesAdDiv(String variable) {
        this(ProgramPagesAdDiv.class, forVariable(variable), INITS);
    }

    public QProgramPagesAdDiv(Path<? extends ProgramPagesAdDiv> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramPagesAdDiv(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramPagesAdDiv(PathMetadata<?> metadata, PathInits inits) {
        this(ProgramPagesAdDiv.class, metadata, inits);
    }

    public QProgramPagesAdDiv(Class<? extends ProgramPagesAdDiv> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.adDiv = inits.isInitialized("adDiv") ? new QAdDiv(forProperty("adDiv")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
        this.programPage = inits.isInitialized("programPage") ? new QProgramPage(forProperty("programPage")) : null;
    }

}

