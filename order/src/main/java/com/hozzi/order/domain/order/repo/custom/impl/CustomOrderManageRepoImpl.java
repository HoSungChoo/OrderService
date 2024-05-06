package com.hozzi.order.domain.order.repo.custom.impl;

import com.hozzi.order.domain.order.dto.ReadOrderManageOutDTO;
import com.hozzi.order.domain.order.entity.OrderManage;
import com.hozzi.order.domain.order.entity.QOrder;
import com.hozzi.order.domain.order.entity.QOrderManage;
import com.hozzi.order.domain.order.repo.custom.CustomOrderManageRepo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class CustomOrderManageRepoImpl implements CustomOrderManageRepo {
    @PersistenceContext
    EntityManager em;
    private final QOrder qOrder = QOrder.order;
    private final QOrderManage qOrderManage = QOrderManage.orderManage;

    @Override
    public Optional<List<ReadOrderManageOutDTO>> findAllByCustom(Long orderId) {
        return Optional.of(
                new JPAQuery<>(em)
                        .select(Projections.constructor(ReadOrderManageOutDTO.class,
                                qOrderManage.orderManageId,
                                qOrderManage.omType,
                                qOrderManage.order.orderId,
                                qOrderManage.order.wallet.user.userId,
                                qOrderManage.createAt,
                                qOrderManage.updateAt
                                ))
                        .from(qOrderManage)
                        .where(qOrderManage.order.orderId.eq(orderId))
                        .fetch());
    }

    @Override
    public Optional<List<OrderManage>> findAllByOrderId(Long orderId) {
        return Optional.of(
                new JPAQuery<>(em)
                        .select(qOrderManage)
                        .from(qOrderManage)
                        .where(qOrderManage.order.orderId.eq(orderId))
                        .fetch()
        );
    }
}
