package com.hozzi.order.domain.order.service;

import com.hozzi.order.domain.order.dto.*;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderService{
    ReadOrderManageOutDTOs readOrderManage(Long orderId);
    CreateOrderOutDTO createOrder(CreateOrderInDTO createOrderInDTO);
    CreateOrderUsingBasketOutDTOs createOrderUsingBasket(CreateOrderUsingBasketInDTO createOrderUsingBasketInDTO);
    UpdateOrderByCustomOutDTO updateOrder(@RequestBody UpdateOrderByCustomInDTO updateOrderByCustomInDTO);
    UpdateOrderByOwnerOutDTO updateOrder(@RequestBody UpdateOrderByOwnerInDTO updateOrderByOwnerInDTO);
    UpdateOrderByAdminOutDTO updateOrder(@RequestBody UpdateOrderByAdminInDTO updateOrderByAdminInDTO);
}
