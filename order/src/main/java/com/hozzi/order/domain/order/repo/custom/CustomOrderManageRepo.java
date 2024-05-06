package com.hozzi.order.domain.order.repo.custom;

import com.hozzi.order.domain.order.dto.ReadOrderManageOutDTO;
import com.hozzi.order.domain.order.entity.OrderManage;

import java.util.List;
import java.util.Optional;

public interface CustomOrderManageRepo {
    Optional<List<ReadOrderManageOutDTO>> findAllByCustom(Long orderId);
    Optional<List<OrderManage>> findAllByOrderId(Long orderId);
}
