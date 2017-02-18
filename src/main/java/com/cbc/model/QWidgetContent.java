package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QWidgetContent is a Querydsl query type for WidgetContent
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QWidgetContent extends EntityPathBase<WidgetContent> {

    private static final long serialVersionUID = -647664391L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWidgetContent widgetContent = new QWidgetContent("widgetContent");

    public final StringPath contentUrl = createString("contentUrl");

    public final StringPath contentUrlType = createString("contentUrlType");

    public final StringPath description = createString("description");

    public final StringPath htmlContent = createString("htmlContent");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath slug = createString("slug");

    public final StringPath thumbnailImage = createString("thumbnailImage");

    public final StringPath title = createString("title");

    public final QWidget widgetBean;

    public QWidgetContent(String variable) {
        this(WidgetContent.class, forVariable(variable), INITS);
    }

    public QWidgetContent(Path<? extends WidgetContent> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWidgetContent(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWidgetContent(PathMetadata<?> metadata, PathInits inits) {
        this(WidgetContent.class, metadata, inits);
    }

    public QWidgetContent(Class<? extends WidgetContent> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.widgetBean = inits.isInitialized("widgetBean") ? new QWidget(forProperty("widgetBean")) : null;
    }

}

