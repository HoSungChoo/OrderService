package com.hozzi.order.domain.settlement.repo.custom.impl;

import com.hozzi.order.domain.settlement.dto.ReadSettlementOutDTO;
import com.hozzi.order.domain.settlement.entity.QSettlement;
import com.hozzi.order.domain.settlement.enumerate.SettlementType;
import com.hozzi.order.domain.settlement.repo.custom.CustomSettlementRepo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CustomSettlementRepoImpl implements CustomSettlementRepo {
    @PersistenceContext
    EntityManager em;
    private final JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
    QSettlement qSettlement = QSettlement.settlement;
    @Override
    public Optional<List<ReadSettlementOutDTO>> findAllBetweenDate(LocalDateTime beginDateTime, LocalDateTime endDateTime, SettlementType settlementType) {
        return Optional.of(
                new JPAQuery<>(em)
                        .select(Projections.constructor(ReadSettlementOutDTO.class,
                                qSettlement.settlementId,
                                qSettlement.user.userId,
                                qSettlement.order.orderId,
                                qSettlement.balance,
                                qSettlement.createAt,
                                qSettlement.updateAt))
                        .from(qSettlement)
                        .where(qSettlement.createAt.gt(beginDateTime))
                        .where(qSettlement.createAt.lt(endDateTime))
                        .where(qSettlement.settlementType.eq(settlementType))
                        .fetch()
        );
    }

}
