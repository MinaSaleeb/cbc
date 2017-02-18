package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCitizenService is a Querydsl query type for CitizenService
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCitizenService extends EntityPathBase<CitizenService> {

    private static final long serialVersionUID = 1192221513L;

    public static final QCitizenService citizenService = new QCitizenService("citizenService");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath serviceName = createString("serviceName");

    public final StringPath serviceUrl = createString("serviceUrl");

    public QCitizenService(String variable) {
        super(CitizenService.class, forVariable(variable));
    }

    public QCitizenService(Path<? extends CitizenService> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCitizenService(PathMetadata<?> metadata) {
        super(CitizenService.class, metadata);
    }

}

