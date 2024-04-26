package com.hozzi.order.domain.user.repo.custom;

import com.hozzi.order.domain.user.dto.ReadWalletOutDTO;

import java.util.List;
import java.util.Optional;

public interface CustomWalletRepo {
    Optional<List<ReadWalletOutDTO>> findByUserId(Long userId);
}
