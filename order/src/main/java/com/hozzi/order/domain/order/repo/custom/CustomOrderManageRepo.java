package com.hozzi.order.domain.order.repo.custom;

import com.hozzi.order.domain.order.dto.ReadOrderManageOutDTO;

import java.util.List;
import java.util.Optional;

public interface CustomOrderManageRepo {
    Optional<List<ReadOrderManageOutDTO>> findAllByCustom(Long orderId);
}
