package com.hozzi.order.domain.store.repo.custom.impl;

import com.hozzi.order.domain.store.dto.ReadStoreOutDTO;
import com.hozzi.order.domain.store.dto.ReadStoreOutDTOs;
import com.hozzi.order.domain.store.entity.QStore;
import com.hozzi.order.domain.store.repo.custom.CustomStoreRepo;
import com.hozzi.order.domain.user.entity.QBasket;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class CustomStoreRepoImpl implements CustomStoreRepo {
    @PersistenceContext
    EntityManager em;
    private final JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
    private final QStore qStore = QStore.store;
    @Override
    public Optional<List<ReadStoreOutDTO>> findAllByUserIdCustom(Long userId) {
        return Optional.of(new JPAQuery<>(em)
                .select(Projections.constructor(ReadStoreOutDTO.class,
                        qStore.storeId,
                        qStore.storeName,
                        qStore.storeType,
                        qStore.state,
                        qStore.createAt,
                        qStore.updateAt,
                        qStore.cancelAt))
                .from(qStore)
                .where(qStore.user.userId.eq(userId))
                .fetch());
    }
}
