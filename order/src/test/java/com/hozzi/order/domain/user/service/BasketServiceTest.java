package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.store.enumerate.StoreType;
import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.mapper.BasketMapper;
import com.hozzi.order.domain.user.repo.BasketRepo;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.service.impl.BasketServiceImpl;
import com.hozzi.order.global.enumerate.State;
import jakarta.persistence.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class BasketServiceTest {
    BasketService basketService;
    private BasketRepo basketRepo = Mockito.mock(BasketRepo.class);
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private StoreRepo storeRepo = Mockito.mock(StoreRepo.class);
    private MenuRepo menuRepo = Mockito.mock(MenuRepo.class);
    private BasketMapper basketMapper = Mockito.mock(BasketMapper.class);

    @BeforeEach
    public void setUpTest() {
        basketService = new BasketServiceImpl(basketRepo, userRepo, storeRepo, menuRepo, basketMapper);
    }

    @Test
    @DisplayName("readBasketByBasketId_Normal_Success")
    void readBasketByBasketId_Normal_Success() throws Exception {
        // given
        Long basketId = 100L;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        User user = User.builder()
                .userId(100L)
                .userName("hozzi")
                .userType(UserType.USER)
                .age(20)
                .point(100L)
                .balance(100L)
                .gender(Gender.Male)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();

        User owner = User.builder()
                .userId(200L)
                .userName("owner")
                .userType(UserType.OWNER)
                .age(20)
                .point(200L)
                .balance(200L)
                .gender(Gender.Male)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();

        Store store = Store.builder()
                .storeId(300L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
                .state(State.ENROLL)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .user(owner)
                .build();

        Menu menu = Menu.builder()
                .menuId(400L)
                .menuName("menuName")
                .menuPrice(10000L)
                .state(State.ENROLL)
                .store(store)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build();

        Mockito.when(basketRepo.findById(basketId))
                .thenReturn(Optional.of(Basket.builder()
                        .basketId(basketId)
                        .amount(100)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .user(user)
                        .store(store)
                        .menu(menu)
                        .build()));

        Mockito.when(basketMapper.toReadBasketOutDTOCustom(any()))
                .thenReturn(ReadBasketOutDTO.builder()
                        .basketId(basketId)
                        .userId(100L)
                        .storeId(300L)
                        .menuId(400L)
                        .amount(100)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .build());

        // when
        ReadBasketOutDTO readBasketOutDTO = basketService.readBasketByBasketId(basketId);

        // then
        Assertions.assertEquals(readBasketOutDTO.getBasketId(), basketId);
        Assertions.assertEquals(readBasketOutDTO.getUserId(), 100L);
        Assertions.assertEquals(readBasketOutDTO.getStoreId(), 300L);
        Assertions.assertEquals(readBasketOutDTO.getMenuId(), 400L);
        Assertions.assertEquals(readBasketOutDTO.getAmount(), 100);
        Assertions.assertEquals(readBasketOutDTO.getCreateAt(), createAt);
        Assertions.assertEquals(readBasketOutDTO.getUpdateAt(), updateAt);
    }

    @Test
    @DisplayName("readBasketByBasketId_NotExistBasketId_Exception")
    void readBasketByBasketId_NotExistBasketId_Exception() throws Exception {
        // given
        Long basketId = 100L;

        // when
        Mockito.when(basketRepo.findById(basketId))
                .thenThrow(new IllegalArgumentException("Not exist basketId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.readBasketByBasketId(basketId));
    }

    @Test
    @DisplayName("readBasketByUserId_Normal_Success")
    void readBasketByUserId_Normal_Success() throws Exception {
        // given
        Long userId = 100L;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();

        List<ReadBasketOutDTO> ReadBasketOutDTOS = new ArrayList<>();

        ReadBasketOutDTOS.add(ReadBasketOutDTO.builder()
                .basketId(100L)
                .userId(100L)
                .storeId(100L)
                .menuId(100L)
                .amount(10000)
                .createAt(createAt)
                .updateAt(updateAt)
                .build());

        Mockito.when(basketRepo.findBy(userId))
                .thenReturn(Optional.of(ReadBasketOutDTOS));


        // when
        ReadBasketOutDTOs readBasketOutDTOs = basketService.readBasketByUserId(userId);

        // then
        Assertions.assertEquals(readBasketOutDTOs.getBaskets().get(0).getBasketId(), 100L);
        Assertions.assertEquals(readBasketOutDTOs.getBaskets().get(0).getUserId(), userId);
        Assertions.assertEquals(readBasketOutDTOs.getBaskets().get(0).getStoreId(), 100L);
        Assertions.assertEquals(readBasketOutDTOs.getBaskets().get(0).getMenuId(), 100L);
        Assertions.assertEquals(readBasketOutDTOs.getBaskets().get(0).getAmount(), 10000);
        Assertions.assertEquals(readBasketOutDTOs.getBaskets().get(0).getCreateAt(), createAt);
        Assertions.assertEquals(readBasketOutDTOs.getBaskets().get(0).getUpdateAt(), updateAt);
    }

    @Test
    @DisplayName("readBasketByUserId_NotExistUserId_Exception")
    void readBasketByUserId_NotExistUserId_Exception() {
        // given
        Long userId = 100L;

        // when
        Mockito.when(basketRepo.findBy(userId))
                .thenThrow(new IllegalArgumentException("Not exist userId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.readBasketByUserId(userId));
    }

    @Test
    @DisplayName("createBasket_Normal_Success")
    void createBasket_Normal_Success() throws Exception {
        // given
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        User user = User.builder()
                .userId(100L)
                .userName("hozzi")
                .userType(UserType.USER)
                .age(20)
                .point(100L)
                .balance(100L)
                .gender(Gender.Male)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();

        User owner = User.builder()
                .userId(200L)
                .userName("owner")
                .userType(UserType.OWNER)
                .age(20)
                .point(200L)
                .balance(200L)
                .gender(Gender.Male)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();

        Store store = Store.builder()
                .storeId(300L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
                .state(State.ENROLL)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .user(owner)
                .build();

        Menu menu = Menu.builder()
                .menuId(400L)
                .menuName("menuName")
                .menuPrice(10000L)
                .state(State.ENROLL)
                .store(store)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build();

        Mockito.when(userRepo.findById(100L))
                .thenReturn(Optional.ofNullable(user));

        Mockito.when(storeRepo.findById(100L))
                .thenReturn(Optional.ofNullable(store));

        Mockito.when(menuRepo.findById(100L))
                .thenReturn(Optional.ofNullable(menu));

        CreateBasketInDTO createBasketInDTO = CreateBasketInDTO.builder()
                .userId(100L)
                .storeId(100L)
                .menuId(100L)
                .amount(10000)
                .build();

        Mockito.when(basketMapper.toCreateBasketOutDTOCustom(any(Basket.class)))
                .thenReturn(CreateBasketOutDTO.builder()
                        .basketId(100L)
                        .userId(100L)
                        .storeId(100L)
                        .menuId(100L)
                        .amount(10000)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .build());

        // when
        CreateBasketOutDTO createBasketOutDTO = basketService.createBasket(createBasketInDTO);

        // then
        Assertions.assertEquals(createBasketOutDTO.getUserId(), 100L);
        Assertions.assertEquals(createBasketOutDTO.getStoreId(), 100L);
        Assertions.assertEquals(createBasketOutDTO.getMenuId(), 100L);
        Assertions.assertEquals(createBasketOutDTO.getAmount(), 10000);
    }

    @Test
    @DisplayName("createBasket_NotExistUserId_Exception")
    void createBasket_NotExistUserId_Exception() {
        Long userId = 100L;

        CreateBasketInDTO createBasketInDTO = CreateBasketInDTO.builder()
                .userId(userId)
                .storeId(100L)
                .menuId(100L)
                .amount(10000)
                .build();

        Mockito.when(userRepo.findById(userId))
                .thenThrow(new IllegalArgumentException("Not exist userId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.createBasket(createBasketInDTO));
    }

    @Test
    @DisplayName("createBasket_NotExistStoreId_Exception")
    void createBasket_NotExistStoreId_Exception() {
        Long storeId = 100L;

        CreateBasketInDTO createBasketInDTO = CreateBasketInDTO.builder()
                .userId(100L)
                .storeId(storeId)
                .menuId(100L)
                .amount(10000)
                .build();

        Mockito.when(storeRepo.findById(storeId))
                .thenThrow(new IllegalArgumentException("Not exist storeId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.createBasket(createBasketInDTO));
    }

    @Test
    @DisplayName("createBasket_NotExistMenuId_Exception")
    void createBasket_NotExistMenuId_Exception() {
        Long menuId = 100L;

        CreateBasketInDTO createBasketInDTO = CreateBasketInDTO.builder()
                .userId(100L)
                .storeId(100L)
                .menuId(menuId)
                .amount(10000)
                .build();

        Mockito.when(storeRepo.findById(menuId))
                .thenThrow(new IllegalArgumentException("Not exist menuId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.createBasket(createBasketInDTO));
    }

    @Test
    @DisplayName("deleteBasketByUserId_Normal_Success")
    void deleteBasketByUserId_Normal_Success() throws Exception {
        Long userId = 100L;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();

        User user = User.builder()
                .userId(100L)
                .userName("hozzi")
                .userType(UserType.USER)
                .age(20)
                .point(100L)
                .balance(100L)
                .gender(Gender.Male)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();

        Mockito.when(userRepo.findById(userId))
                .thenReturn(Optional.ofNullable(user));

        basketService.deleteBasketByUserId(userId);

        verify(basketRepo).deleteByUserId(userId);
    }

    @Test
    @DisplayName("deleteBasketByUserId_NotExistUserId_Exception")
    void deleteBasketByUserId_NotExistUserId_Exception() {
        Long userId = 100L;

        Mockito.when(userRepo.findById(userId))
                .thenThrow(new IllegalArgumentException("Not exist userId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.deleteBasketByUserId(userId));
    }

    @Test
    @DisplayName("deleteBasketByBasketId_Normal_Success")
    void deleteBasketByBasketId_Normal_Success() throws Exception {
        Long basketId = 100L;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        User user = User.builder()
                .userId(100L)
                .userName("hozzi")
                .userType(UserType.USER)
                .age(20)
                .point(100L)
                .balance(100L)
                .gender(Gender.Male)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();

        User owner = User.builder()
                .userId(200L)
                .userName("owner")
                .userType(UserType.OWNER)
                .age(20)
                .point(200L)
                .balance(200L)
                .gender(Gender.Male)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();

        Store store = Store.builder()
                .storeId(300L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
                .state(State.ENROLL)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .user(owner)
                .build();

        Menu menu = Menu.builder()
                .menuId(400L)
                .menuName("menuName")
                .menuPrice(10000L)
                .state(State.ENROLL)
                .store(store)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build();

        Basket basket = Basket.builder()
                .basketId(100L)
                .amount(10000)
                .createAt(createAt)
                .updateAt(updateAt)
                .user(user)
                .store(store)
                .menu(menu)
                .build();

        Mockito.when(basketRepo.findById(basketId))
                .thenReturn(Optional.ofNullable(basket));

        basketService.deleteBasketByBasketId(basketId);

        verify(basketRepo).deleteByBasketId(basketId);
    }

    @Test
    @DisplayName("deleteBasketByBasketId_NotExistBasketId_Exception")
    void deleteBasketByBasketId_NotExistBasketId_Exception() {
        Long basketId = 100L;

        Mockito.when(basketRepo.findById(basketId))
                .thenThrow(new IllegalArgumentException("Not exist basketId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> basketService.deleteBasketByBasketId(basketId));
    }
}