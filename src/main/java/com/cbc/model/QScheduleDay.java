package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QScheduleDay is a Querydsl query type for ScheduleDay
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QScheduleDay extends EntityPathBase<ScheduleDay> {

    private static final long serialVersionUID = 1486403049L;

    public static final QScheduleDay scheduleDay = new QScheduleDay("scheduleDay");

    public final DatePath<java.util.Date> actualDate = createDate("actualDate", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QScheduleDay(String variable) {
        super(ScheduleDay.class, forVariable(variable));
    }

    public QScheduleDay(Path<? extends ScheduleDay> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScheduleDay(PathMetadata<?> metadata) {
        super(ScheduleDay.class, metadata);
    }

}

