package com.hozzi.order.domain.store.service;

import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.store.service.impl.MenuServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MenuServiceTest {
    MenuService menuService;
    private MenuRepo menuRepo = Mockito.mock(MenuRepo.class);
    private StoreRepo storeRepo = Mockito.mock(StoreRepo.class);
    @BeforeEach
    public void SetupTest(){
        menuService = new MenuServiceImpl(menuRepo, storeRepo);
    }
    @Test
    @DisplayName("")
    void readMenu_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void readMenu_NotExistStoreId_Exception() {
    }
    @Test
    @DisplayName("")
    void createMenu_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void createMenu_NotExistStoreId_Exception() {
    }
    @Test
    @DisplayName("")
    void updateMenu_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void updateMenu_NotExistMenuId_Exception() {
    }
    @Test
    @DisplayName("")
    void updateMenu_NotExistStoreId_Exception() {
    }
}