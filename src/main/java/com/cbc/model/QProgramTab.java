package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgramTab is a Querydsl query type for ProgramTab
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramTab extends EntityPathBase<ProgramTab> {

    private static final long serialVersionUID = -894962291L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProgramTab programTab = new QProgramTab("programTab");

    public final ListPath<ProgramTab, QProgramTab> childTabs = this.<ProgramTab, QProgramTab>createList("childTabs", ProgramTab.class, QProgramTab.class, PathInits.DIRECT2);

    public final StringPath contentType = createString("contentType");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final QProgramTab parentTab;

    public final QProgram programBean;

    public final ListPath<ProgramTabContent, QProgramTabContent> programTabContents = this.<ProgramTabContent, QProgramTabContent>createList("programTabContents", ProgramTabContent.class, QProgramTabContent.class, PathInits.DIRECT2);

    public QProgramTab(String variable) {
        this(ProgramTab.class, forVariable(variable), INITS);
    }

    public QProgramTab(Path<? extends ProgramTab> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramTab(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProgramTab(PathMetadata<?> metadata, PathInits inits) {
        this(ProgramTab.class, metadata, inits);
    }

    public QProgramTab(Class<? extends ProgramTab> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentTab = inits.isInitialized("parentTab") ? new QProgramTab(forProperty("parentTab"), inits.get("parentTab")) : null;
        this.programBean = inits.isInitialized("programBean") ? new QProgram(forProperty("programBean")) : null;
    }

}

