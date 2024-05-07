package com.hozzi.order.domain.pay.api;

import com.hozzi.order.domain.pay.dto.*;
import com.hozzi.order.domain.pay.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "PayController", description = "결제수단 API")
@RestController
@RequestMapping(value = "/pay")
public class PayController {
    private final PayService payService;
    public PayController(PayService payService) {
        this.payService = payService;
    }

    @GetMapping()
    @Operation(summary = "결제수단 전체 조회", description = "결제수단을 추가할 수 있다.")
    public ResponseEntity<ReadPaymentOutDTOs> readPayments(){
        return ResponseEntity.status(HttpStatus.OK).body(payService.readPayments());
    }
    @GetMapping("/id/{paymentId}")
    @Operation(summary = "특정 결제수단 조회", description = "결제수단을 추가할 수 있다.")
    public ResponseEntity<ReadPaymentOutDTO> readPayment(@PathVariable Long paymentId){
        return ResponseEntity.status(HttpStatus.OK).body(payService.readPayment(paymentId));
    }
    @PostMapping()
    @Operation(summary = "결제수단 추가", description = "결제수단을 추가할 수 있다.")
    public ResponseEntity<CreatePaymentOutDTO> createPayment(@RequestBody CreatePaymentInDTO createPaymentInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(payService.createPayment(createPaymentInDTO));
    }
    @PutMapping()
    @Operation(summary = "결제수단 해지", description = "결제수단을 해지할 수 있다.")
    public ResponseEntity<DeletePaymentOutDTO> deletePayment(@RequestBody DeletePaymentInDTO deletePaymentInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(payService.deletePayment(deletePaymentInDTO));
    }
}
