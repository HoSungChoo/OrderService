package com.hozzi.order.domain.settlement.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadSettlementOutDTO {
    private Long settlementId;
    private Long userId;
    private Long orderId;
    private Long balance;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
