package com.hozzi.order.domain.settlement.dto;

import com.hozzi.order.domain.settlement.enumerate.RefundType;
import com.hozzi.order.domain.settlement.enumerate.SettlementType;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRefundOutDTO {
    private Long refundId;
    private Long orderId;
    private Long customId;
    private Long ownerId;
    private Long customBalance;
    private Long ownerBalance;
    private RefundType refundType;
    private String refundReason;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
