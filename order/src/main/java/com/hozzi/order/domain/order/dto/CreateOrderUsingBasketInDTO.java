package com.hozzi.order.domain.order.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CreateOrderUsingBasketInDTO {
    private Long userId;
    private Long walletId;
}
