package com.hozzi.order.domain.settlement.repo.custom;

import com.hozzi.order.domain.settlement.dto.ReadRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.ReadSettlementOutDTO;
import com.hozzi.order.domain.settlement.enumerate.SettlementType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CustomRefundRepo {
    Optional<List<ReadRefundOutDTO>> findAllBetweenDate(LocalDateTime beginDateTime, LocalDateTime endDateTime);
}
