package com.hozzi.order.domain.store.service;

import com.hozzi.order.domain.store.dto.*;
import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.store.enumerate.StoreType;
import com.hozzi.order.domain.store.mapper.MenuMapper;
import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.store.service.impl.MenuServiceImpl;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.global.enumerate.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

class MenuServiceTest {
    MenuService menuService;
    private MenuRepo menuRepo = Mockito.mock(MenuRepo.class);
    private StoreRepo storeRepo = Mockito.mock(StoreRepo.class);
    private MenuMapper menuMapper = Mockito.mock(MenuMapper.class);

    @BeforeEach
    public void SetupTest() {
        menuService = new MenuServiceImpl(menuRepo, storeRepo, menuMapper);
    }

    @Test
    @DisplayName("readMenu_Normal_Success")
    void readMenu_Normal_Success() {
        Long storeId = 100L;
        List<ReadMenuOutDTO> readMenuOutDTOS = new ArrayList<>();
        LocalDateTime time = LocalDateTime.now();

        readMenuOutDTOS.add(ReadMenuOutDTO.builder()
                .menuId(100L)
                .menuName("menuName")
                .menuPrice(10000L)
                .state(State.ENROLL)
                .createAt(time)
                .updateAt(time)
                .cancelAt(time)
                .build());

        Mockito.when(menuRepo.findByStoreIdCustom(storeId))
                .thenReturn(Optional.of(readMenuOutDTOS));

        ReadMenuOutDTOs readMenuOutDTOs = menuService.readMenu(storeId);

        Assertions.assertEquals(readMenuOutDTOs.getMenu().get(0).getMenuId(), 100L);
        Assertions.assertEquals(readMenuOutDTOs.getMenu().get(0).getMenuName(), "menuName");
        Assertions.assertEquals(readMenuOutDTOs.getMenu().get(0).getMenuPrice(), 10000L);
        Assertions.assertEquals(readMenuOutDTOs.getMenu().get(0).getState(), State.ENROLL);
        Assertions.assertEquals(readMenuOutDTOs.getMenu().get(0).getCreateAt(), time);
        Assertions.assertEquals(readMenuOutDTOs.getMenu().get(0).getUpdateAt(), time);
        Assertions.assertEquals(readMenuOutDTOs.getMenu().get(0).getCancelAt(), time);
    }

    @Test
    @DisplayName("readMenu_NotExistStoreId_Exception")
    void readMenu_NotExistStoreId_Exception() {
        Long storeId = 100L;
        Mockito.when(menuRepo.findByStoreIdCustom(storeId))
                .thenThrow(new IllegalArgumentException("Not exist storeId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> menuService.readMenu(storeId));
    }

    @Test
    @DisplayName("createMenu_Normal_Success")
    void createMenu_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();

        CreateMenuInDTO createMenuInDTO = CreateMenuInDTO.builder()
                .menuName("menuName")
                .storeId(100L)
                .menuPrice(10000L)
                .state(State.ENROLL)
                .build();

        User user = User.builder()
                .userId(100L)
                .userName("hozzi")
                .userType(UserType.USER)
                .age(20)
                .point(100L)
                .balance(100L)
                .gender(Gender.Male)
                .createAt(time)
                .updateAt(time)
                .build();

        Store store = Store.builder()
                .storeId(100L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
                .state(State.ENROLL)
                .createAt(time)
                .updateAt(time)
                .cancelAt(time)
                .user(user)
                .build();

        Mockito.when(storeRepo.findById(createMenuInDTO.getStoreId()))
                .thenReturn(Optional.ofNullable(store));

        Mockito.when(menuMapper.toCreateMenuOutDTO(any(Menu.class)))
                .thenReturn(CreateMenuOutDTO.builder()
                        .menuId(100L)
                        .menuName("menuName")
                        .storeId(100L)
                        .menuPrice(10000L)
                        .state(State.ENROLL)
                        .createAt(time)
                        .updateAt(time)
                        .cancelAt(time)
                        .build());

        CreateMenuOutDTO createMenuOutDTO = menuService.createMenu(createMenuInDTO);

        Assertions.assertEquals(createMenuOutDTO.getMenuId(), 100L);
        Assertions.assertEquals(createMenuOutDTO.getMenuName(), "menuName");
        Assertions.assertEquals(createMenuOutDTO.getStoreId(), 100L);
        Assertions.assertEquals(createMenuOutDTO.getMenuPrice(), 10000L);
        Assertions.assertEquals(createMenuOutDTO.getState(), State.ENROLL);
        Assertions.assertEquals(createMenuOutDTO.getCreateAt(), time);
        Assertions.assertEquals(createMenuOutDTO.getUpdateAt(), time);
        Assertions.assertEquals(createMenuOutDTO.getCancelAt(), time);
    }

    @Test
    @DisplayName("createMenu_NotExistStoreId_Exception")
    void createMenu_NotExistStoreId_Exception() {
        CreateMenuInDTO createMenuInDTO = CreateMenuInDTO.builder()
                .menuName("menuName")
                .storeId(100L)
                .menuPrice(10000L)
                .state(State.ENROLL)
                .build();

        Mockito.when(storeRepo.findById(createMenuInDTO.getStoreId()))
                .thenThrow(new IllegalArgumentException("Not exist storeId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> menuService.createMenu(createMenuInDTO));
    }

    @Test
    @DisplayName("updateMenu_Normal_Success")
    void updateMenu_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();

        User user = User.builder()
                .userId(100L)
                .userName("hozzi")
                .userType(UserType.USER)
                .age(20)
                .point(100L)
                .balance(100L)
                .gender(Gender.Male)
                .createAt(time)
                .updateAt(time)
                .build();

        Store store = Store.builder()
                .storeId(100L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
                .state(State.ENROLL)
                .createAt(time)
                .updateAt(time)
                .cancelAt(time)
                .user(user)
                .build();

        Store store2 = Store.builder()
                .storeId(200L)
                .storeName("storeName")
                .storeType(StoreType.JAPANESE)
                .state(State.ENROLL)
                .createAt(time)
                .updateAt(time)
                .cancelAt(time)
                .user(user)
                .build();

        UpdateMenuInDTO updateMenuInDTO = UpdateMenuInDTO.builder()
                .menuId(100L)
                .menuName("menuNameUpdate")
                .storeId(200L)
                .menuPrice(10000L)
                .state(State.CANCEL)
                .build();

        Mockito.when(menuRepo.findById(updateMenuInDTO.getMenuId()))
                .thenReturn(Optional.ofNullable(Menu.builder()
                        .menuId(100L)
                        .menuName("menuName")
                        .menuPrice(10000L)
                        .state(State.ENROLL)
                        .store(store)
                        .createAt(time)
                        .updateAt(time)
                        .cancelAt(time)
                        .build()));

        Mockito.when(storeRepo.findById(updateMenuInDTO.getStoreId()))
                .thenReturn(Optional.ofNullable(store2));

        Mockito.when(menuMapper.toUpdateMenuOutDTO(any(Menu.class)))
                .thenReturn(UpdateMenuOutDTO.builder()
                        .menuId(100L)
                        .menuName("menuName")
                        .storeId(200L)
                        .menuPrice(10000L)
                        .state(State.CANCEL)
                        .createAt(time)
                        .updateAt(time)
                        .cancelAt(time)
                        .build());

        UpdateMenuOutDTO updateMenuOutDTO = menuService.updateMenu(updateMenuInDTO);

        Assertions.assertEquals(updateMenuOutDTO.getMenuId(), 100L);
        Assertions.assertEquals(updateMenuOutDTO.getMenuName(), "menuName");
        Assertions.assertEquals(updateMenuOutDTO.getStoreId(), 200L);
        Assertions.assertEquals(updateMenuOutDTO.getMenuPrice(), 10000L);
        Assertions.assertEquals(updateMenuOutDTO.getState(), State.CANCEL);
        Assertions.assertEquals(updateMenuOutDTO.getCreateAt(), time);
        Assertions.assertEquals(updateMenuOutDTO.getUpdateAt(), time);
        Assertions.assertEquals(updateMenuOutDTO.getCancelAt(), time);
    }

    @Test
    @DisplayName("updateMenu_NotExistMenuId_Exception")
    void updateMenu_NotExistMenuId_Exception() {
        UpdateMenuInDTO updateMenuInDTO = UpdateMenuInDTO.builder()
                .menuId(100L)
                .menuName("menuNameUpdate")
                .storeId(200L)
                .menuPrice(10000L)
                .state(State.CANCEL)
                .build();

        Mockito.when(menuRepo.findById(updateMenuInDTO.getMenuId()))
                .thenThrow(new IllegalArgumentException("Not exist MenuId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> menuService.updateMenu(updateMenuInDTO));
    }

    @Test
    @DisplayName("updateMenu_NotExistStoreId_Exception")
    void updateMenu_NotExistStoreId_Exception() {
        UpdateMenuInDTO updateMenuInDTO = UpdateMenuInDTO.builder()
                .menuId(100L)
                .menuName("menuNameUpdate")
                .storeId(200L)
                .menuPrice(10000L)
                .state(State.CANCEL)
                .build();

        Mockito.when(storeRepo.findById(updateMenuInDTO.getStoreId()))
                .thenThrow(new IllegalArgumentException("Not exist StoreId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> menuService.updateMenu(updateMenuInDTO));
    }
}