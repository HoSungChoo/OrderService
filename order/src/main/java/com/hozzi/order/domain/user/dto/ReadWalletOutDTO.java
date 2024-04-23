package com.hozzi.order.domain.user.dto;

import com.hozzi.order.global.enumerate.State;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadWalletOutDTO {
    private Long walletId;
    private State state;
    private Long paymentId;
    private String paymentName;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
