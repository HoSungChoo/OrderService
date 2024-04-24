package com.hozzi.order.domain.settlement.api;

import com.hozzi.order.domain.settlement.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/settlement")
public class SettlementController {
    @PostMapping("/reward")
    private ResponseEntity<CreateRewardOutDTO> createReward(@RequestBody CreateRewardInDTO createRewardInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateRewardOutDTO());
    }
    @PostMapping("/payout")
    private ResponseEntity<CreatePayoutOutDTO> createPayout(@RequestBody CreatePayoutInDTO createPayoutInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreatePayoutOutDTO());
    }
    @PostMapping("/refund")
    private ResponseEntity<CreateRefundOutDTO> createReward(@RequestBody CreateRefundInDTO createRefundInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateRefundOutDTO());
    }
}
