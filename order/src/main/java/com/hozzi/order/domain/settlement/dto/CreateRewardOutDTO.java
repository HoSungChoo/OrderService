package com.hozzi.order.domain.settlement.dto;

import com.hozzi.order.domain.settlement.enumerate.SettlementType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRewardOutDTO {
    private Long settlementId;
    private Long balance;
    private SettlementType settlementType;
    private Long userId;
    private Long orderId;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
