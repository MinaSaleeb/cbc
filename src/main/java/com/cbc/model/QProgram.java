package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QProgram is a Querydsl query type for Program
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgram extends EntityPathBase<Program> {

    private static final long serialVersionUID = 160286952L;

    public static final QProgram program = new QProgram("program");

    public final ListPath<Channel, QChannel> channels = this.<Channel, QChannel>createList("channels", Channel.class, QChannel.class, PathInits.DIRECT2);

    public final StringPath circleImagePath = createString("circleImagePath");

    public final StringPath description = createString("description");

    public final StringPath halfCircleImagePath = createString("halfCircleImagePath");

    public final BooleanPath hideProgram = createBoolean("hideProgram");

    public final BooleanPath hubSelected = createBoolean("hubSelected");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath image1xPath = createString("image1xPath");

    public final StringPath image2xPath = createString("image2xPath");

    public final StringPath imageBgPath = createString("imageBgPath");

    public final StringPath imageXPath = createString("imageXPath");

    public final BooleanPath onAir = createBoolean("onAir");

    public final NumberPath<Integer> orderingFactor = createNumber("orderingFactor", Integer.class);

    public final ListPath<Presenter, QPresenter> presenters = this.<Presenter, QPresenter>createList("presenters", Presenter.class, QPresenter.class, PathInits.DIRECT2);

    public final ListPath<ProgramsAdDiv, QProgramsAdDiv> programsAdDivs = this.<ProgramsAdDiv, QProgramsAdDiv>createList("programsAdDivs", ProgramsAdDiv.class, QProgramsAdDiv.class, PathInits.DIRECT2);

    public final StringPath recipeRatingImagePath = createString("recipeRatingImagePath");

    public final StringPath schedule = createString("schedule");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final ListPath<Widget, QWidget> widgets = this.<Widget, QWidget>createList("widgets", Widget.class, QWidget.class, PathInits.DIRECT2);

    public QProgram(String variable) {
        super(Program.class, forVariable(variable));
    }

    public QProgram(Path<? extends Program> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProgram(PathMetadata<?> metadata) {
        super(Program.class, metadata);
    }

}

