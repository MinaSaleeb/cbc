package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QMeasureUnit is a Querydsl query type for MeasureUnit
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMeasureUnit extends EntityPathBase<MeasureUnit> {

    private static final long serialVersionUID = -503124890L;

    public static final QMeasureUnit measureUnit = new QMeasureUnit("measureUnit");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QMeasureUnit(String variable) {
        super(MeasureUnit.class, forVariable(variable));
    }

    public QMeasureUnit(Path<? extends MeasureUnit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMeasureUnit(PathMetadata<?> metadata) {
        super(MeasureUnit.class, metadata);
    }

}

