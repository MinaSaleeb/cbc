package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUserAnswer is a Querydsl query type for UserAnswer
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserAnswer extends EntityPathBase<UserAnswer> {

    private static final long serialVersionUID = 143744645L;

    public static final QUserAnswer userAnswer = new QUserAnswer("userAnswer");

    public final StringPath answer = createString("answer");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> questionId = createNumber("questionId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUserAnswer(String variable) {
        super(UserAnswer.class, forVariable(variable));
    }

    public QUserAnswer(Path<? extends UserAnswer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserAnswer(PathMetadata<?> metadata) {
        super(UserAnswer.class, metadata);
    }

}

