package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.pay.repo.PayRepo;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import com.hozzi.order.domain.user.service.impl.WalletServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class WalletServiceTest {
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private WalletRepo walletRepo = Mockito.mock(WalletRepo.class);
    private PayRepo payRepo = Mockito.mock(PayRepo.class);
    private WalletServiceImpl walletService;
    @BeforeEach
    public void setUpTest(){
        walletService = new WalletServiceImpl(userRepo, walletRepo, payRepo);
    }
    @Test
    @DisplayName("")
    void readWallet_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void readWallet_NotExistUserId_Exception() {
    }
    @Test
    @DisplayName("")
    void readWallet_readQuitedUser_Success() {
    }
    @Test
    @DisplayName("")
    void createWallet_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void createWallet() {
    }
    @Test
    @DisplayName("")
    void deleteWallet_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void deleteWallet_NotExistUserId_Exception() {
    }
}