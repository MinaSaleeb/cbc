package com.cbc.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QChannel is a Querydsl query type for Channel
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QChannel extends EntityPathBase<Channel> {

    private static final long serialVersionUID = 1208624999L;

    public static final QChannel channel = new QChannel("channel");

    public final StringPath channelBgImage = createString("channelBgImage");

    public final StringPath channelImage = createString("channelImage");

    public final StringPath channelName = createString("channelName");

    public final ListPath<ChannelsAdDiv, QChannelsAdDiv> channelsAdDivs = this.<ChannelsAdDiv, QChannelsAdDiv>createList("channelsAdDivs", ChannelsAdDiv.class, QChannelsAdDiv.class, PathInits.DIRECT2);

    public final StringPath hubCarouelImage = createString("hubCarouelImage");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath liveStreamingUrl = createString("liveStreamingUrl");

    public final ListPath<Program, QProgram> programs = this.<Program, QProgram>createList("programs", Program.class, QProgram.class, PathInits.DIRECT2);

    public final StringPath promoUrl = createString("promoUrl");

    public QChannel(String variable) {
        super(Channel.class, forVariable(variable));
    }

    public QChannel(Path<? extends Channel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChannel(PathMetadata<?> metadata) {
        super(Channel.class, metadata);
    }

}

