package com.hozzi.order.domain.user.service.impl;

import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.user.dto.CreateBasketInDTO;
import com.hozzi.order.domain.user.dto.CreateBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTOs;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.mapper.BasketMapper;
import com.hozzi.order.domain.user.repo.BasketRepo;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.service.BasketService;

import java.util.List;
import java.util.Optional;

public class BasketServiceImpl implements BasketService {
    private final BasketRepo basketRepo;
    private final UserRepo userRepo;
    private final StoreRepo storeRepo;
    private final MenuRepo menuRepo;

    public BasketServiceImpl(BasketRepo basketRepo, UserRepo userRepo, StoreRepo storeRepo, MenuRepo menuRepo) {
        this.basketRepo = basketRepo;
        this.userRepo = userRepo;
        this.storeRepo = storeRepo;
        this.menuRepo = menuRepo;
    }

    @Override
    public ReadBasketOutDTO readBasketByBasketId(Long basketId) throws Exception {
        Basket basket = basketRepo.findById(basketId).orElseThrow(Exception::new);

        return BasketMapper.basketMapper.toReadBasketOutDTO(basket);
    }

    @Override
    public ReadBasketOutDTOs readBasketByUserId(Long userId) throws Exception {
        List<ReadBasketOutDTO> readBasketOutDTOs = basketRepo.findBy(userId).orElseThrow(Exception::new);

        return ReadBasketOutDTOs.builder().baskets(readBasketOutDTOs).build();
    }

    @Override
    public CreateBasketOutDTO createBasket(CreateBasketInDTO createBasketInDTO) throws Exception {
        Basket basket = Basket.builder()
                .amount(createBasketInDTO.getAmount())
                .user(userRepo.findById(createBasketInDTO.getUserId()).orElseThrow(Exception::new))
                .store(storeRepo.findById(createBasketInDTO.getStoreId()).orElseThrow(Exception::new))
                .menu(menuRepo.findById(createBasketInDTO.getMenuId()).orElseThrow(Exception::new))
                .build();

        basketRepo.save(basket);

        return BasketMapper.basketMapper.toCreateBasketOutDTO(basket);
    }

    @Override
    public void deleteBasketByUserId(Long userId) throws Exception {
        basketRepo.deleteByUserId(userId);
    }

    @Override
    public void deleteBasketByBasketId(Long basketId) throws Exception {
        basketRepo.deleteByBasketId(basketId);
    }
}
