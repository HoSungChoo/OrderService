package com.hozzi.order.domain.user.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadBasketOutDTOs {
    private List<ReadBasketOutDTO> baskets;
}
