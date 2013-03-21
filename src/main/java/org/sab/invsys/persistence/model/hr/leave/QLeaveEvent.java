package org.sab.invsys.persistence.model.hr.leave;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QLeaveEvent is a Querydsl query type for LeaveEvent
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QLeaveEvent extends EntityPathBase<LeaveEvent> {

    private static final long serialVersionUID = -267491364;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QLeaveEvent leaveEvent = new QLeaveEvent("leaveEvent");

    public final DateTimePath<java.util.Date> fromDate = createDateTime("fromDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> toDate = createDateTime("toDate", java.util.Date.class);

    public final org.sab.invsys.persistence.model.user.QUser user;

    public QLeaveEvent(String variable) {
        this(LeaveEvent.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QLeaveEvent(Path<? extends LeaveEvent> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLeaveEvent(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLeaveEvent(PathMetadata<?> metadata, PathInits inits) {
        this(LeaveEvent.class, metadata, inits);
    }

    public QLeaveEvent(Class<? extends LeaveEvent> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new org.sab.invsys.persistence.model.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

