package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramPage is a Querydsl query type for ProgramPage
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramPage extends EntityPathBase<ProgramPage> {

    private static final long serialVersionUID = -1974146153L;

    public static final QProgramPage programPage = new QProgramPage("programPage");

    public final StringPath pageCode = createString("pageCode");

    public final StringPath pageName = createString("pageName");

    public final ListPath<ProgramPagesAdDiv, QProgramPagesAdDiv> programPagesAdDivs = this.<ProgramPagesAdDiv, QProgramPagesAdDiv>createList("programPagesAdDivs", ProgramPagesAdDiv.class, QProgramPagesAdDiv.class, PathInits.DIRECT2);

    public QProgramPage(String variable) {
        super(ProgramPage.class, forVariable(variable));
    }

    public QProgramPage(Path<? extends ProgramPage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProgramPage(PathMetadata<?> metadata) {
        super(ProgramPage.class, metadata);
    }

}

