package com.hozzi.order.domain.settlement.api;

import com.hozzi.order.domain.settlement.dto.*;
import com.hozzi.order.domain.settlement.service.SettlementService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/settlement")
public class SettlementController {
    private final SettlementService settlementService;
    public SettlementController(SettlementService settlementService) {
        this.settlementService = settlementService;
    }

    @PostMapping("/reward")
    @Operation(summary = "적립금 추가", description = "주문을 기반으로 적립금을 기록한다.")
    private ResponseEntity<CreateRewardOutDTO> createReward(@RequestBody CreateRewardInDTO createRewardInDTO){
        settlementService.createReward(createRewardInDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new CreateRewardOutDTO());
    }
    @PostMapping("/payout")
    @Operation(summary = "지급금 추가", description = "주문을 기반으로 지급금을 기록한다.")
    private ResponseEntity<CreatePayoutOutDTO> createPayout(@RequestBody CreatePayoutInDTO createPayoutInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreatePayoutOutDTO());
    }
    @PostMapping("/refund")
    @Operation(summary = "환불금 추가", description = "주문을 기반으로 환불금을 기록한다.")
    private ResponseEntity<CreateRefundOutDTO> createReward(@RequestBody CreateRefundInDTO createRefundInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateRefundOutDTO());
    }
    @GetMapping("/reward")
    @Operation(summary = "적립금 확인", description = "기간별 적립금을 확인한다. 관리자만 확인 가능하다.")
    private ResponseEntity<ReadSettlementOutDTOs> readReward(@PathVariable("beginDate") String beginDate, @PathVariable("endDate") String endDate){
        return null;
    }
    @GetMapping("/payout")
    @Operation(summary = "지급금 확인", description = "기간별 적립금을 확인한다. 관리자만 확인 가능하다.")
    private ResponseEntity<ReadSettlementOutDTOs> readPayout(@PathVariable("beginDate") String beginDate, @PathVariable("endDate") String endDate){
        return null;
    }
    @GetMapping("/refund")
    @Operation(summary = "환불금 확인", description = "기간별 환불금을 확인한다. 관리자만 확인 가능하다.")
    private ResponseEntity<ReadRefundOutDTOs> readRefund(@PathVariable("beginDate") String beginDate, @PathVariable("endDate") String endDate){
        return null;
    }
}
