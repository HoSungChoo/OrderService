package com.hozzi.order.domain.order.api;

import com.hozzi.order.domain.order.dto.*;
import com.hozzi.order.domain.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
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
    //@Operation(summary = "", description = "")
    @Operation(summary = "주문 진행상황 조회", description = "주문별 진행상황을 조회한다.")
    private ResponseEntity<ReadOrderManageOutDTOs> readOrderManage(@PathVariable Long orderId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadOrderManageOutDTOs());
    }
    @PostMapping()
    @Operation(summary = "고객 직접 주문", description = "사용자(고객)는 특정 가게 메뉴와 수량을 직접 주문한다.")
    private ResponseEntity<CreateOrderOutDTO> createOrder(@RequestBody CreateOrderInDTO createOrderInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateOrderOutDTO());
    }
    @PostMapping("/item")
    @Operation(summary = "고객 장바구니 주문", description = "사용자(고객)는 장바구니에 존재하는 메뉴를 주문한다.")
    private ResponseEntity<CreateOrderUsingBasketOutDTOs> createOrderUsingBasket(@RequestBody CreateOrderUsingBasketInDTO createOrderUsingBasketInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateOrderUsingBasketOutDTOs());
    }
    @PutMapping("/custom")
    @Operation(summary = "고객 주문 변경", description = "사용자(고객)는 주문을 전체 취소한다. “신청”상태에서만 가능하다.")
    private ResponseEntity<UpdateOrderByCustomOutDTO> updateOrder(@RequestBody UpdateOrderByCustomInDTO updateOrderByCustomInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new UpdateOrderByCustomOutDTO());
    }
    @PostMapping("/owner")
    @Operation(summary = "점주 주문 변경", description = "사용자(점주)는 주문 상태를 변경한다.")
    private ResponseEntity<UpdateOrderByOwnerOutDTO> updateOrder(@RequestBody UpdateOrderByOwnerInDTO updateOrderByOwnerInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new UpdateOrderByOwnerOutDTO());
    }
    @PostMapping("/admin")
    @Operation(summary = "관리자 주문 변경", description = "사용자(관리자)는 주문 상태를 취소한다.")
    private ResponseEntity<UpdateOrderByAdminOutDTO> updateOrder(@RequestBody UpdateOrderByAdminInDTO updateOrderByAdminInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new UpdateOrderByAdminOutDTO());
    }
}
