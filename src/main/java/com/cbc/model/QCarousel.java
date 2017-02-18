package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QCarousel is a Querydsl query type for Carousel
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCarousel extends EntityPathBase<Carousel> {

    private static final long serialVersionUID = 1677919100L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCarousel carousel = new QCarousel("carousel");

    public final ListPath<CarouselImage, QCarouselImage> carouselImages = this.<CarouselImage, QCarouselImage>createList("carouselImages", CarouselImage.class, QCarouselImage.class, PathInits.DIRECT2);

    public final QChannel channelBean;

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QCarousel(String variable) {
        this(Carousel.class, forVariable(variable), INITS);
    }

    public QCarousel(Path<? extends Carousel> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCarousel(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCarousel(PathMetadata<?> metadata, PathInits inits) {
        this(Carousel.class, metadata, inits);
    }

    public QCarousel(Class<? extends Carousel> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.channelBean = inits.isInitialized("channelBean") ? new QChannel(forProperty("channelBean")) : null;
    }

}

