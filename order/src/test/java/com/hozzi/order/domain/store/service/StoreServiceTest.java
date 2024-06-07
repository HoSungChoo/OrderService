package com.hozzi.order.domain.store.service;

import com.hozzi.order.domain.store.mapper.MenuMapper;
import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.store.service.impl.StoreServiceImpl;
import com.hozzi.order.domain.user.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StoreServiceTest {
    StoreService storeService;

    private StoreRepo storeRepo = Mockito.mock(StoreRepo.class);
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    @BeforeEach
    public void SetupTest() {
        storeService = new StoreServiceImpl(storeRepo, userRepo);
    }
    @Test
    void readStore_Normal_Success() {
    }
    @Test
    void readStore() {
    }
    @Test
    void createStore_Normal_Success() {
    }
    @Test
    void createStore() {
    }
    @Test
    void updateStore_Normal_Success() {
    }
    @Test
    void updateStore_NotExistStoreId_Exception() {
    }
    @Test
    void updateStore_NotExistUserId_Exception() {
    }
}