package com.hozzi.order.domain.settlement.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSettlement is a Querydsl query type for Settlement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSettlement extends EntityPathBase<Settlement> {

    private static final long serialVersionUID = 470070880L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSettlement settlement = new QSettlement("settlement");

    public final NumberPath<Long> balance = createNumber("balance", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final com.hozzi.order.domain.order.entity.QOrder order;

    public final NumberPath<Long> settlementId = createNumber("settlementId", Long.class);

    public final EnumPath<com.hozzi.order.domain.settlement.enumerate.SettlementType> settlementType = createEnum("settlementType", com.hozzi.order.domain.settlement.enumerate.SettlementType.class);

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public final com.hozzi.order.domain.user.entity.QUser user;

    public QSettlement(String variable) {
        this(Settlement.class, forVariable(variable), INITS);
    }

    public QSettlement(Path<? extends Settlement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSettlement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSettlement(PathMetadata metadata, PathInits inits) {
        this(Settlement.class, metadata, inits);
    }

    public QSettlement(Class<? extends Settlement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new com.hozzi.order.domain.order.entity.QOrder(forProperty("order"), inits.get("order")) : null;
        this.user = inits.isInitialized("user") ? new com.hozzi.order.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

