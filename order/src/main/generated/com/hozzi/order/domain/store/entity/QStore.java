package com.hozzi.order.domain.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = -460192812L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final DateTimePath<java.time.LocalDateTime> cancelAt = createDateTime("cancelAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final EnumPath<com.hozzi.order.global.enumerate.State> state = createEnum("state", com.hozzi.order.global.enumerate.State.class);

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public final StringPath storeName = createString("storeName");

    public final EnumPath<com.hozzi.order.domain.store.enumerate.StoreType> storeType = createEnum("storeType", com.hozzi.order.domain.store.enumerate.StoreType.class);

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public final com.hozzi.order.domain.user.entity.QUser user;

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.hozzi.order.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

