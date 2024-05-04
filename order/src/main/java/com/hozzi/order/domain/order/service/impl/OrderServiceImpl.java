package com.hozzi.order.domain.order.service.impl;

import com.hozzi.order.domain.order.dto.*;
import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.order.repo.OrderManageRepo;
import com.hozzi.order.domain.order.repo.OrderRepo;
import com.hozzi.order.domain.order.service.OrderService;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderManageRepo orderManageRepo;
    private final WalletRepo walletRepo;
    private final StoreRepo storeRepo;

    public OrderServiceImpl(OrderRepo orderRepo, OrderManageRepo orderManageRepo, WalletRepo walletRepo, StoreRepo storeRepo) {
        this.orderRepo = orderRepo;
        this.orderManageRepo = orderManageRepo;
        this.walletRepo = walletRepo;
        this.storeRepo = storeRepo;
    }

    @Override
    public ReadOrderManageOutDTOs readOrderManage(Long orderId) {
        List<ReadOrderManageOutDTO> readOrderManageOutDTOs = orderManageRepo.findAllByCustom(orderId).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadOrderManageOutDTOs.builder().orderManage(readOrderManageOutDTOs).build();
    }

    @Override
    public CreateOrderOutDTO createOrder(CreateOrderInDTO createOrderInDTO) {
        Order order = Order.builder()
                .balance()
                .reward()
                .wallet(walletRepo.findById(createOrderInDTO.getWalletId()))
                .store(storeRepo.findById(createOrderInDTO.getStoreId()))
                .menu()
                .build();

    }

    @Override
    public CreateOrderUsingBasketOutDTO createOrderUsingBasket(CreateOrderUsingBasketInDTO createOrderUsingBasketInDTO) {
        return null;
    }

    @Override
    public UpdateOrderByCustomOutDTO updateOrder(UpdateOrderByCustomInDTO updateOrderByCustomInDTO) {
        return null;
    }

    @Override
    public UpdateOrderByOwnerOutDTO updateOrder(UpdateOrderByOwnerInDTO updateOrderByOwnerInDTO) {
        return null;
    }

    @Override
    public UpdateOrderByAdminOutDTO updateOrder(UpdateOrderByAdminInDTO updateOrderByAdminInDTO) {
        return null;
    }
}
