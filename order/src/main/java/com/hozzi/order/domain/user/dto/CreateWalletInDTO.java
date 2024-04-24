package com.hozzi.order.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateWalletInDTO {
    private Long userId;
    private Long paymentId;
}
