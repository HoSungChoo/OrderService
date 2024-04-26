package com.hozzi.order.domain.user.repo.custom.impl;

import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.entity.QBasket;
import com.hozzi.order.domain.user.repo.custom.CustomBasketRepo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class CustomBasketRepoImpl implements CustomBasketRepo {
    @PersistenceContext
    EntityManager em;
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
}
