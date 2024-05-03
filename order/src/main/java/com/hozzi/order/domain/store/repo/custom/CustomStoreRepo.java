package com.hozzi.order.domain.store.repo.custom;

import com.hozzi.order.domain.store.dto.ReadStoreOutDTO;
import com.hozzi.order.domain.store.dto.ReadStoreOutDTOs;

import java.util.List;
import java.util.Optional;

public interface CustomStoreRepo {
    Optional<List<ReadStoreOutDTO>> findAllByUserIdCustom(Long userId);
}
