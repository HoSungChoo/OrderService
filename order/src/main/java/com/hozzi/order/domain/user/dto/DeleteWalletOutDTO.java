package com.hozzi.order.domain.user.dto;

import com.hozzi.order.global.enumerate.State;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteWalletOutDTO {
    private Long walletId;
    private Long paymentId;
    private String paymentName;
    private State state;
    private Float discountRate;
    private Float rewardRate;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime cancelAt;
}
