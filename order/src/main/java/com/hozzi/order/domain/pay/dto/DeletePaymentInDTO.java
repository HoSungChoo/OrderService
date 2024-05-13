package com.hozzi.order.domain.pay.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class DeletePaymentInDTO {
    private Long paymentId;
}
