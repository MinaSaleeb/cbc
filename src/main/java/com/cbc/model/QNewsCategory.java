package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QNewsCategory is a Querydsl query type for NewsCategory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QNewsCategory extends EntityPathBase<NewsCategory> {

    private static final long serialVersionUID = -1316070131L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewsCategory newsCategory = new QNewsCategory("newsCategory");

    public final StringPath bgImage = createString("bgImage");

    public final StringPath categoryName = createString("categoryName");

    public final ListPath<CbcNew, QCbcNew> cbcNews = this.<CbcNew, QCbcNew>createList("cbcNews", CbcNew.class, QCbcNew.class, PathInits.DIRECT2);

    public final QChannel channelBean;

    public final QCbcNew featuredNews;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ListPath<NewsCategoriesAdDiv, QNewsCategoriesAdDiv> newsCategoryAdDivs = this.<NewsCategoriesAdDiv, QNewsCategoriesAdDiv>createList("newsCategoryAdDivs", NewsCategoriesAdDiv.class, QNewsCategoriesAdDiv.class, PathInits.DIRECT2);

    public final QNewsCategory parentCategory;

    public final ListPath<NewsCategory, QNewsCategory> subCategories = this.<NewsCategory, QNewsCategory>createList("subCategories", NewsCategory.class, QNewsCategory.class, PathInits.DIRECT2);

    public QNewsCategory(String variable) {
        this(NewsCategory.class, forVariable(variable), INITS);
    }

    public QNewsCategory(Path<? extends NewsCategory> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsCategory(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QNewsCategory(PathMetadata<?> metadata, PathInits inits) {
        this(NewsCategory.class, metadata, inits);
    }

    public QNewsCategory(Class<? extends NewsCategory> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.channelBean = inits.isInitialized("channelBean") ? new QChannel(forProperty("channelBean")) : null;
        this.featuredNews = inits.isInitialized("featuredNews") ? new QCbcNew(forProperty("featuredNews"), inits.get("featuredNews")) : null;
        this.parentCategory = inits.isInitialized("parentCategory") ? new QNewsCategory(forProperty("parentCategory"), inits.get("parentCategory")) : null;
    }

}

