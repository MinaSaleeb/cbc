package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramScene is a Querydsl query type for ProgramScene
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramScene extends EntityPathBase<ProgramScene> {

    private static final long serialVersionUID = -1066159996L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgramScene programScene = new QProgramScene("programScene");

    public final StringPath description = createString("description");

    public final BooleanPath hubSelected = createBoolean("hubSelected");

    public final QHubSlick hubSlick;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath photoPath = createString("photoPath");

    public final QProgram programBean;

    public final StringPath title = createString("title");

    public final StringPath vedioUrl = createString("vedioUrl");

    public QProgramScene(String variable) {
        this(ProgramScene.class, forVariable(variable), INITS);
    }

    public QProgramScene(Path<? extends ProgramScene> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramScene(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramScene(PathMetadata<?> metadata, PathInits inits) {
        this(ProgramScene.class, metadata, inits);
    }

    public QProgramScene(Class<? extends ProgramScene> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hubSlick = inits.isInitialized("hubSlick") ? new QHubSlick(forProperty("hubSlick")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
    }

}

