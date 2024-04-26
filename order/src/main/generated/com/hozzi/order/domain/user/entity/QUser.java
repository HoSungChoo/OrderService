package com.hozzi.order.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1432619356L;

    public static final QUser user = new QUser("user");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> balance = createNumber("balance", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createAt = createDateTime("createAt", java.time.LocalDateTime.class);

    public final EnumPath<com.hozzi.order.domain.user.enumerate.Gender> gender = createEnum("gender", com.hozzi.order.domain.user.enumerate.Gender.class);

    public final NumberPath<Long> point = createNumber("point", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateAt = createDateTime("updateAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userName = createString("userName");

    public final EnumPath<com.hozzi.order.domain.user.enumerate.UserType> userType = createEnum("userType", com.hozzi.order.domain.user.enumerate.UserType.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

