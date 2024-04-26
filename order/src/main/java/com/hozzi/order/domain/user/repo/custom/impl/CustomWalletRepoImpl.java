package com.hozzi.order.domain.user.repo.custom.impl;

import com.hozzi.order.domain.user.dto.DeleteWalletInDTO;
import com.hozzi.order.domain.user.dto.ReadWalletOutDTO;
import com.hozzi.order.domain.user.entity.QWallet;
import com.hozzi.order.domain.user.entity.Wallet;
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
        return Optional.of(
                new JPAQuery<>(em)
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

    @Override
    public Optional<Wallet> findBy(DeleteWalletInDTO deleteWalletInDTO) {
        return Optional.of(
                new JPAQuery<>(em)
                        .select(Projections.constructor(Wallet.class,
                                qWallet.walletId,
                                qWallet.state,
                                qWallet.createAt,
                                qWallet.updateAt,
                                qWallet.user,
                                qWallet.payment))
                        .from(qWallet)
                        .where(qWallet.user.userId.eq(deleteWalletInDTO.getUserId()))
                        .where(qWallet.payment.paymentId.eq(deleteWalletInDTO.getPaymentId()))
                        .fetchFirst()
        );
    }
}
