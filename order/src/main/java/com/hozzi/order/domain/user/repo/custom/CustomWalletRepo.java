package com.hozzi.order.domain.user.repo.custom;

import com.hozzi.order.domain.user.dto.DeleteWalletInDTO;
import com.hozzi.order.domain.user.dto.ReadWalletOutDTO;
import com.hozzi.order.domain.user.entity.Wallet;

import java.util.List;
import java.util.Optional;

public interface CustomWalletRepo {
    Optional<List<ReadWalletOutDTO>> findByUserId(Long userId);
    Optional<Wallet> findBy(DeleteWalletInDTO deleteWalletInDTO);
}
