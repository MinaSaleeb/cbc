package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QEpisodesAdDiv is a Querydsl query type for EpisodesAdDiv
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEpisodesAdDiv extends EntityPathBase<EpisodesAdDiv> {

    private static final long serialVersionUID = -42848806L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEpisodesAdDiv episodesAdDiv = new QEpisodesAdDiv("episodesAdDiv");

    public final QAdDiv adDiv;

    public final StringPath adScript = createString("adScript");

    public final QEpisode episodeBean;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QEpisodesAdDiv(String variable) {
        this(EpisodesAdDiv.class, forVariable(variable), INITS);
    }

    public QEpisodesAdDiv(Path<? extends EpisodesAdDiv> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEpisodesAdDiv(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEpisodesAdDiv(PathMetadata<?> metadata, PathInits inits) {
        this(EpisodesAdDiv.class, metadata, inits);
    }

    public QEpisodesAdDiv(Class<? extends EpisodesAdDiv> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.adDiv = inits.isInitialized("adDiv") ? new QAdDiv(forProperty("adDiv")) : null;
        this.episodeBean = inits.isInitialized("episodeBean") ? new QEpisode(forProperty("episodeBean"), inits.get("episodeBean")) : null;
    }

}

