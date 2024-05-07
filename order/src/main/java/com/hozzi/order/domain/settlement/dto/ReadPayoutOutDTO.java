package com.hozzi.order.domain.settlement.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadPayoutOutDTO {
    Long settlementId;
    Long userId;
    Long orderId;
    Long balance;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
