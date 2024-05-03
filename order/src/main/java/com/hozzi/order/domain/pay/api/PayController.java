package com.hozzi.order.domain.pay.api;

import com.hozzi.order.domain.pay.dto.*;
import com.hozzi.order.domain.pay.service.PayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pay")
public class PayController {
    private final PayService payService;
    public PayController(PayService payService) {
        this.payService = payService;
    }

    @GetMapping()
    public ResponseEntity<ReadPaymentOutDTOs> readPayments(){
        ReadPaymentOutDTOs readPaymentOutDTOs = payService.readPayments();

        return ResponseEntity.status(HttpStatus.OK).body(readPaymentOutDTOs);
    }
    @GetMapping("/id/{paymentId}")
    public ResponseEntity<ReadPaymentOutDTO> readPayment(@PathVariable Long paymentId){
        ReadPaymentOutDTO readPaymentOutDTO = payService.readPayment(paymentId);

        return ResponseEntity.status(HttpStatus.OK).body(readPaymentOutDTO);
    }
    @PostMapping()
    public ResponseEntity<CreatePaymentOutDTO> createPayment(@RequestBody CreatePaymentInDTO createPaymentInDTO){
        CreatePaymentOutDTO createPaymentOutDTO = payService.createPayment(createPaymentInDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createPaymentOutDTO);
    }
    @PutMapping()
    public ResponseEntity<HttpStatus> deletePayment(@RequestBody DeletePaymentInDTO deletePaymentInDTO){
        payService.deletePayment(deletePaymentInDTO);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
