package com.hozzi.order.domain.pay.service.impl;

import com.hozzi.order.domain.pay.dto.*;
import com.hozzi.order.domain.pay.entity.Payment;
import com.hozzi.order.domain.pay.mapper.PayMapper;
import com.hozzi.order.domain.pay.repo.PayRepo;
import com.hozzi.order.domain.pay.service.PayService;
import com.hozzi.order.global.enumerate.State;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    private final PayRepo payRepo;

    public PayServiceImpl(PayRepo payRepo) {
        this.payRepo = payRepo;
    }

    @Override
    public ReadPaymentOutDTOs readPayments() {
        List<ReadPaymentOutDTO> readPaymentOutDTOs = payRepo.findAllByC().orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadPaymentOutDTOs.builder().payments(readPaymentOutDTOs).build();
    }

    @Override
    public ReadPaymentOutDTO readPayment(Long paymentId) {
        Payment payment = payRepo.findById(paymentId).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return PayMapper.payMapper.toReadPaymentOutDTO(payment);
    }

    @Override
    public CreatePaymentOutDTO createPayment(CreatePaymentInDTO createPaymentInDTO) {
        Payment payment = Payment.builder()
                .paymentName(createPaymentInDTO.getPaymentName())
                .state(createPaymentInDTO.getState())
                .discountRate(createPaymentInDTO.getDiscountRate())
                .rewardRate(createPaymentInDTO.getRewardRate())
                .cancelAt(LocalDateTime.of(2999, 12, 31, 0, 0, 0))
                .build();

        payRepo.save(payment);

        return PayMapper.payMapper.toCreatePaymentOutDTO(payment);
    }

    @Override
    public void deletePayment(DeletePaymentInDTO deletePaymentInDTO) {
        Payment payment = payRepo.findById(deletePaymentInDTO.getPaymentId()).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        payment.setState(State.CANCEL);
        payment.setCancelAt(LocalDateTime.now());
    }
}
