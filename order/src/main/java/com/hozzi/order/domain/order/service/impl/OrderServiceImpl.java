package com.hozzi.order.domain.order.service.impl;

import com.hozzi.order.domain.option.repo.OptionRepo;
import com.hozzi.order.domain.order.dto.*;
import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.order.entity.OrderManage;
import com.hozzi.order.domain.order.enumerate.OmType;
import com.hozzi.order.domain.order.mapper.OrderManageMapper;
import com.hozzi.order.domain.order.mapper.OrderMapper;
import com.hozzi.order.domain.order.repo.OrderManageRepo;
import com.hozzi.order.domain.order.repo.OrderRepo;
import com.hozzi.order.domain.order.service.OrderService;
import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.repo.BasketRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderManageRepo orderManageRepo;
    private final WalletRepo walletRepo;
    private final StoreRepo storeRepo;
    private final MenuRepo menuRepo;
    private final OptionRepo optionRepo;
    private final BasketRepo basketRepo;

    public OrderServiceImpl(OrderRepo orderRepo, OrderManageRepo orderManageRepo, WalletRepo walletRepo, StoreRepo storeRepo, MenuRepo menuRepo, OptionRepo optionRepo, BasketRepo basketRepo) {
        this.orderRepo = orderRepo;
        this.orderManageRepo = orderManageRepo;
        this.walletRepo = walletRepo;
        this.storeRepo = storeRepo;
        this.menuRepo = menuRepo;
        this.optionRepo = optionRepo;
        this.basketRepo = basketRepo;
    }

    @Override
    public ReadOrderManageOutDTOs readOrderManage(Long orderId) {
        List<ReadOrderManageOutDTO> readOrderManageOutDTOs = orderManageRepo.findAllByCustom(orderId).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadOrderManageOutDTOs.builder().orderManage(readOrderManageOutDTOs).build();
    }

    @Override
    public CreateOrderOutDTO createOrder(CreateOrderInDTO createOrderInDTO) {
        Menu menu = menuRepo.findById(createOrderInDTO.getMenuId()).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        // create order
        Order order = Order.builder()
                .balance(menu.getMenuPrice() * createOrderInDTO.getAmount())
                .reward((long)Math.ceil((menu.getMenuPrice() * createOrderInDTO.getAmount()) * optionRepo.findByOptionName("REWARD").orElseThrow(()->new IllegalArgumentException("Bad Request")).getValue()))
                .amount(createOrderInDTO.getAmount())
                .wallet(walletRepo.findById(createOrderInDTO.getWalletId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .store(storeRepo.findById(createOrderInDTO.getStoreId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .menu(menuRepo.findById(createOrderInDTO.getMenuId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .build();

        orderRepo.save(order);

        // create orderManage
        OrderManage orderManage = OrderManage.builder()
                .omType(OmType.ORDER)
                .order(orderRepo.findById(order.getOrderId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .build();

        orderManageRepo.save(orderManage);

        return OrderMapper.orderMapper.toCreateOrderOutDTO(order);
    }

    @Override
    public CreateOrderUsingBasketOutDTOs createOrderUsingBasket(CreateOrderUsingBasketInDTO createOrderUsingBasketInDTO) {
        List<Basket> baskets = basketRepo.findByUserId(createOrderUsingBasketInDTO.getUserId()).orElseThrow(()->new IllegalArgumentException("Bad Request"));
        List<CreateOrderOutDTO> createOrderOutDTOS = new ArrayList<>();

        for (Basket basket : baskets){
            CreateOrderInDTO createOrderInDTO = CreateOrderInDTO.builder()
                    .walletId(createOrderUsingBasketInDTO.getWalletId())
                    .storeId(basket.getStore().getStoreId())
                    .menuId(basket.getMenu().getMenuId())
                    .amount(basket.getAmount())
                    .build();

            createOrderOutDTOS.add(this.createOrder(createOrderInDTO));
        }

        return CreateOrderUsingBasketOutDTOs.builder().results(createOrderOutDTOS).build();
    }

    @Override
    public UpdateOrderByCustomOutDTO updateOrder(UpdateOrderByCustomInDTO updateOrderByCustomInDTO) {
        List<OrderManage> orderManages = orderManageRepo.findAllByOrderId(updateOrderByCustomInDTO.getOrderId()).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        if (orderManages.size() != 1)
            throw new IllegalArgumentException("Bad Request");

        OrderManage orderManage = OrderManage.builder()
                .omType(OmType.CANCEL)
                .order(orderRepo.findById(updateOrderByCustomInDTO.getOrderId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .build();

        orderManageRepo.save(orderManage);

        return OrderManageMapper.orderManageMapper.toUpdateOrderByCustomOutDTO(orderManage);
    }

    @Override
    public UpdateOrderByOwnerOutDTO updateOrder(UpdateOrderByOwnerInDTO updateOrderByOwnerInDTO) {
        List<OrderManage> orderManages = orderManageRepo.findAllByOrderId(updateOrderByOwnerInDTO.getOrderId()).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        if (orderManages.size() != 2)
            throw new IllegalArgumentException("Bad Request");

        if (!(updateOrderByOwnerInDTO.getOmType().equals(OmType.PREPARE) || updateOrderByOwnerInDTO.getOmType().equals(OmType.CANCEL)))
            throw new IllegalArgumentException("Bad Request");

        OrderManage orderManage = OrderManage.builder()
                .omType(updateOrderByOwnerInDTO.getOmType())
                .order(orderRepo.findById(updateOrderByOwnerInDTO.getOrderId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .build();

        orderManageRepo.save(orderManage);

        return OrderManageMapper.orderManageMapper.toUpdateOrderByOwnerOutDTO(orderManage);
    }

    @Override
    public UpdateOrderByAdminOutDTO updateOrder(UpdateOrderByAdminInDTO updateOrderByAdminInDTO) {
        if (!updateOrderByAdminInDTO.getOmType().equals(OmType.CANCEL))
            throw new IllegalArgumentException("Bad Request");

        OrderManage orderManage = OrderManage.builder()
                .omType(updateOrderByAdminInDTO.getOmType())
                .order(orderRepo.findById(updateOrderByAdminInDTO.getOrderId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .build();

        orderManageRepo.save(orderManage);

        return OrderManageMapper.orderManageMapper.toUpdateOrderByAdminOutDTO(orderManage);
    }
}
