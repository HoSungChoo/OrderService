package com.hozzi.order.domain.settlement.service;

import com.hozzi.order.domain.settlement.dto.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SettlementService {
    CreateRewardOutDTO createReward(@RequestBody CreateRewardInDTO createRewardInDTO);
    CreatePayoutOutDTO createPayout(@RequestBody CreatePayoutInDTO createPayoutInDTO);
    ReadSettlementOutDTOs readReward(String beginDate, String endDate);
    ReadSettlementOutDTOs readPayout(String beginDate, String endDate);
}
