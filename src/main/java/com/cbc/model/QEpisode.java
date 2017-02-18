package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QEpisode is a Querydsl query type for Episode
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEpisode extends EntityPathBase<Episode> {

    private static final long serialVersionUID = -1074763681L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEpisode episode = new QEpisode("episode");

    public final DatePath<java.util.Date> displayingDate = createDate("displayingDate", java.util.Date.class);

    public final ListPath<EpisodesAdDiv, QEpisodesAdDiv> episodesAdDivs = this.<EpisodesAdDiv, QEpisodesAdDiv>createList("episodesAdDivs", EpisodesAdDiv.class, QEpisodesAdDiv.class, PathInits.DIRECT2);

    public final BooleanPath hubSelected = createBoolean("hubSelected");

    public final QHubSlick hubSlick;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<java.math.BigInteger> numberOfViews = createNumber("numberOfViews", java.math.BigInteger.class);

    public final StringPath photoPath = createString("photoPath");

    public final QProgram programBean;

    public final ListPath<Recipe, QRecipe> recipes = this.<Recipe, QRecipe>createList("recipes", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final StringPath url = createString("url");

    public QEpisode(String variable) {
        this(Episode.class, forVariable(variable), INITS);
    }

    public QEpisode(Path<? extends Episode> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEpisode(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEpisode(PathMetadata<?> metadata, PathInits inits) {
        this(Episode.class, metadata, inits);
    }

    public QEpisode(Class<? extends Episode> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hubSlick = inits.isInitialized("hubSlick") ? new QHubSlick(forProperty("hubSlick")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
    }

}

