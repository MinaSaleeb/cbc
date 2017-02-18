package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCurrency is a Querydsl query type for Currency
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCurrency extends EntityPathBase<Currency> {

    private static final long serialVersionUID = -2044554707L;

    public static final QCurrency currency = new QCurrency("currency");

    public final StringPath currencyCode = createString("currencyCode");

    public final StringPath currencyName = createString("currencyName");

    public final NumberPath<Double> exchangeRate = createNumber("exchangeRate", Double.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QCurrency(String variable) {
        super(Currency.class, forVariable(variable));
    }

    public QCurrency(Path<? extends Currency> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCurrency(PathMetadata<?> metadata) {
        super(Currency.class, metadata);
    }

}

