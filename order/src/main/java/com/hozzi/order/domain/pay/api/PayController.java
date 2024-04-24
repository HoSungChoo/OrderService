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
    public ResponseEntity<ReadPaymentOutDTOs> readPayment(){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadPaymentOutDTOs());
    }
    @GetMapping("/id/{userId}")
    public ResponseEntity<ReadPaymentOutDTO> readPayment(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadPaymentOutDTO());
    }
    @PostMapping()
    public ResponseEntity<CreatePaymentOutDTO> createPayment(@RequestBody CreatePaymentInDTO createPaymentInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreatePaymentOutDTO());
    }
    @PutMapping()
    public ResponseEntity<HttpStatus> deletePayment(@RequestBody DeletePaymentInDTO deletePaymentInDTO){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
