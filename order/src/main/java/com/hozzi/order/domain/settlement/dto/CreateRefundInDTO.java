package com.hozzi.order.domain.settlement.dto;

import com.hozzi.order.domain.settlement.enumerate.RefundType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateRefundInDTO {
    private Long orderId;
    private Long customId;
    private Long ownerId;
    private RefundType refundType;
    private Long customBalance;
    private Long ownerBalance;
    private String refundReason;
}
