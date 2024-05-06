package com.hozzi.order.domain.settlement.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRefund is a Querydsl query type for Refund
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRefund extends EntityPathBase<Refund> {

    private static final long serialVersionUID = 579026991L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRefund refund = new QRefund("refund");

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final com.hozzi.order.domain.user.entity.QUser custom;

    public final NumberPath<Long> customBalance = createNumber("customBalance", Long.class);

    public final com.hozzi.order.domain.user.entity.QUser owner;

    public final NumberPath<Long> ownerBalance = createNumber("ownerBalance", Long.class);

    public final NumberPath<Long> refundId = createNumber("refundId", Long.class);

    public final StringPath refundReason = createString("refundReason");

    public final EnumPath<com.hozzi.order.domain.settlement.enumerate.RefundType> refundType = createEnum("refundType", com.hozzi.order.domain.settlement.enumerate.RefundType.class);

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public QRefund(String variable) {
        this(Refund.class, forVariable(variable), INITS);
    }

    public QRefund(Path<? extends Refund> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRefund(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRefund(PathMetadata metadata, PathInits inits) {
        this(Refund.class, metadata, inits);
    }

    public QRefund(Class<? extends Refund> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.custom = inits.isInitialized("custom") ? new com.hozzi.order.domain.user.entity.QUser(forProperty("custom")) : null;
        this.owner = inits.isInitialized("owner") ? new com.hozzi.order.domain.user.entity.QUser(forProperty("owner")) : null;
    }

}

