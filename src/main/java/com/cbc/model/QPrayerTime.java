package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPrayerTime is a Querydsl query type for PrayerTime
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPrayerTime extends EntityPathBase<PrayerTime> {

    private static final long serialVersionUID = -1086509456L;

    public static final QPrayerTime prayerTime = new QPrayerTime("prayerTime");

    public final StringPath id = createString("id");

    public final DateTimePath<java.util.Date> prayingDate = createDateTime("prayingDate", java.util.Date.class);

    public final StringPath prayingTimeName = createString("prayingTimeName");

    public QPrayerTime(String variable) {
        super(PrayerTime.class, forVariable(variable));
    }

    public QPrayerTime(Path<? extends PrayerTime> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrayerTime(PathMetadata<?> metadata) {
        super(PrayerTime.class, metadata);
    }

}

