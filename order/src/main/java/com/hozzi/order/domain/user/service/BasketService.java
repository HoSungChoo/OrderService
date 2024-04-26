package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.user.dto.CreateBasketInDTO;
import com.hozzi.order.domain.user.dto.CreateBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTOs;

public interface BasketService {
    ReadBasketOutDTO readBasketByBasketId(Long basketId) throws Exception;
    ReadBasketOutDTOs readBasketByUserId(Long userId) throws Exception;
    CreateBasketOutDTO createBasket(CreateBasketInDTO createBasketInDTO) throws Exception;
    void deleteBasketByUserId(Long userId) throws Exception;
    void deleteBasketByBasketId(Long basketId) throws Exception;
}
