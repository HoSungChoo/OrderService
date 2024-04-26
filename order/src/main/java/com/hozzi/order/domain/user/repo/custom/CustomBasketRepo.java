package com.hozzi.order.domain.user.repo.custom;

import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.entity.Basket;

import java.util.List;
import java.util.Optional;

public interface CustomBasketRepo {
    Optional<List<ReadBasketOutDTO>> findBy(Long userId);
    void deleteByUserId(Long userId);
    void deleteByBasketId(Long basketId);
}
