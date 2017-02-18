package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTimeLine is a Querydsl query type for TimeLine
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTimeLine extends EntityPathBase<TimeLine> {

    private static final long serialVersionUID = -402593155L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimeLine timeLine = new QTimeLine("timeLine");

    public final QChannel channelBean;

    public final NumberPath<Float> duration = createNumber("duration", Float.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Byte> isRepeated = createNumber("isRepeated", Byte.class);

    public final QProgram programBean;

    public final QScheduleDay scheduleDay;

    public final StringPath startTime = createString("startTime");

    public final StringPath staticProgramImage = createString("staticProgramImage");

    public final StringPath staticProgramTitle = createString("staticProgramTitle");

    public QTimeLine(String variable) {
        this(TimeLine.class, forVariable(variable), INITS);
    }

    public QTimeLine(Path<? extends TimeLine> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTimeLine(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTimeLine(PathMetadata<?> metadata, PathInits inits) {
        this(TimeLine.class, metadata, inits);
    }

    public QTimeLine(Class<? extends TimeLine> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.channelBean = inits.isInitialized("channelBean") ? new QChannel(forProperty("channelBean")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
        this.scheduleDay = inits.isInitialized("scheduleDay") ? new QScheduleDay(forProperty("scheduleDay")) : null;
    }

}

