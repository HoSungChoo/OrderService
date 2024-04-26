package com.hozzi.order.domain.store.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMenu is a Querydsl query type for Menu
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMenu extends EntityPathBase<Menu> {

    private static final long serialVersionUID = 1786077196L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMenu menu = new QMenu("menu");

    public final DateTimePath<java.time.LocalDateTime> cancelAt = createDateTime("cancelAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> menuId = createNumber("menuId", Long.class);

    public final StringPath menuName = createString("menuName");

    public final NumberPath<Long> menuPrice = createNumber("menuPrice", Long.class);

    public final EnumPath<com.hozzi.order.global.enumerate.State> state = createEnum("state", com.hozzi.order.global.enumerate.State.class);

    public final QStore store;

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public QMenu(String variable) {
        this(Menu.class, forVariable(variable), INITS);
    }

    public QMenu(Path<? extends Menu> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMenu(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMenu(PathMetadata metadata, PathInits inits) {
        this(Menu.class, metadata, inits);
    }

    public QMenu(Class<? extends Menu> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

