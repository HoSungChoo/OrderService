package com.hozzi.order.domain.order.dto;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderUsingBasketOutDTO {
    private Long orderId;
    private Long balance;
    private Long reward;
    private LocalDateTime createAt;
}
