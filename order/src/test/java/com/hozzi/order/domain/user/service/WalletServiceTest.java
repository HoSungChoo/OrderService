package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.pay.entity.Payment;
import com.hozzi.order.domain.pay.repo.PayRepo;
import com.hozzi.order.domain.user.dto.CreateWalletInDTO;
import com.hozzi.order.domain.user.dto.CreateWalletOutDTO;
import com.hozzi.order.domain.user.dto.ReadWalletOutDTO;
import com.hozzi.order.domain.user.dto.ReadWalletOutDTOs;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.entity.Wallet;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.mapper.WalletMapper;
import com.hozzi.order.domain.user.mapper.WalletMapperImpl;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import com.hozzi.order.domain.user.service.impl.WalletServiceImpl;
import com.hozzi.order.global.enumerate.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.BDDMockito.given;

import java.awt.color.ICC_Profile;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class WalletServiceTest {
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private WalletRepo walletRepo = Mockito.mock(WalletRepo.class);
    private PayRepo payRepo = Mockito.mock(PayRepo.class);

    @InjectMocks
    private WalletMapper walletMapper = Mockito.mock(WalletMapper.class);

    private WalletServiceImpl walletService;

    @BeforeEach
    public void setUpTest() {
        walletService = new WalletServiceImpl(userRepo, walletRepo, payRepo);
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
    @DisplayName("readWallet_readQuitedUser_Success")
    void readWallet_readQuitedUser_Success() throws Exception {
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

        Wallet wallet = Wallet.builder()
                .walletId(100L)
                .state(State.ENROLL)
                .user(user)
                .payment(payment)
                .build();

        Mockito.when(walletRepo.save(wallet)).thenReturn(wallet);
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
    @DisplayName("createWallet")
    void createWallet() {
    }

    @Test
    @DisplayName("deleteWallet_Normal_Success")
    void deleteWallet_Normal_Success() {
    }

    @Test
    @DisplayName("deleteWallet_NotExistUserId_Exception")
    void deleteWallet_NotExistUserId_Exception() {
    }
}