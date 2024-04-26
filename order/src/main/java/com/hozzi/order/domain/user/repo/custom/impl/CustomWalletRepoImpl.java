package com.hozzi.order.domain.user.repo.custom.impl;

import com.hozzi.order.domain.user.dto.ReadWalletOutDTO;
import com.hozzi.order.domain.user.entity.QWallet;
import com.hozzi.order.domain.user.repo.custom.CustomWalletRepo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class CustomWalletRepoImpl implements CustomWalletRepo {
    @PersistenceContext
    EntityManager em;
    private final QWallet qWallet = QWallet.wallet;

    @Override
    public Optional<List<ReadWalletOutDTO>> findByUserId(Long userId) {
        return Optional.of(new JPAQuery<>(em)
                .select(Projections.constructor(ReadWalletOutDTO.class,
                        qWallet.walletId,
                        qWallet.state,
                        qWallet.payment.paymentId,
                        qWallet.payment.paymentName,
                        qWallet.createAt,
                        qWallet.updateAt))
                .from(qWallet)
                .where(qWallet.user.userId.eq(userId))
                .fetch());
    }
}
