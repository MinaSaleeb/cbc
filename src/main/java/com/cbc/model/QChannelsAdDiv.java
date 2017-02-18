package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QChannelsAdDiv is a Querydsl query type for ChannelsAdDiv
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QChannelsAdDiv extends EntityPathBase<ChannelsAdDiv> {

    private static final long serialVersionUID = -1137539358L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChannelsAdDiv channelsAdDiv = new QChannelsAdDiv("channelsAdDiv");

    public final QAdDiv adDiv;

    public final StringPath adScript = createString("adScript");

    public final QChannel channelBean;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QChannelsAdDiv(String variable) {
        this(ChannelsAdDiv.class, forVariable(variable), INITS);
    }

    public QChannelsAdDiv(Path<? extends ChannelsAdDiv> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QChannelsAdDiv(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QChannelsAdDiv(PathMetadata<?> metadata, PathInits inits) {
        this(ChannelsAdDiv.class, metadata, inits);
    }

    public QChannelsAdDiv(Class<? extends ChannelsAdDiv> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.adDiv = inits.isInitialized("adDiv") ? new QAdDiv(forProperty("adDiv")) : null;
        this.channelBean = inits.isInitialized("channelBean") ? new QChannel(forProperty("channelBean")) : null;
    }

}

