package com.hozzi.order.domain.settlement.service;

import com.hozzi.order.domain.settlement.dto.*;
import org.springframework.web.bind.annotation.RequestBody;

public interface SettlementService {
    CreateRewardOutDTO createReward(@RequestBody CreateRewardInDTO createRewardInDTO);
    CreatePayoutOutDTO createPayout(@RequestBody CreatePayoutInDTO createPayoutInDTO);
    CreateRefundOutDTO createReward(@RequestBody CreateRefundInDTO createRefundInDTO);
}
