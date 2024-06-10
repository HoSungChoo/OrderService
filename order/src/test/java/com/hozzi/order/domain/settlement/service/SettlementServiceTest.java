package com.hozzi.order.domain.settlement.service;

import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.order.repo.OrderRepo;
import com.hozzi.order.domain.settlement.dto.*;
import com.hozzi.order.domain.settlement.entity.Settlement;
import com.hozzi.order.domain.settlement.enumerate.RefundType;
import com.hozzi.order.domain.settlement.enumerate.SettlementType;
import com.hozzi.order.domain.settlement.mapper.SettlementMapper;
import com.hozzi.order.domain.settlement.repo.RefundRepo;
import com.hozzi.order.domain.settlement.repo.SettlementRepo;
import com.hozzi.order.domain.settlement.service.impl.RefundServiceImpl;
import com.hozzi.order.domain.settlement.service.impl.SettlementServiceImpl;
import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.entity.Wallet;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.repo.UserRepo;
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
import static org.mockito.ArgumentMatchers.eq;

class SettlementServiceTest {
    SettlementService settlementService;
    private SettlementRepo settlementRepo = Mockito.mock(SettlementRepo.class);
    private RefundRepo refundRepo = Mockito.mock(RefundRepo.class);
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private OrderRepo orderRepo = Mockito.mock(OrderRepo.class);
    private SettlementMapper settlementMapper = Mockito.mock(SettlementMapper.class);

    @BeforeEach
    void SetUpTest() {
        settlementService = new SettlementServiceImpl(settlementRepo, refundRepo, userRepo, orderRepo, settlementMapper);
    }

    @Test
    @DisplayName("createReward_Normal_Success")
    void createReward_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();
        CreateRewardInDTO createRewardInDTO = CreateRewardInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .balance(100L)
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

        Order order = Order.builder()
                .orderId(100L)
                .balance(100L)
                .reward(100L)
                .amount(100)
                .createAt(time)
                .updateAt(time)
                .wallet(Wallet.builder().build())
                .store(Store.builder().build())
                .menu(Menu.builder().build())
                .build();

        Mockito.when(userRepo.findById(createRewardInDTO.getUserId()))
                .thenReturn(Optional.ofNullable(user));

        Mockito.when(orderRepo.findById(createRewardInDTO.getOrderId()))
                .thenReturn(Optional.ofNullable(order));

        Mockito.when(settlementMapper.toCreateRewardOutDTOCustom(any(Settlement.class)))
                .thenReturn(CreateRewardOutDTO.builder()
                        .settlementId(100L)
                        .balance(100L)
                        .settlementType(SettlementType.REWARD)
                        .userId(100L)
                        .orderId(100L)
                        .createAt(time)
                        .updateAt(time)
                        .build());

        CreateRewardOutDTO createRewardOutDTO = settlementService.createReward(createRewardInDTO);

        Assertions.assertEquals(createRewardOutDTO.getSettlementId(), 100L);
        Assertions.assertEquals(createRewardOutDTO.getBalance(), 100L);
        Assertions.assertEquals(createRewardOutDTO.getSettlementType(), SettlementType.REWARD);
        Assertions.assertEquals(createRewardOutDTO.getUserId(), 100L);
        Assertions.assertEquals(createRewardOutDTO.getOrderId(), 100L);
        Assertions.assertEquals(createRewardOutDTO.getCreateAt(), time);
        Assertions.assertEquals(createRewardOutDTO.getUpdateAt(), time);
    }
    @Test
    @DisplayName("createReward_NotExistUserId_Exception")
    void createReward_NotExistUserId_Exception() {
        CreateRewardInDTO createRewardInDTO = CreateRewardInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .balance(100L)
                .build();

        Mockito.when(userRepo.findById(createRewardInDTO.getUserId()))
                .thenThrow(new IllegalArgumentException("Not exist userId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> settlementService.createReward(createRewardInDTO));
    }
    @Test
    @DisplayName("createReward_NotExistOrderId_Exception")
    void createReward_NotExistOrderId_Exception() {
        CreateRewardInDTO createRewardInDTO = CreateRewardInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .balance(100L)
                .build();

        Mockito.when(orderRepo.findById(createRewardInDTO.getOrderId()))
                .thenThrow(new IllegalArgumentException("Not exist orderId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> settlementService.createReward(createRewardInDTO));
    }
    @Test
    @DisplayName("createPayout_Normal_Success")
    void createPayout_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();
        CreatePayoutInDTO createPayoutInDTO = CreatePayoutInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .balance(100L)
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

        Order order = Order.builder()
                .orderId(100L)
                .balance(100L)
                .reward(100L)
                .amount(100)
                .createAt(time)
                .updateAt(time)
                .wallet(Wallet.builder().build())
                .store(Store.builder().build())
                .menu(Menu.builder().build())
                .build();

        Mockito.when(userRepo.findById(createPayoutInDTO.getUserId()))
                .thenReturn(Optional.ofNullable(user));

        Mockito.when(orderRepo.findById(createPayoutInDTO.getOrderId()))
                .thenReturn(Optional.ofNullable(order));

        Mockito.when(settlementMapper.toCreatePayoutOutDTOCustom(any(Settlement.class)))
                .thenReturn(CreatePayoutOutDTO.builder()
                        .settlementId(100L)
                        .balance(100L)
                        .settlementType(SettlementType.PAYOUT)
                        .userId(100L)
                        .orderId(100L)
                        .createAt(time)
                        .updateAt(time)
                        .build());

        CreatePayoutOutDTO createPayoutOutDTO = settlementService.createPayout(createPayoutInDTO);

        Assertions.assertEquals(createPayoutOutDTO.getSettlementId(), 100L);
        Assertions.assertEquals(createPayoutOutDTO.getBalance(), 100L);
        Assertions.assertEquals(createPayoutOutDTO.getSettlementType(), SettlementType.PAYOUT);
        Assertions.assertEquals(createPayoutOutDTO.getUserId(), 100L);
        Assertions.assertEquals(createPayoutOutDTO.getOrderId(), 100L);
        Assertions.assertEquals(createPayoutOutDTO.getCreateAt(), time);
        Assertions.assertEquals(createPayoutOutDTO.getUpdateAt(), time);
    }
    @Test
    @DisplayName("createPayout_NotExistUserId_Exception")
    void createPayout_NotExistUserId_Exception() {
        CreatePayoutInDTO createPayoutInDTO = CreatePayoutInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .balance(100L)
                .build();

        Mockito.when(userRepo.findById(createPayoutInDTO.getUserId()))
                .thenThrow(new IllegalArgumentException("Not exist userId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> settlementService.createPayout(createPayoutInDTO));
    }
    @Test
    @DisplayName("createPayout_NotExistOrderId_Exception")
    void createPayout_NotExistOrderId_Exception() {
        CreatePayoutInDTO createPayoutInDTO = CreatePayoutInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .balance(100L)
                .build();

        Mockito.when(orderRepo.findById(createPayoutInDTO.getOrderId()))
                .thenThrow(new IllegalArgumentException("Not exist orderId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> settlementService.createPayout(createPayoutInDTO));
    }
    @Test
    @DisplayName("readReward_Normal_Success")
    void readReward_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();
        List<ReadSettlementOutDTO> readSettlementOutDTOS = new ArrayList<>();

        readSettlementOutDTOS.add(
                ReadSettlementOutDTO.builder()
                        .settlementId(100L)
                        .userId(100L)
                        .orderId(100L)
                        .balance(100L)
                        .createAt(time)
                        .updateAt(time)
                        .build());

        Mockito.when(settlementRepo.findAllBetweenDate(any(LocalDateTime.class), any(LocalDateTime.class), any(SettlementType.class)))
                .thenReturn(Optional.of(readSettlementOutDTOS));

        ReadSettlementOutDTOs readSettlementOutDTOs = settlementService.readReward("20240101000000", "20240607000000");

        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getSettlementId(), 100L);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getUserId(), 100L);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getOrderId(), 100L);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getBalance(), 100L);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getCreateAt(), time);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getUpdateAt(), time);
    }
    @Test
    @DisplayName("readReward_NotExistData_Exception")
    void readReward_NotExistData_Exception() {
        Mockito.when(settlementRepo.findAllBetweenDate(any(LocalDateTime.class), any(LocalDateTime.class), any(SettlementType.class)))
                .thenThrow(new IllegalArgumentException("Exception"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> settlementService.readReward("20240101000000", "20240607000000"));
    }
    @Test
    @DisplayName("readPayout_Normal_Success")
    void readPayout_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();
        List<ReadSettlementOutDTO> readSettlementOutDTOS = new ArrayList<>();

        readSettlementOutDTOS.add(
                ReadSettlementOutDTO.builder()
                        .settlementId(100L)
                        .userId(100L)
                        .orderId(100L)
                        .balance(100L)
                        .createAt(time)
                        .updateAt(time)
                        .build());

        Mockito.when(settlementRepo.findAllBetweenDate(any(LocalDateTime.class), any(LocalDateTime.class), any(SettlementType.class)))
                .thenReturn(Optional.of(readSettlementOutDTOS));

        ReadSettlementOutDTOs readSettlementOutDTOs = settlementService.readReward("20240101000000", "20240607000000");

        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getSettlementId(), 100L);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getUserId(), 100L);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getOrderId(), 100L);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getBalance(), 100L);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getCreateAt(), time);
        Assertions.assertEquals(readSettlementOutDTOs.getSettlements().get(0).getUpdateAt(), time);
    }
    @Test
    @DisplayName("readPayout_NotExistData_Exception")
    void readPayout_NotExistData_Exception() {
        Mockito.when(settlementRepo.findAllBetweenDate(any(LocalDateTime.class), any(LocalDateTime.class), any(SettlementType.class)))
                .thenThrow(new IllegalArgumentException("Exception"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> settlementService.readPayout("20240101000000", "20240607000000"));
    }
}