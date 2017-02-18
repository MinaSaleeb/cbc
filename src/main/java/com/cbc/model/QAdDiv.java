package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAdDiv is a Querydsl query type for AdDiv
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAdDiv extends EntityPathBase<AdDiv> {

    private static final long serialVersionUID = 1429429458L;

    public static final QAdDiv adDiv = new QAdDiv("adDiv");

    public final StringPath description = createString("description");

    public final StringPath divCode = createString("divCode");

    public QAdDiv(String variable) {
        super(AdDiv.class, forVariable(variable));
    }

    public QAdDiv(Path<? extends AdDiv> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdDiv(PathMetadata<?> metadata) {
        super(AdDiv.class, metadata);
    }

}

