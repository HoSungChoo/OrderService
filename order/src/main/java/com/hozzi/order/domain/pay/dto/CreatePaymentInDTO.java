package com.hozzi.order.domain.pay.dto;

import com.hozzi.order.global.enumerate.State;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePaymentInDTO {
    private String paymentName;
    private State state;
    private Float discountRate;
    private Float rewardRate;
}
