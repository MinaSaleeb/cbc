package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTabsContainer is a Querydsl query type for TabsContainer
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTabsContainer extends EntityPathBase<TabsContainer> {

    private static final long serialVersionUID = 1274189319L;

    public static final QTabsContainer tabsContainer = new QTabsContainer("tabsContainer");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public QTabsContainer(String variable) {
        super(TabsContainer.class, forVariable(variable));
    }

    public QTabsContainer(Path<? extends TabsContainer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTabsContainer(PathMetadata<?> metadata) {
        super(TabsContainer.class, metadata);
    }

}

