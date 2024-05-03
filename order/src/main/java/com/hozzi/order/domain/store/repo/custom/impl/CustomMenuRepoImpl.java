package com.hozzi.order.domain.store.repo.custom.impl;

import com.hozzi.order.domain.store.dto.ReadMenuOutDTO;
import com.hozzi.order.domain.store.entity.QMenu;
import com.hozzi.order.domain.store.repo.custom.CustomMenuRepo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class CustomMenuRepoImpl implements CustomMenuRepo {
    @PersistenceContext
    EntityManager em;
    private final JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
    private final QMenu qMenu = QMenu.menu;
    @Override
    public Optional<List<ReadMenuOutDTO>> findByStoreIdCustom(Long storeId) {
        return Optional.of(new JPAQuery<>(em)
                .select(Projections.constructor(ReadMenuOutDTO.class,
                        qMenu.menuId,
                        qMenu.menuName,
                        qMenu.menuPrice,
                        qMenu.state,
                        qMenu.createAt,
                        qMenu.updateAt,
                        qMenu.cancelAt))
                .from(qMenu)
                .where(qMenu.store.storeId.eq(storeId))
                .fetch());
    }
}
