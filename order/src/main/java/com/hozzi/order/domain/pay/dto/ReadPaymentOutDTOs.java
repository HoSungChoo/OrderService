package com.hozzi.order.domain.pay.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadPaymentOutDTOs {
    List<ReadPaymentOutDTO> payments;
}
