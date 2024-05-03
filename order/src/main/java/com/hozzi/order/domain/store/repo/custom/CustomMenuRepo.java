package com.hozzi.order.domain.store.repo.custom;

import com.hozzi.order.domain.store.dto.ReadMenuOutDTO;

import java.util.List;
import java.util.Optional;

public interface CustomMenuRepo {
    Optional<List<ReadMenuOutDTO>> findByStoreIdCustom(Long storeId);
}
