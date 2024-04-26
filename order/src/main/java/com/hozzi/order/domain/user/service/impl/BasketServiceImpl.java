package com.hozzi.order.domain.user.service.impl;

import com.hozzi.order.domain.user.dto.CreateBasketInDTO;
import com.hozzi.order.domain.user.dto.CreateBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTOs;
import com.hozzi.order.domain.user.service.BasketService;

public class BasketServiceImpl implements BasketService {
    @Override
    public ReadBasketOutDTO readBasketByBasketId(Long basketId) throws Exception {
        return null;
    }

    @Override
    public ReadBasketOutDTOs readBasketByUserId(Long userId) throws Exception {
        return null;
    }

    @Override
    public CreateBasketOutDTO createBasket(CreateBasketInDTO createBasketInDTO) throws Exception {
        return null;
    }

    @Override
    public void deleteBasketByUserId(Long userId) throws Exception {

    }

    @Override
    public void deleteBasketByBasketId(Long basketId) throws Exception {

    }
}
