package com.hozzi.order.domain.settlement.repo.custom;

import com.hozzi.order.domain.settlement.dto.ReadSettlementOutDTO;
import com.hozzi.order.domain.settlement.enumerate.SettlementType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CustomSettlementRepo {
    Optional<List<ReadSettlementOutDTO>> findAllBetweenDate(LocalDateTime beginDateTime, LocalDateTime endDateTime, SettlementType settlementType);

}
