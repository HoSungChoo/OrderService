package com.hozzi.order.domain.settlement.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadSettlementOutDTOs {
    List<ReadSettlementOutDTO> settlements;
}
