package com.hozzi.order.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBasket is a Querydsl query type for Basket
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBasket extends EntityPathBase<Basket> {

    private static final long serialVersionUID = 1377137247L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBasket basket = new QBasket("basket");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final NumberPath<Long> basketId = createNumber("basketId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final com.hozzi.order.domain.store.entity.QMenu menu;

    public final com.hozzi.order.domain.store.entity.QStore store;

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public final QUser user;

    public QBasket(String variable) {
        this(Basket.class, forVariable(variable), INITS);
    }

    public QBasket(Path<? extends Basket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBasket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBasket(PathMetadata metadata, PathInits inits) {
        this(Basket.class, metadata, inits);
    }

    public QBasket(Class<? extends Basket> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.menu = inits.isInitialized("menu") ? new com.hozzi.order.domain.store.entity.QMenu(forProperty("menu"), inits.get("menu")) : null;
        this.store = inits.isInitialized("store") ? new com.hozzi.order.domain.store.entity.QStore(forProperty("store"), inits.get("store")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

