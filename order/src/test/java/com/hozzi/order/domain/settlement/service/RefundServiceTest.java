package com.hozzi.order.domain.settlement.service;

import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.order.repo.OrderRepo;
import com.hozzi.order.domain.settlement.dto.CreateRefundInDTO;
import com.hozzi.order.domain.settlement.dto.CreateRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.ReadRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.ReadRefundOutDTOs;
import com.hozzi.order.domain.settlement.entity.Refund;
import com.hozzi.order.domain.settlement.enumerate.RefundType;
import com.hozzi.order.domain.settlement.mapper.RefundMapper;
import com.hozzi.order.domain.settlement.repo.RefundRepo;
import com.hozzi.order.domain.settlement.service.impl.RefundServiceImpl;
import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.entity.Wallet;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.repo.UserRepo;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

class RefundServiceTest {
    RefundService refundService;
    private RefundRepo refundRepo = Mockito.mock(RefundRepo.class);
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private OrderRepo orderRepo = Mockito.mock(OrderRepo.class);
    private RefundMapper refundMapper = Mockito.mock(RefundMapper.class);

    @BeforeEach
    void SetUpTest() {
        refundService = new RefundServiceImpl(refundRepo, userRepo, orderRepo, refundMapper);
    }

    @Test
    @DisplayName("createRefund_Normal_Success")
    void createRefund_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();
        User custom = User.builder()
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

        User owner = User.builder()
                .userId(200L)
                .userName("imOwner")
                .userType(UserType.OWNER)
                .age(30)
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

        CreateRefundInDTO createRefundInDTO = CreateRefundInDTO.builder()
                .orderId(100L)
                .customId(100L)
                .ownerId(200L)
                .refundType(RefundType.BOTH)
                .customBalance(100L)
                .ownerBalance(100L)
                .refundReason("no reason")
                .build();

        Mockito.when(userRepo.findById(createRefundInDTO.getCustomId()))
                .thenReturn(Optional.ofNullable(custom));

        Mockito.when(userRepo.findById(createRefundInDTO.getOwnerId()))
                .thenReturn(Optional.ofNullable(owner));

        Mockito.when(orderRepo.findById(createRefundInDTO.getOrderId()))
                .thenReturn(Optional.ofNullable(order));

        Mockito.when(refundMapper.toCreateRefundOutDTO(any(Refund.class)))
                .thenReturn(CreateRefundOutDTO.builder()
                        .refundId(100L)
                        .orderId(100L)
                        .customId(100L)
                        .ownerId(200L)
                        .customBalance(100L)
                        .ownerBalance(100L)
                        .refundType(RefundType.BOTH)
                        .refundReason("no reason")
                        .createAt(time)
                        .updateAt(time)
                        .build());

        CreateRefundOutDTO createRefundOutDTO = refundService.createRefund(createRefundInDTO);

        Assertions.assertEquals(createRefundOutDTO.getRefundId(), 100L);
        Assertions.assertEquals(createRefundOutDTO.getOrderId(), 100L);
        Assertions.assertEquals(createRefundOutDTO.getCustomId(), 100L);
        Assertions.assertEquals(createRefundOutDTO.getOwnerId(), 200L);
        Assertions.assertEquals(createRefundOutDTO.getCustomBalance(), 100L);
        Assertions.assertEquals(createRefundOutDTO.getOwnerBalance(), 100L);
        Assertions.assertEquals(createRefundOutDTO.getRefundType(), RefundType.BOTH);
        Assertions.assertEquals(createRefundOutDTO.getRefundReason(), "no reason");
        Assertions.assertEquals(createRefundOutDTO.getCreateAt(), time);
        Assertions.assertEquals(createRefundOutDTO.getUpdateAt(), time);
    }

    @Test
    @DisplayName("createRefund_NotExistCustomId_Exception")
    void createRefund_NotExistCustomId_Exception() {
        CreateRefundInDTO createRefundInDTO = CreateRefundInDTO.builder()
                .orderId(100L)
                .customId(100L)
                .ownerId(200L)
                .refundType(RefundType.BOTH)
                .customBalance(100L)
                .ownerBalance(100L)
                .refundReason("no reason")
                .build();

        Mockito.when(userRepo.findById(createRefundInDTO.getCustomId()))
                .thenThrow(new IllegalArgumentException("Not exist customId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> refundService.createRefund(createRefundInDTO));
    }

    @Test
    @DisplayName("createRefund_NotExistOwnerId_Exception")
    void createRefund_NotExistOwnerId_Exception() {
        CreateRefundInDTO createRefundInDTO = CreateRefundInDTO.builder()
                .orderId(100L)
                .customId(100L)
                .ownerId(200L)
                .refundType(RefundType.BOTH)
                .customBalance(100L)
                .ownerBalance(100L)
                .refundReason("no reason")
                .build();

        Mockito.when(userRepo.findById(createRefundInDTO.getOwnerId()))
                .thenThrow(new IllegalArgumentException("Not exist ownerId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> refundService.createRefund(createRefundInDTO));
    }

    @Test
    @DisplayName("createRefund_NotExistOrderId_Exception")
    void createRefund_NotExistOrderId_Exception() {
        CreateRefundInDTO createRefundInDTO = CreateRefundInDTO.builder()
                .orderId(100L)
                .customId(100L)
                .ownerId(200L)
                .refundType(RefundType.BOTH)
                .customBalance(100L)
                .ownerBalance(100L)
                .refundReason("no reason")
                .build();

        Mockito.when(userRepo.findById(createRefundInDTO.getOrderId()))
                .thenThrow(new IllegalArgumentException("Not exist orderId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> refundService.createRefund(createRefundInDTO));
    }

    @Test
    @DisplayName("readRefund_Normal_Success")
    void readRefund_Normal_Success() {
        LocalDateTime time = LocalDateTime.now();
        List<ReadRefundOutDTO> readRefundOutDTOS = new ArrayList<>();

        readRefundOutDTOS.add(ReadRefundOutDTO.builder()
                .refundId(100L)
                .customBalance(100L)
                .ownerBalance(100L)
                .refundType(RefundType.BOTH)
                .refundReason("no reason")
                .customId(100L)
                .ownerId(100L)
                .orderId(100L)
                .createAt(time)
                .updateAt(time)
                .build());

        Mockito.when(refundRepo.findAllBetweenDate(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(Optional.of(readRefundOutDTOS));

        ReadRefundOutDTOs readRefundOutDTOs = refundService.readRefund("20240101000000", "20240607000000");

        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getRefundId(), 100L);
        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getCustomBalance(), 100L);
        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getOwnerBalance(), 100L);
        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getRefundType(), RefundType.BOTH);
        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getRefundReason(), "no reason");
        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getCustomId(), 100L);
        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getOwnerId(), 100L);
        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getOrderId(), 100L);
        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getCreateAt(), time);
        Assertions.assertEquals(readRefundOutDTOs.getRefunds().get(0).getUpdateAt(), time);
    }

    @Test
    @DisplayName("readRefund_NotExistRefundData_Exception")
    void readRefund_NotExistRefundData_Exception() {
        Mockito.when(refundRepo.findAllBetweenDate(any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenThrow(new IllegalArgumentException("Not exist orderId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> refundService.readRefund("20240101000000", "20240607000000"));
    }
}