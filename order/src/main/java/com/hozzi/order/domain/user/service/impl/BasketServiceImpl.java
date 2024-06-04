package com.hozzi.order.domain.user.service.impl;

import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.user.dto.CreateBasketInDTO;
import com.hozzi.order.domain.user.dto.CreateBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTOs;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.mapper.BasketMapper;
import com.hozzi.order.domain.user.repo.BasketRepo;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.service.BasketService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepo basketRepo;
    private final UserRepo userRepo;
    private final StoreRepo storeRepo;
    private final MenuRepo menuRepo;
    private final BasketMapper basketMapper;

    public BasketServiceImpl(BasketRepo basketRepo, UserRepo userRepo, StoreRepo storeRepo, MenuRepo menuRepo, BasketMapper basketMapper) {
        this.basketRepo = basketRepo;
        this.userRepo = userRepo;
        this.storeRepo = storeRepo;
        this.menuRepo = menuRepo;
        this.basketMapper = basketMapper;
    }

    @Override
    public ReadBasketOutDTO readBasketByBasketId(Long basketId) throws Exception {
        Basket basket = basketRepo.findById(basketId).orElseThrow(()->new IllegalArgumentException("Not exist basketId"));

        return basketMapper.toReadBasketOutDTOCustom(basket);
    }

    @Override
    public ReadBasketOutDTOs readBasketByUserId(Long userId) throws Exception {
        List<ReadBasketOutDTO> readBasketOutDTOs = basketRepo.findBy(userId).orElseThrow(()->new IllegalArgumentException("Not exist userId"));

        return ReadBasketOutDTOs.builder().baskets(readBasketOutDTOs).build();
    }

    @Override
    public CreateBasketOutDTO createBasket(CreateBasketInDTO createBasketInDTO) throws Exception {
        Basket basket = Basket.builder()
                .amount(createBasketInDTO.getAmount())
                .user(userRepo.findById(createBasketInDTO.getUserId()).orElseThrow(()->new IllegalArgumentException("Not exist userId")))
                .store(storeRepo.findById(createBasketInDTO.getStoreId()).orElseThrow(()->new IllegalArgumentException("Not exist storeId")))
                .menu(menuRepo.findById(createBasketInDTO.getMenuId()).orElseThrow(()->new IllegalArgumentException("Not exist menuId")))
                .build();

        basketRepo.save(basket);

        return basketMapper.toCreateBasketOutDTOCustom(basket);
    }

    @Override
    public void deleteBasketByUserId(Long userId) throws Exception {
        User user = userRepo.findById(userId).orElseThrow(()->new IllegalArgumentException("Not exist userId"));

        basketRepo.deleteByUserId(user.getUserId());
    }

    @Override
    public void deleteBasketByBasketId(Long basketId) throws Exception {
        Basket basket = basketRepo.findById(basketId).orElseThrow(()->new IllegalArgumentException("Not exist basketId"));

        basketRepo.deleteByBasketId(basket.getBasketId());
    }
}
