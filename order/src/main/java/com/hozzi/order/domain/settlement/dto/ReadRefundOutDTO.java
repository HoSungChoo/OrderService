package com.hozzi.order.domain.settlement.dto;

import com.hozzi.order.domain.settlement.enumerate.RefundType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadRefundOutDTO {
    Long refundId;
    Long customBalance;
    Long ownerBalance;
    RefundType refundType;
    String refundReason;
    Long customId;
    Long ownerId;
    Long orderId;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
