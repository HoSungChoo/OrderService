package com.hozzi.order.domain.order.service;

import com.hozzi.order.domain.option.repo.OptionRepo;
import com.hozzi.order.domain.order.mapper.OrderManageMapper;
import com.hozzi.order.domain.order.mapper.OrderMapper;
import com.hozzi.order.domain.order.repo.OrderManageRepo;
import com.hozzi.order.domain.order.repo.OrderRepo;
import com.hozzi.order.domain.order.service.impl.OrderServiceImpl;
import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.user.repo.BasketRepo;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrderServiceTest {
    OrderService orderService;
    private OrderRepo orderRepo = Mockito.mock(OrderRepo.class);
    private OrderManageRepo orderManageRepo = Mockito.mock(OrderManageRepo.class);
    private WalletRepo walletRepo = Mockito.mock(WalletRepo.class);
    private StoreRepo storeRepo = Mockito.mock(StoreRepo.class);
    private MenuRepo menuRepo = Mockito.mock(MenuRepo.class);
    private OptionRepo optionRepo = Mockito.mock(OptionRepo.class);
    private BasketRepo basketRepo = Mockito.mock(BasketRepo.class);
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private OrderMapper orderMapper = Mockito.mock(OrderMapper.class);
    private OrderManageMapper orderManageMapper = Mockito.mock(OrderManageMapper.class);
    @BeforeEach
    void setUpTest(){
        orderService = new OrderServiceImpl(orderRepo, orderManageRepo, walletRepo, storeRepo, menuRepo, optionRepo, basketRepo, userRepo, orderMapper, orderManageMapper);
    }
    @Test
    @DisplayName("")
    void readOrderManage_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void readOrderManage_Normal_Success2() {
    }
    @Test
    @DisplayName("")
    void readOrderManage_NotExistOrderId_Exception() {
    }
    @Test
    @DisplayName("")
    void createOrder_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void createOrder_NotExistOptionRewardInOrder_Exception() {
    }
    @Test
    @DisplayName("")
    void createOrder_NotExistWalletIdInOrder_Exception() {
    }
    @Test
    @DisplayName("")
    void createOrder_NotExistStoreIdInOrder_Exception() {
    }
    @Test
    @DisplayName("")
    void createOrder_NotExistMenuIdInOrder_Exception() {
    }
    @Test
    @DisplayName("")
    void createOrder_NotExistOrderIdInOrderManage_Exception() {
    }
    @Test
    @DisplayName("")
    void createOrder_NotExistWalletIdInOrderManage_Exception() {
    }
    @Test
    @DisplayName("")
    void createOrderUsingBasket_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void createOrderUsingBasket_NotExistUserId_Exception() {
    }
    @Test
    @DisplayName("")
    void updateOrderCustom_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void updateOrderCustom_NotExistOrderId_Exception() {
    }
    @Test
    @DisplayName("")
    void updateOrderCustom_CancelInAbnormalSituation_Exception() {
    }
    @Test
    @DisplayName("")
    void updateOrderCustom_NotExistOrderIdInOrderManage_Exception() {
    }
    @Test
    @DisplayName("")
    void updateOrderCustom_NotExistUserIdInOrderManage_Exception() {
    }
    @Test
    @DisplayName("")
    void UpdateOrderOwner_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void UpdateOrderOwner_NotExistOrderId_Exception() {
    }
    @Test
    @DisplayName("")
    void UpdateOrderOwner_CancelNotInOrderOrPrepareSituation_Exception() {
    }
    @Test
    @DisplayName("")
    void UpdateOrderOwner_CancelInPrepareAndCancel_Exception() {
    }
    @Test
    @DisplayName("")
    void UpdateOrderOwner_NotExistOrderIdInOrderManage_Exception() {
    }
    @Test
    @DisplayName("")
    void UpdateOrderOwner_NotExistUserIdInOrderManage_Exception() {
    }
    @Test
    @DisplayName("")
    void UpdateOrderAdmin_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void UpdateOrderAdmin_NotExistOrderIdInOrderManage_Exception() {
    }
    @Test
    @DisplayName("")
    void UpdateOrderAdmin_NotExistUserIdInOrderManage_Exception() {
    }
}