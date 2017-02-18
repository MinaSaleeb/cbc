package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCarouselImage is a Querydsl query type for CarouselImage
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCarouselImage extends EntityPathBase<CarouselImage> {

    private static final long serialVersionUID = -1674083521L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCarouselImage carouselImage = new QCarouselImage("carouselImage");

    public final QCarousel carouselBean;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imagePath = createString("imagePath");

    public final QProgram programBean;

    public QCarouselImage(String variable) {
        this(CarouselImage.class, forVariable(variable), INITS);
    }

    public QCarouselImage(Path<? extends CarouselImage> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCarouselImage(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCarouselImage(PathMetadata<?> metadata, PathInits inits) {
        this(CarouselImage.class, metadata, inits);
    }

    public QCarouselImage(Class<? extends CarouselImage> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.carouselBean = inits.isInitialized("carouselBean") ? new QCarousel(forProperty("carouselBean"), inits.get("carouselBean")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
    }

}

