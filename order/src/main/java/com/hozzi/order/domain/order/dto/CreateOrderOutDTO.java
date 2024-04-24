package com.hozzi.order.domain.order.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderOutDTO {
    private Long orderId;
    private Long balance;
    private Long reward;
    private LocalDateTime createAt;
}