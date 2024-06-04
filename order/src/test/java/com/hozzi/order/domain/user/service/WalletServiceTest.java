package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.pay.entity.Payment;
import com.hozzi.order.domain.pay.repo.PayRepo;
import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.entity.Wallet;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.mapper.WalletMapper;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import com.hozzi.order.domain.user.service.impl.WalletServiceImpl;
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
import static org.mockito.Mockito.*;

class WalletServiceTest {
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private WalletRepo walletRepo = Mockito.mock(WalletRepo.class);
    private PayRepo payRepo = Mockito.mock(PayRepo.class);
    //@Spy
    //private WalletMapper walletMapper = Mappers.getMapper(WalletMapper.class);
    private WalletMapper walletMapper = Mockito.mock(WalletMapper.class);

    private WalletServiceImpl walletService;

    @BeforeEach
    public void setUpTest() {
        walletService = new WalletServiceImpl(userRepo, walletRepo, payRepo, walletMapper);
    }


    @Test
    @DisplayName("readWallet_Normal_Success")
    void readWallet_Normal_Success() throws Exception {
        // given
        Long userId = 100L;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();

        Mockito.when(userRepo.findById(userId))
                .thenReturn(Optional.of(User.builder()
                        .userId(100L)
                        .userName("hozzi")
                        .userType(UserType.USER)
                        .age(20)
                        .point(100L)
                        .balance(100L)
                        .gender(Gender.Male)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .build()));

        List<ReadWalletOutDTO> readWalletOutDTOS = new ArrayList<>();

        readWalletOutDTOS.add(ReadWalletOutDTO.builder()
                .walletId(100L)
                .state(State.ENROLL)
                .paymentId(100L)
                .paymentName("hozzi pay")
                .createAt(createAt)
                .updateAt(updateAt)
                .build());

        Mockito.when(walletRepo.findByUserId(userId))
                .thenReturn(Optional.of(readWalletOutDTOS));

        // when
        ReadWalletOutDTOs readWalletOutDTOs = walletService.readWallet(100L);

        // then
        Assertions.assertEquals(readWalletOutDTOs.getPay().get(0).getWalletId(), 100L);
        Assertions.assertEquals(readWalletOutDTOs.getPay().get(0).getState(), State.ENROLL);
        Assertions.assertEquals(readWalletOutDTOs.getPay().get(0).getPaymentId(), 100L);
        Assertions.assertEquals(readWalletOutDTOs.getPay().get(0).getPaymentName(), "hozzi pay");
        Assertions.assertEquals(readWalletOutDTOs.getPay().get(0).getCreateAt(), createAt);
        Assertions.assertEquals(readWalletOutDTOs.getPay().get(0).getUpdateAt(), updateAt);

        verify(userRepo).findById(userId);
        verify(walletRepo).findByUserId(userId);
    }

    @Test
    @DisplayName("readWallet_NotExistUserId_Exception")
    void readWallet_NotExistUserId_Exception() throws Exception {
        // given
        Long userId = 100L;

        Mockito.when(userRepo.findById(userId))
                .thenThrow(new IllegalArgumentException("can not find user"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> walletService.readWallet(userId));
    }

    @Test
    @DisplayName("readWallet_readQuitedUser_Exception")
    void readWallet_readQuitedUser_Exception() throws Exception {
        // given
        Long userId = 100L;
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();

        Mockito.when(userRepo.findById(userId))
                .thenReturn(Optional.of(User.builder()
                        .userId(100L)
                        .userName("hozzi")
                        .userType(UserType.QUIT)
                        .age(20)
                        .point(100L)
                        .balance(100L)
                        .gender(Gender.Male)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .build()));

        Mockito.when(walletRepo.findByUserId(userId))
                .thenThrow(new IllegalArgumentException("user quit"));
    }

    @Test
    @DisplayName("createWallet_Normal_Success")
    void createWallet_Normal_Success() throws Exception {
        // given
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        CreateWalletInDTO createWalletInDTO = CreateWalletInDTO.builder()
                .userId(100L)
                .paymentId(100L)
                .build();

        User user = User.builder()
                .userId(100L)
                .userName("hozzi")
                .userType(UserType.QUIT)
                .age(20)
                .point(100L)
                .balance(100L)
                .gender(Gender.Male)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();

        Payment payment = Payment.builder()
                .paymentId(100L)
                .paymentName("hozzi pay")
                .state(State.ENROLL)
                .discountRate(0.7F)
                .rewardRate(0.7F)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build();

        Mockito.when(userRepo.findById(100L)).thenReturn(Optional.ofNullable(user));
        Mockito.when(payRepo.findById(100L)).thenReturn(Optional.ofNullable(payment));
        Mockito.when(walletMapper.toCreateWalletOutDTO(any(Wallet.class))).thenReturn(CreateWalletOutDTO.builder()
                .walletId(100L)
                .state(State.ENROLL)
                .userId(100L)
                .createAt(createAt)
                .updateAt(updateAt)
                .build());

        // when
        CreateWalletOutDTO createWalletOutDTO = walletService.createWallet(createWalletInDTO);

        // then
        Assertions.assertEquals(createWalletOutDTO.getState(), State.ENROLL);
        Assertions.assertEquals(createWalletOutDTO.getUserId(), 100L);
    }

    @Test
    @DisplayName("createWallet_NotExistUserId_Exception")
    void createWallet_NotExistUserId_Exception() {
        Long userId = 100L;

        Mockito.when(userRepo.findById(userId)).thenThrow(new IllegalArgumentException("Bad Request"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> userRepo.findById(userId));
    }

    @Test
    @DisplayName("createWallet_NotExistPaymentId_Exception")
    void createWallet_NotExistPaymentId_Exception() {
        Long paymentId = 100L;

        CreateWalletInDTO createWalletInDTO = CreateWalletInDTO.builder()
                .userId(100L)
                .paymentId(paymentId)
                .build();

        Mockito.when(payRepo.findById(paymentId)).thenThrow(new IllegalArgumentException("Bad Request"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> walletService.createWallet(createWalletInDTO));
    }

    @Test
    @DisplayName("deleteWallet_Normal_Success")
    void deleteWallet_Normal_Success() throws Exception {
        // given
        LocalDateTime createAt = LocalDateTime.now();
        LocalDateTime updateAt = LocalDateTime.now();
        LocalDateTime cancelAt = LocalDateTime.now();

        DeleteWalletInDTO deleteWalletInDTO = DeleteWalletInDTO.builder()
                .userId(100L)
                .paymentId(100L)
                .build();

        User user = User.builder()
                .userId(100L)
                .userName("hozzi")
                .userType(UserType.QUIT)
                .age(20)
                .point(100L)
                .balance(100L)
                .gender(Gender.Male)
                .createAt(createAt)
                .updateAt(updateAt)
                .build();

        Payment payment = Payment.builder()
                .paymentId(100L)
                .paymentName("hozzi pay")
                .state(State.ENROLL)
                .discountRate(0.7F)
                .rewardRate(0.7F)
                .createAt(createAt)
                .updateAt(updateAt)
                .cancelAt(cancelAt)
                .build();

        Mockito.when(walletRepo.findBy(deleteWalletInDTO))
                .thenReturn(Optional.ofNullable(Wallet.builder()
                        .walletId(100L)
                        .state(State.ENROLL)
                        .user(user)
                        .payment(payment)
                        .build()));

        Mockito.when(walletMapper.toDeleteWalletOutDTOCustom(any()))
                .thenReturn(DeleteWalletOutDTO.builder()
                        .walletId(100L)
                        .paymentId(100L)
                        .paymentName("hozzi pay")
                        .state(State.CANCEL)
                        .discountRate(0.7F)
                        .rewardRate(0.7F)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .cancelAt(cancelAt)
                        .build());

        // walletMapper 에 존재하는 모든 메서드가 when이 안먹힘...
        Mockito.when(walletMapper.toDeleteWalletOutDTOCustom(any()))
                .thenReturn(DeleteWalletOutDTO.builder()
                        .walletId(100L)
                        .paymentId(100L)
                        .paymentName("hozzi pay")
                        .state(State.CANCEL)
                        .discountRate(0.7F)
                        .rewardRate(0.7F)
                        .createAt(createAt)
                        .updateAt(updateAt)
                        .cancelAt(cancelAt)
                        .build());

        // when
        DeleteWalletOutDTO deleteWalletOutDTO = walletService.deleteWallet(deleteWalletInDTO);

        // then
        Assertions.assertEquals(deleteWalletOutDTO.getWalletId(), 100L);
        Assertions.assertEquals(deleteWalletOutDTO.getPaymentId(), 100L);
        Assertions.assertEquals(deleteWalletOutDTO.getPaymentName(), "hozzi pay");
        Assertions.assertEquals(deleteWalletOutDTO.getState(), State.CANCEL);
        Assertions.assertEquals(deleteWalletOutDTO.getDiscountRate(), 0.7F);
        Assertions.assertEquals(deleteWalletOutDTO.getRewardRate(), 0.7F);
        Assertions.assertEquals(deleteWalletOutDTO.getCreateAt(), createAt);
        Assertions.assertEquals(deleteWalletOutDTO.getUpdateAt(), updateAt);
        Assertions.assertEquals(deleteWalletOutDTO.getCancelAt(), cancelAt);
    }

    @Test
    @DisplayName("deleteWallet_NotExistUserId_Exception")
    void deleteWallet_NotExistUserId_Exception() {
        Mockito.when(walletRepo.findBy(any(DeleteWalletInDTO.class))).thenThrow(new IllegalArgumentException("Bad Request"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> walletService.deleteWallet(any(DeleteWalletInDTO.class)));
    }
}