package com.hozzi.order.domain.order.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 1737989364L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrder order = new QOrder("order1");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final NumberPath<Long> balance = createNumber("balance", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final com.hozzi.order.domain.store.entity.QMenu menu;

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final NumberPath<Long> reward = createNumber("reward", Long.class);

    public final com.hozzi.order.domain.store.entity.QStore store;

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public final com.hozzi.order.domain.user.entity.QWallet wallet;

    public QOrder(String variable) {
        this(Order.class, forVariable(variable), INITS);
    }

    public QOrder(Path<? extends Order> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrder(PathMetadata metadata, PathInits inits) {
        this(Order.class, metadata, inits);
    }

    public QOrder(Class<? extends Order> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.menu = inits.isInitialized("menu") ? new com.hozzi.order.domain.store.entity.QMenu(forProperty("menu"), inits.get("menu")) : null;
        this.store = inits.isInitialized("store") ? new com.hozzi.order.domain.store.entity.QStore(forProperty("store"), inits.get("store")) : null;
        this.wallet = inits.isInitialized("wallet") ? new com.hozzi.order.domain.user.entity.QWallet(forProperty("wallet"), inits.get("wallet")) : null;
    }

}

