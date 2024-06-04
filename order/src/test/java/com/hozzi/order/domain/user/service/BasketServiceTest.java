package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.store.enumerate.StoreType;
import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.mapper.BasketMapper;
import com.hozzi.order.domain.user.repo.BasketRepo;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.service.impl.BasketServiceImpl;
import com.hozzi.order.global.enumerate.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

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