package com.hozzi.order.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWallet is a Querydsl query type for Wallet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWallet extends EntityPathBase<Wallet> {

    private static final long serialVersionUID = 1978141842L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWallet wallet = new QWallet("wallet");

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final com.hozzi.order.domain.pay.entity.QPayment payment;

    public final EnumPath<com.hozzi.order.global.enumerate.State> state = createEnum("state", com.hozzi.order.global.enumerate.State.class);

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public final QUser user;

    public final NumberPath<Long> walletId = createNumber("walletId", Long.class);

    public QWallet(String variable) {
        this(Wallet.class, forVariable(variable), INITS);
    }

    public QWallet(Path<? extends Wallet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWallet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWallet(PathMetadata metadata, PathInits inits) {
        this(Wallet.class, metadata, inits);
    }

    public QWallet(Class<? extends Wallet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.payment = inits.isInitialized("payment") ? new com.hozzi.order.domain.pay.entity.QPayment(forProperty("payment")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

