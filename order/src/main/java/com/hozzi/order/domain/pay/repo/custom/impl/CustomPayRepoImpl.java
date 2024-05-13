package com.hozzi.order.domain.pay.repo.custom.impl;

import com.hozzi.order.domain.pay.dto.ReadPaymentOutDTO;
import com.hozzi.order.domain.pay.entity.QPayment;
import com.hozzi.order.domain.pay.repo.custom.CustomPayRepo;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class CustomPayRepoImpl implements CustomPayRepo {
    @PersistenceContext
    EntityManager em;
    private final QPayment qPayment = QPayment.payment;

    @Override
    public Optional<List<ReadPaymentOutDTO>> findAllCustom() {
        return Optional.of(new JPAQuery<>(em)
                .select(Projections.constructor(ReadPaymentOutDTO.class,
                        qPayment.paymentId,
                        qPayment.paymentName,
                        qPayment.state,
                        qPayment.discountRate,
                        qPayment.rewardRate,
                        qPayment.createAt,
                        qPayment.updateAt,
                        qPayment.cancelAt))
                .from(qPayment)
                .fetch());
    }
}
