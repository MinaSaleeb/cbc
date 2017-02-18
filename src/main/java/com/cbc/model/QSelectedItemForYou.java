package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSelectedItemForYou is a Querydsl query type for SelectedItemForYou
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSelectedItemForYou extends EntityPathBase<SelectedItemForYou> {

    private static final long serialVersionUID = 1178956704L;

    public static final QSelectedItemForYou selectedItemForYou = new QSelectedItemForYou("selectedItemForYou");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ItemId = createString("ItemId");

    public final StringPath itemType = createString("itemType");

    public final NumberPath<Short> order = createNumber("order", Short.class);

    public final NumberPath<Short> status = createNumber("status", Short.class);

    public final DatePath<java.util.Date> updateDate = createDate("updateDate", java.util.Date.class);

    public QSelectedItemForYou(String variable) {
        super(SelectedItemForYou.class, forVariable(variable));
    }

    public QSelectedItemForYou(Path<? extends SelectedItemForYou> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelectedItemForYou(PathMetadata<?> metadata) {
        super(SelectedItemForYou.class, metadata);
    }

}

