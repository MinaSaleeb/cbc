package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QExternalPage is a Querydsl query type for ExternalPage
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QExternalPage extends EntityPathBase<ExternalPage> {

    private static final long serialVersionUID = 581079318L;

    public static final QExternalPage externalPage = new QExternalPage("externalPage");

    public final StringPath adScript1 = createString("adScript1");

    public final StringPath adScript2 = createString("adScript2");

    public final StringPath adScript3 = createString("adScript3");

    public final StringPath answer1 = createString("answer1");

    public final StringPath answer2 = createString("answer2");

    public final StringPath answer3 = createString("answer3");

    public final StringPath answer4 = createString("answer4");

    public final StringPath bgImage = createString("bgImage");

    public final StringPath companyName = createString("companyName");

    public final StringPath hintText = createString("hintText");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath question = createString("question");

    public QExternalPage(String variable) {
        super(ExternalPage.class, forVariable(variable));
    }

    public QExternalPage(Path<? extends ExternalPage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExternalPage(PathMetadata<?> metadata) {
        super(ExternalPage.class, metadata);
    }

}

