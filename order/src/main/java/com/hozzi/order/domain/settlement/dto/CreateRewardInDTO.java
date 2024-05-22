package com.hozzi.order.domain.settlement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CreateRewardInDTO {
    private Long orderId;
    private Long userId;
    private Long balance;
}
