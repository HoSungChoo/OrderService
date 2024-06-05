package com.hozzi.order.domain.pay.service;

import com.hozzi.order.domain.pay.dto.*;
import com.hozzi.order.domain.pay.entity.Payment;
import com.hozzi.order.domain.pay.mapper.PayMapper;
import com.hozzi.order.domain.pay.repo.PayRepo;
import com.hozzi.order.domain.pay.service.impl.PayServiceImpl;
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
class PayServiceTest {
    PayService payService;
    private PayRepo payRepo = Mockito.mock(PayRepo.class);
    private PayMapper payMapper = Mockito.mock(PayMapper.class);

    @BeforeEach
    public void setUpTest() {
        payService = new PayServiceImpl(payRepo, payMapper);
    }

    @Test
    @DisplayName("readPayments_Normal_Success")
    void readPayments_Normal_Success() {
        // given
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        List<ReadPaymentOutDTO> readPaymentOutDTOS = new ArrayList<>();

        readPaymentOutDTOS.add(ReadPaymentOutDTO.builder()
                .paymentId(100L)
                .paymentName("paymentName")
                .state(State.ENROLL)
                .discountRate(0.7F)
                .rewardRate(0.7F)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build());

        Mockito.when(payRepo.findAllCustom())
                .thenReturn(Optional.of(readPaymentOutDTOS));

        ReadPaymentOutDTOs readPaymentOutDTOs = payService.readPayments();

        Assertions.assertEquals(readPaymentOutDTOs.getPayments().get(0).getPaymentId(), 100L);
        Assertions.assertEquals(readPaymentOutDTOs.getPayments().get(0).getPaymentName(), "paymentName");
        Assertions.assertEquals(readPaymentOutDTOs.getPayments().get(0).getState(), State.ENROLL);
        Assertions.assertEquals(readPaymentOutDTOs.getPayments().get(0).getDiscountRate(), 0.7F);
        Assertions.assertEquals(readPaymentOutDTOs.getPayments().get(0).getRewardRate(), 0.7F);
        Assertions.assertEquals(readPaymentOutDTOs.getPayments().get(0).getCreateAt(), createAt);
        Assertions.assertEquals(readPaymentOutDTOs.getPayments().get(0).getUpdateAt(), updateAt);
        Assertions.assertEquals(readPaymentOutDTOs.getPayments().get(0).getCancelAt(), cancelAt);
    }

    @Test
    @DisplayName("readPayments_Exception_Exception")
    void readPayments_Exception_Exception() {
        Mockito.when(payRepo.findAllCustom())
                .thenThrow(new IllegalArgumentException("Bad Request"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> payService.readPayments());
    }

    @Test
    @DisplayName("readPayment_Normal_Success")
    void readPayment_Normal_Success() {
        Long paymentId = 100L;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        Payment payment = Payment.builder()
                .paymentId(100L)
                .paymentName("paymentName")
                .state(State.ENROLL)
                .discountRate(0.7F)
                .rewardRate(0.7F)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build();

        Mockito.when(payRepo.findById(paymentId))
                .thenReturn(Optional.ofNullable(payment));

        Mockito.when(payMapper.toReadPaymentOutDTO(payment))
                .thenReturn(ReadPaymentOutDTO.builder()
                        .paymentId(100L)
                        .paymentName("paymentName")
                        .state(State.ENROLL)
                        .discountRate(0.7F)
                        .rewardRate(0.7F)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .cancelAt(cancelAt)
                        .build());

        ReadPaymentOutDTO readPaymentOutDTO = payService.readPayment(paymentId);

        Assertions.assertEquals(readPaymentOutDTO.getPaymentId(), 100L);
        Assertions.assertEquals(readPaymentOutDTO.getPaymentName(), "paymentName");
        Assertions.assertEquals(readPaymentOutDTO.getState(), State.ENROLL);
        Assertions.assertEquals(readPaymentOutDTO.getDiscountRate(), 0.7F);
        Assertions.assertEquals(readPaymentOutDTO.getRewardRate(), 0.7F);
        Assertions.assertEquals(readPaymentOutDTO.getCreateAt(), createAt);
        Assertions.assertEquals(readPaymentOutDTO.getUpdateAt(), updateAt);
        Assertions.assertEquals(readPaymentOutDTO.getCancelAt(), cancelAt);
    }

    @Test
    @DisplayName("readPayment_NotExistPaymentId_Exception")
    void readPayment_NotExistPaymentId_Exception() {
        Long paymentId = 100L;

        Mockito.when(payRepo.findById(paymentId))
                .thenThrow(new IllegalArgumentException("Not exist paymentId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> payService.readPayments());
    }

    @Test
    @DisplayName("createPayment_Normal_Success")
    void createPayment_Normal_Success() {
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        CreatePaymentInDTO createPaymentInDTO = CreatePaymentInDTO.builder()
                .paymentName("paymentName")
                .state(State.ENROLL)
                .discountRate(0.7F)
                .rewardRate(0.7F)
                .build();

        Payment payment = Payment.builder()
                .paymentId(100L)
                .paymentName("paymentName")
                .state(State.ENROLL)
                .discountRate(0.7F)
                .rewardRate(0.7F)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build();

        Mockito.when(payRepo.existsByPaymentName(createPaymentInDTO.getPaymentName()))
                .thenReturn(false);

        Mockito.when(payMapper.toCreatePaymentOutDTO(any(Payment.class)))
                .thenReturn(CreatePaymentOutDTO.builder()
                        .paymentId(100L)
                        .paymentName("paymentName")
                        .state(State.ENROLL)
                        .discountRate(0.7F)
                        .rewardRate(0.7F)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .cancelAt(cancelAt)
                        .build());

        CreatePaymentOutDTO createPaymentOutDTO = payService.createPayment(createPaymentInDTO);

        Assertions.assertEquals(createPaymentOutDTO.getPaymentId(), 100L);
        Assertions.assertEquals(createPaymentOutDTO.getPaymentName(), "paymentName");
        Assertions.assertEquals(createPaymentOutDTO.getState(), State.ENROLL);
        Assertions.assertEquals(createPaymentOutDTO.getDiscountRate(), 0.7F);
        Assertions.assertEquals(createPaymentOutDTO.getRewardRate(), 0.7F);
        Assertions.assertEquals(createPaymentOutDTO.getCreateAt(), createAt);
        Assertions.assertEquals(createPaymentOutDTO.getUpdateAt(), updateAt);
        Assertions.assertEquals(createPaymentOutDTO.getCancelAt(), cancelAt);
    }

    @Test
    @DisplayName("createPayment_DuplicatedPaymentName_Exception")
    void createPayment_DuplicatedPaymentName_Exception() {
        CreatePaymentInDTO createPaymentInDTO = CreatePaymentInDTO.builder()
                .paymentName("paymentName")
                .state(State.ENROLL)
                .discountRate(0.7F)
                .rewardRate(0.7F)
                .build();

        Mockito.when(payRepo.existsByPaymentName(createPaymentInDTO.getPaymentName()))
                .thenReturn(true);

        Assertions.assertThrows(IllegalArgumentException.class, () -> payService.createPayment(createPaymentInDTO));
    }

    @Test
    @DisplayName("deletePayment_Normal_Success")
    void deletePayment_Normal_Success() {
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        DeletePaymentInDTO deletePaymentInDTO = DeletePaymentInDTO.builder()
                .paymentId(100L)
                .build();

        Payment payment = Payment.builder()
                .paymentId(100L)
                .paymentName("paymentName")
                .state(State.ENROLL)
                .discountRate(0.7F)
                .rewardRate(0.7F)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build();

        Mockito.when(payRepo.findById(deletePaymentInDTO.getPaymentId()))
                .thenReturn(Optional.ofNullable(payment));

        Mockito.when(payMapper.toDeletePaymentOutDTO(payment))
                .thenReturn(DeletePaymentOutDTO.builder()
                        .paymentId(100L)
                        .paymentName("paymentName")
                        .state(State.CANCEL)
                        .discountRate(0.7F)
                        .rewardRate(0.7F)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .cancelAt(cancelAt)
                        .build());

        DeletePaymentOutDTO deletePaymentOutDTO = payService.deletePayment(deletePaymentInDTO);

        Assertions.assertEquals(deletePaymentOutDTO.getPaymentId(), 100L);
        Assertions.assertEquals(deletePaymentOutDTO.getPaymentName(), "paymentName");
        Assertions.assertEquals(deletePaymentOutDTO.getState(), State.CANCEL);
        Assertions.assertEquals(deletePaymentOutDTO.getDiscountRate(), 0.7F);
        Assertions.assertEquals(deletePaymentOutDTO.getRewardRate(), 0.7F);
        Assertions.assertEquals(deletePaymentOutDTO.getCreateAt(), createAt);
        Assertions.assertEquals(deletePaymentOutDTO.getUpdateAt(), updateAt);
        Assertions.assertEquals(deletePaymentOutDTO.getCancelAt(), cancelAt);
    }

    @Test
    @DisplayName("deletePayment_NotExistPaymentId_Exception")
    void deletePayment_NotExistPaymentId_Exception() {
        DeletePaymentInDTO deletePaymentInDTO = DeletePaymentInDTO.builder()
                .paymentId(100L)
                .build();

        Mockito.when(payRepo.findById(deletePaymentInDTO.getPaymentId()))
                .thenThrow(new IllegalArgumentException("Not exist paymentId"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> payService.deletePayment(deletePaymentInDTO));
    }

    @Test
    @DisplayName("deletePayment_AlreadyCanceled_Exception")
    void deletePayment_AlreadyCanceled_Exception() {
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        DeletePaymentInDTO deletePaymentInDTO = DeletePaymentInDTO.builder()
                .paymentId(100L)
                .build();

        Payment payment = Payment.builder()
                .paymentId(100L)
                .paymentName("paymentName")
                .state(State.CANCEL)
                .discountRate(0.7F)
                .rewardRate(0.7F)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build();

        Mockito.when(payRepo.findById(deletePaymentInDTO.getPaymentId()))
                .thenReturn(Optional.ofNullable(payment));

        Assertions.assertThrows(IllegalArgumentException.class, () -> payService.deletePayment(deletePaymentInDTO));
    }
}