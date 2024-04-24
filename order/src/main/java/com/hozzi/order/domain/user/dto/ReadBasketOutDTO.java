package com.hozzi.order.domain.user.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadBasketOutDTO {
    private Long basketId;
    private Long userId;
    private Long storeId;
    private Long menuId;
    private Integer amount;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
