package com.hozzi.order.domain.pay.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = 1951311314L;

    public static final QPayment payment = new QPayment("payment");

    public final DateTimePath<java.time.LocalDateTime> cancelAt = createDateTime("cancelAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final NumberPath<Float> discountRate = createNumber("discountRate", Float.class);

    public final NumberPath<Long> paymentId = createNumber("paymentId", Long.class);

    public final StringPath paymentName = createString("paymentName");

    public final NumberPath<Float> rewardRate = createNumber("rewardRate", Float.class);

    public final EnumPath<com.hozzi.order.global.enumerate.State> state = createEnum("state", com.hozzi.order.global.enumerate.State.class);

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public QPayment(String variable) {
        super(Payment.class, forVariable(variable));
    }

    public QPayment(Path<? extends Payment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPayment(PathMetadata metadata) {
        super(Payment.class, metadata);
    }

}

