package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.user.repo.BasketRepo;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.service.impl.BasketServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BasketServiceTest {
    BasketService basketService;
    private BasketRepo basketRepo = Mockito.mock(BasketRepo.class);
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private StoreRepo storeRepo = Mockito.mock(StoreRepo.class);
    private MenuRepo menuRepo = Mockito.mock(MenuRepo.class);

    @BeforeEach
    public void setUpTest() {
        basketService = new BasketServiceImpl(basketRepo, userRepo, storeRepo, menuRepo);
    }

    @Test
    @DisplayName("readBasketByBasketId_Normal_Success")
    void readBasketByBasketId_Normal_Success() throws Exception {
    }
    @Test
    @DisplayName("readBasketByBasketId_NotExistBasketId_Exception")
    void readBasketByBasketId_NotExistBasketId_Exception() throws Exception {
    }

    @Test
    @DisplayName("readBasketByUserId_Normal_Success")
    void readBasketByUserId_Normal_Success() {
    }
    @Test
    @DisplayName("readBasketByUserId_NotExistUserId_Exception")
    void readBasketByUserId_NotExistUserId_Exception() {
    }
    @Test
    @DisplayName("createBasket_Normal_Success")
    void createBasket_Normal_Success() {
    }
    @Test
    @DisplayName("createBasket_NotExistUserId_Exception")
    void createBasket_NotExistUserId_Exception() {
    }
    @Test
    @DisplayName("createBasket_NotExistStoreId_Exception")
    void createBasket_NotExistStoreId_Exception() {
    }
    @Test
    @DisplayName("createBasket_NotExistMenuId_Exception")
    void createBasket_NotExistMenuId_Exception() {
    }
    @Test
    @DisplayName("deleteBasketByUserId_Normal_Success")
    void deleteBasketByUserId_Normal_Success() {
    }
    @Test
    @DisplayName("deleteBasketByUserId_NotExistUserId_Exception")
    void deleteBasketByUserId_NotExistUserId_Exception() {
    }
    @Test
    @DisplayName("deleteBasketByBasketId_Normal_Success")
    void deleteBasketByBasketId_Normal_Success() {
    }
    @Test
    @DisplayName("deleteBasketByBasketId_NotExistBasketId_Exception")
    void deleteBasketByBasketId_NotExistBasketId_Exception() {
    }
}