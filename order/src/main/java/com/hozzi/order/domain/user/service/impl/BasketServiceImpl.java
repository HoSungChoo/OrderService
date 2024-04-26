package com.hozzi.order.domain.user.service.impl;

import com.hozzi.order.domain.user.dto.CreateBasketInDTO;
import com.hozzi.order.domain.user.dto.CreateBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTOs;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.mapper.BasketMapper;
import com.hozzi.order.domain.user.repo.BasketRepo;
import com.hozzi.order.domain.user.service.BasketService;

public class BasketServiceImpl implements BasketService {
    private final BasketRepo basketRepo;

    public BasketServiceImpl(BasketRepo basketRepo) {
        this.basketRepo = basketRepo;
    }

    @Override
    public ReadBasketOutDTO readBasketByBasketId(Long basketId) throws Exception {
        Basket basket = basketRepo.findById(basketId).orElseThrow(Exception::new);

        return BasketMapper.basketMapper.toReadBasketOutDTO(basket);
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
