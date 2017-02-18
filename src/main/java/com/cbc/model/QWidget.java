package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QWidget is a Querydsl query type for Widget
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QWidget extends EntityPathBase<Widget> {

    private static final long serialVersionUID = 1998050144L;

    public static final QWidget widget = new QWidget("widget");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath image = createString("image");

    public final StringPath name = createString("name");

    public final StringPath slug = createString("slug");

    public final StringPath type = createString("type");

    public final StringPath url = createString("url");

    public final ListPath<WidgetContent, QWidgetContent> widgetContents = this.<WidgetContent, QWidgetContent>createList("widgetContents", WidgetContent.class, QWidgetContent.class, PathInits.DIRECT2);

    public QWidget(String variable) {
        super(Widget.class, forVariable(variable));
    }

    public QWidget(Path<? extends Widget> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWidget(PathMetadata<?> metadata) {
        super(Widget.class, metadata);
    }

}

