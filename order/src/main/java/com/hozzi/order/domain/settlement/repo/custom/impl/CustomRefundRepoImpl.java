package com.hozzi.order.domain.settlement.repo.custom.impl;

import com.hozzi.order.domain.settlement.dto.ReadRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.ReadSettlementOutDTO;
import com.hozzi.order.domain.settlement.entity.QRefund;
import com.hozzi.order.domain.settlement.entity.QSettlement;
import com.hozzi.order.domain.settlement.enumerate.SettlementType;
import com.hozzi.order.domain.settlement.repo.custom.CustomRefundRepo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CustomRefundRepoImpl implements CustomRefundRepo {
    @PersistenceContext
    EntityManager em;
    private final JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
    QRefund qRefund = QRefund.refund;
    @Override
    public Optional<List<ReadRefundOutDTO>> findAllBetweenDate(LocalDateTime beginDateTime, LocalDateTime endDateTime) {
        return Optional.of(
                new JPAQuery<>(em)
                        .select(Projections.constructor(ReadRefundOutDTO.class,
                                qRefund.refundId,
                                qRefund.customBalance,
                                qRefund.ownerBalance,
                                qRefund.refundType,
                                qRefund.refundReason,
                                qRefund.custom.userId,
                                qRefund.owner.userId,
                                qRefund.order.orderId,
                                qRefund.createAt,
                                qRefund.updateAt))
                        .from(qRefund)
                        .where(qRefund.createAt.gt(beginDateTime))
                        .where(qRefund.createAt.lt(endDateTime))
                        .fetch()
        );
    }
}
