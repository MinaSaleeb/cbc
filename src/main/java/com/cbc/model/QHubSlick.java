package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QHubSlick is a Querydsl query type for HubSlick
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QHubSlick extends EntityPathBase<HubSlick> {

    private static final long serialVersionUID = 1888037823L;

    public static final QHubSlick hubSlick = new QHubSlick("hubSlick");

    public final ListPath<Episode, QEpisode> episodes = this.<Episode, QEpisode>createList("episodes", Episode.class, QEpisode.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> orderNumber = createNumber("orderNumber", Integer.class);

    public final ListPath<Program, QProgram> programs = this.<Program, QProgram>createList("programs", Program.class, QProgram.class, PathInits.DIRECT2);

    public final ListPath<ProgramScene, QProgramScene> programScenes = this.<ProgramScene, QProgramScene>createList("programScenes", ProgramScene.class, QProgramScene.class, PathInits.DIRECT2);

    public final ListPath<ProgramPromo, QProgramPromo> promos = this.<ProgramPromo, QProgramPromo>createList("promos", ProgramPromo.class, QProgramPromo.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QHubSlick(String variable) {
        super(HubSlick.class, forVariable(variable));
    }

    public QHubSlick(Path<? extends HubSlick> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHubSlick(PathMetadata<?> metadata) {
        super(HubSlick.class, metadata);
    }

}

