package com.hozzi.order.domain.order.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderInDTO {
    private Long walletId;
    private Long storeId;
    private Long menuId;
    private Integer amount;
}
