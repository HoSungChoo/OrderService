package com.hozzi.order.domain.user.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class CreateBasketInDTO {
    private Long userId;
    private Long storeId;
    private Long menuId;
    private Integer amount;
}
