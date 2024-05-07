package com.hozzi.order.domain.user.repo.custom.impl;

import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.entity.QBasket;
import com.hozzi.order.domain.user.repo.custom.CustomBasketRepo;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class CustomBasketRepoImpl implements CustomBasketRepo {
    @PersistenceContext
    EntityManager em;
    private final JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
    private final QBasket qBasket = QBasket.basket;
    @Override
    public Optional<List<ReadBasketOutDTO>> findBy(Long userId) {
        return Optional.of(new JPAQuery<>(em)
                .select(Projections.constructor(ReadBasketOutDTO.class,
                        qBasket.basketId,
                        qBasket.user.userId,
                        qBasket.store.storeId,
                        qBasket.menu.menuId,
                        qBasket.amount,
                        qBasket.createAt,
                        qBasket.updateAt))
                .from(qBasket)
                .where(qBasket.user.userId.eq(userId))
                .fetch());
    }

    @Override
    public void deleteByUserId(Long userId) {
        jpaQueryFactory.delete(qBasket)
                .where(qBasket.user.userId.eq(userId))
                .execute();
    }

    @Override
    public void deleteByBasketId(Long basketId) {
        jpaQueryFactory.delete(qBasket)
                .where(qBasket.basketId.eq(basketId))
                .execute();
    }

    @Override
    public Optional<List<Basket>> findByUserId(Long userId) {
        return Optional.of(new JPAQuery<>(em)
                .select(qBasket)
                .from(qBasket)
                .where(qBasket.user.userId.eq(userId))
                .fetch());
    }
}
