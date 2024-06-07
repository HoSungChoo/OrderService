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
    private Long refundId;
    private Long customBalance;
    private Long ownerBalance;
    private RefundType refundType;
    private String refundReason;
    private Long customId;
    private Long ownerId;
    private Long orderId;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
