package com.hozzi.order.domain.order.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderUsingBasketOutDTOs {
    List<CreateOrderOutDTO> results;
}
