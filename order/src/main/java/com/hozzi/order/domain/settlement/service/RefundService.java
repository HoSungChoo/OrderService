package com.hozzi.order.domain.settlement.service;

import com.hozzi.order.domain.settlement.dto.CreateRefundInDTO;
import com.hozzi.order.domain.settlement.dto.CreateRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.ReadRefundOutDTOs;
import org.springframework.web.bind.annotation.RequestBody;

public interface RefundService {
    CreateRefundOutDTO createRefund(@RequestBody CreateRefundInDTO createRefundInDTO);
    ReadRefundOutDTOs readRefund(String beginDate, String endDate);
}
