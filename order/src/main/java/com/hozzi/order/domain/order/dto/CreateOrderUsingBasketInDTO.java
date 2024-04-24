package com.hozzi.order.domain.order.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderUsingBasketInDTO {
    private Long userId;
    private Long storeId;
    private Long menuId;
    private Integer amount;
}
