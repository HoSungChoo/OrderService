package com.hozzi.order.domain.store.service;

import com.hozzi.order.domain.store.dto.*;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.store.enumerate.StoreType;
import com.hozzi.order.domain.store.mapper.StoreMapper;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.store.service.impl.StoreServiceImpl;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.global.enumerate.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

class StoreServiceTest {
    StoreService storeService;

    private StoreRepo storeRepo = Mockito.mock(StoreRepo.class);
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private StoreMapper storeMapper = Mockito.mock(StoreMapper.class);

    @BeforeEach
    public void SetupTest() {
        storeService = new StoreServiceImpl(storeRepo, userRepo, storeMapper);
    }

    @Test
    @DisplayName("readStore_Normal_Success")
    void readStore_Normal_Success() {
        List<ReadStoreOutDTO> readStoreOutDTOS = new ArrayList<>();
        LocalDateTime time = LocalDateTime.now();
        Long userId = 100L;

        ReadStoreOutDTO readStoreOutDTO = ReadStoreOutDTO.builder()
                .storeId(100L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
                .state(State.ENROLL)
                .createAt(time)
                .updateAt(time)
                .cancelAt(time)
                .build();

        readStoreOutDTOS.add(readStoreOutDTO);

        Mockito.when(storeRepo.findAllByUserIdCustom(userId))
                .thenReturn(Optional.of(readStoreOutDTOS));

        ReadStoreOutDTOs readStoreOutDTOs = storeService.readStore(userId);

        Assertions.assertEquals(readStoreOutDTOs.getStores().get(0).getStoreId(), 100L);
        Assertions.assertEquals(readStoreOutDTOs.getStores().get(0).getStoreName(), "storeName");
        Assertions.assertEquals(readStoreOutDTOs.getStores().get(0).getStoreType(), StoreType.KOREAN);
        Assertions.assertEquals(readStoreOutDTOs.getStores().get(0).getState(), State.ENROLL);
        Assertions.assertEquals(readStoreOutDTOs.getStores().get(0).getCreateAt(), time);
        Assertions.assertEquals(readStoreOutDTOs.getStores().get(0).getUpdateAt(), time);
        Assertions.assertEquals(readStoreOutDTOs.getStores().get(0).getCancelAt(), time);
    }

    @Test
    @DisplayName("readStore_NotExistUserId_Exception")
    void readStore_NotExistUserId_Exception() {
        Long userId = 100L;
        Mockito.when(storeRepo.findAllByUserIdCustom(userId))
                .thenThrow(new IllegalArgumentException("Not exist userId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> storeService.readStore(userId));
    }

    @Test
    @DisplayName("createStore_Normal_Success")
    void createStore_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();
        CreateStoreInDTO createStoreInDTO = CreateStoreInDTO.builder()
                .userId(100L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
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

        Mockito.when(userRepo.findById(createStoreInDTO.getUserId()))
                .thenReturn(Optional.ofNullable(user));

        Mockito.when(storeMapper.toCreateStoreOutDTO(any(Store.class)))
                .thenReturn(CreateStoreOutDTO.builder()
                        .storeId(100L)
                        .storeName("storeName")
                        .storeType(StoreType.KOREAN)
                        .state(State.ENROLL)
                        .createAt(time)
                        .updateAt(time)
                        .cancelAt(LocalDateTime.of(2999, 12, 31, 0, 0, 0))
                        .build());

        CreateStoreOutDTO createStoreOutDTO = storeService.createStore(createStoreInDTO);

        Assertions.assertEquals(createStoreOutDTO.getStoreId(), 100L);
        Assertions.assertEquals(createStoreOutDTO.getStoreName(), "storeName");
        Assertions.assertEquals(createStoreOutDTO.getStoreType(), StoreType.KOREAN);
        Assertions.assertEquals(createStoreOutDTO.getState(), State.ENROLL);
        Assertions.assertEquals(createStoreOutDTO.getCreateAt(), time);
        Assertions.assertEquals(createStoreOutDTO.getUpdateAt(), time);
        Assertions.assertEquals(createStoreOutDTO.getCancelAt(), LocalDateTime.of(2999, 12, 31, 0, 0, 0));
    }

    @Test
    @DisplayName("createStore_NotExistUserId_Exception")
    void createStore_NotExistUserId_Exception() {
        CreateStoreInDTO createStoreInDTO = CreateStoreInDTO.builder()
                .userId(100L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
                .state(State.ENROLL)
                .build();

        Mockito.when(userRepo.findById(createStoreInDTO.getUserId()))
                .thenThrow(new IllegalArgumentException("Not exist userId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> storeService.createStore(createStoreInDTO));
    }

    @Test
    @DisplayName("updateStore_Normal_Success")
    void updateStore_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();
        UpdateStoreInDTO updateStoreInDTO = UpdateStoreInDTO.builder()
                .userId(100L)
                .storeId(100L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
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

        Mockito.when(storeRepo.findById(updateStoreInDTO.getStoreId()))
                .thenReturn(Optional.ofNullable(store));

        Mockito.when(userRepo.findById(updateStoreInDTO.getUserId()))
                .thenReturn(Optional.ofNullable(user));

        Mockito.when(storeMapper.toUpdateStoreOutDTO(store))
                .thenReturn(UpdateStoreOutDTO.builder()
                        .storeId(100L)
                        .storeName("storeName")
                        .storeType(StoreType.KOREAN)
                        .state(State.ENROLL)
                        .createAt(time)
                        .updateAt(time)
                        .cancelAt(time)
                        .build());

        UpdateStoreOutDTO updateStoreOutDTO = storeService.updateStore(updateStoreInDTO);

        Assertions.assertEquals(updateStoreOutDTO.getStoreId(), 100L);
        Assertions.assertEquals(updateStoreOutDTO.getStoreName(), "storeName");
        Assertions.assertEquals(updateStoreOutDTO.getStoreType(), StoreType.KOREAN);
        Assertions.assertEquals(updateStoreOutDTO.getState(), State.ENROLL);
        Assertions.assertEquals(updateStoreOutDTO.getCreateAt(), time);
        Assertions.assertEquals(updateStoreOutDTO.getUpdateAt(), time);
        Assertions.assertEquals(updateStoreOutDTO.getCancelAt(), time);
    }

    @Test
    @DisplayName("updateStore_NotExistStoreId_Exception")
    void updateStore_NotExistStoreId_Exception() {
        UpdateStoreInDTO updateStoreInDTO = UpdateStoreInDTO.builder()
                .userId(100L)
                .storeId(100L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
                .state(State.ENROLL)
                .build();

        Mockito.when(userRepo.findById(updateStoreInDTO.getStoreId()))
                .thenThrow(new IllegalArgumentException("Not exist storeId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> storeService.updateStore(updateStoreInDTO));
    }

    @Test
    @DisplayName("updateStore_NotExistUserId_Exception")
    void updateStore_NotExistUserId_Exception() {
        UpdateStoreInDTO updateStoreInDTO = UpdateStoreInDTO.builder()
                .userId(100L)
                .storeId(100L)
                .storeName("storeName")
                .storeType(StoreType.KOREAN)
                .state(State.ENROLL)
                .build();

        Mockito.when(userRepo.findById(updateStoreInDTO.getUserId()))
                .thenThrow(new IllegalArgumentException("Not exist userId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> storeService.updateStore(updateStoreInDTO));
    }
}