package com.hozzi.order.domain.order.api;

import com.hozzi.order.domain.order.dto.*;
import com.hozzi.order.domain.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/{orderId}")
    private ResponseEntity<ReadOrderManageOutDTOs> readOrderManage(@PathVariable Long orderId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadOrderManageOutDTOs());
    }
    @PostMapping()
    private ResponseEntity<CreateOrderOutDTO> createOrder(@RequestBody CreateOrderInDTO createOrderInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateOrderOutDTO());
    }
    @PostMapping("/item")
    private ResponseEntity<CreateOrderUsingBasketOutDTO> createOrderUsingBasket(@RequestBody CreateOrderUsingBasketInDTO createOrderUsingBasketInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateOrderUsingBasketOutDTO());
    }
    @PutMapping("/custom")
    private ResponseEntity<HttpStatus> updateOrder(@RequestBody UpdateOrderByCustomInDTO updateOrderByCustomInDTO){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/owner")
    private ResponseEntity<HttpStatus> updateOrder(@RequestBody UpdateOrderByOwnerInDTO updateOrderByOwnerInDTO){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/admin")
    private ResponseEntity<HttpStatus> updateOrder(@RequestBody UpdateOrderByAdminInDTO updateOrderByAdminInDTO){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
