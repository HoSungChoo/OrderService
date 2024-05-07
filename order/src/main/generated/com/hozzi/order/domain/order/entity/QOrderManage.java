package com.hozzi.order.domain.order.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderManage is a Querydsl query type for OrderManage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderManage extends EntityPathBase<OrderManage> {

    private static final long serialVersionUID = 1523752825L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderManage orderManage = new QOrderManage("orderManage");

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final EnumPath<com.hozzi.order.domain.order.enumerate.OmType> omType = createEnum("omType", com.hozzi.order.domain.order.enumerate.OmType.class);

    public final QOrder order;

    public final NumberPath<Long> orderManageId = createNumber("orderManageId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public final com.hozzi.order.domain.user.entity.QUser user;

    public QOrderManage(String variable) {
        this(OrderManage.class, forVariable(variable), INITS);
    }

    public QOrderManage(Path<? extends OrderManage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderManage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderManage(PathMetadata metadata, PathInits inits) {
        this(OrderManage.class, metadata, inits);
    }

    public QOrderManage(Class<? extends OrderManage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new QOrder(forProperty("order"), inits.get("order")) : null;
        this.user = inits.isInitialized("user") ? new com.hozzi.order.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

