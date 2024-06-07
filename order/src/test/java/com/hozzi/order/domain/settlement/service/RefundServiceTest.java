package com.hozzi.order.domain.settlement.service;

import com.hozzi.order.domain.order.repo.OrderRepo;
import com.hozzi.order.domain.settlement.mapper.RefundMapper;
import com.hozzi.order.domain.settlement.repo.RefundRepo;
import com.hozzi.order.domain.settlement.service.impl.RefundServiceImpl;
import com.hozzi.order.domain.user.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RefundServiceTest {
    RefundService refundService;
    private RefundRepo refundRepo = Mockito.mock(RefundRepo.class);
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private OrderRepo orderRepo = Mockito.mock(OrderRepo.class);
    private RefundMapper refundMapper = Mockito.mock(RefundMapper.class);
    @BeforeEach
    void SetUpTest(){
        refundService = new RefundServiceImpl(refundRepo, userRepo, orderRepo, refundMapper);
    }
    @Test
    @DisplayName("createRefund_Normal_Success")
    void createRefund_Normal_Success() {
    }
    @Test
    @DisplayName("createRefund_NotExistCustomId_Exception")
    void createRefund_NotExistCustomId_Exception() {
    }
    @Test
    @DisplayName("createRefund_NotExistOwnerId_Exception")
    void createRefund_NotExistOwnerId_Exception() {
    }
    @Test
    @DisplayName("createRefund_NotExistOrderId_Exception")
    void createRefund_NotExistOrderId_Exception() {
    }
    @Test
    @DisplayName("readRefund_Normal_Success")
    void readRefund_Normal_Success() {
    }
    @Test
    @DisplayName("readRefund_NotExistRefundData_Exception")
    void readRefund_NotExistRefundData_Exception() {
    }
}