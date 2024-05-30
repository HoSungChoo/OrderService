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
    @DisplayName("readWallet_Normal_Success")
    void readWallet_Normal_Success() {

    }
    @Test
    @DisplayName("readWallet_NotExistUserId_Exception")
    void readWallet_NotExistUserId_Exception() {
    }
    @Test
    @DisplayName("readWallet_readQuitedUser_Success")
    void readWallet_readQuitedUser_Success() {
    }
    @Test
    @DisplayName("createWallet_Normal_Success")
    void createWallet_Normal_Success() {
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