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
    private final PayMapper payMapper;
    public PayServiceImpl(PayRepo payRepo, PayMapper payMapper) {
        this.payRepo = payRepo;
        this.payMapper = payMapper;
    }

    @Override
    public ReadPaymentOutDTOs readPayments() {
        List<ReadPaymentOutDTO> readPaymentOutDTOs = payRepo.findAllCustom().orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadPaymentOutDTOs.builder().payments(readPaymentOutDTOs).build();
    }

    @Override
    public ReadPaymentOutDTO readPayment(Long paymentId) {
        Payment payment = payRepo.findById(paymentId).orElseThrow(()->new IllegalArgumentException("Not exist paymentId"));

        return payMapper.toReadPaymentOutDTO(payment);
    }

    @Override
    public CreatePaymentOutDTO createPayment(CreatePaymentInDTO createPaymentInDTO) {
        if (payRepo.existsByPaymentName(createPaymentInDTO.getPaymentName()))
            throw new IllegalArgumentException("Duplicated paymentName");

        Payment payment = Payment.builder()
                .paymentName(createPaymentInDTO.getPaymentName())
                .state(createPaymentInDTO.getState())
                .discountRate(createPaymentInDTO.getDiscountRate())
                .rewardRate(createPaymentInDTO.getRewardRate())
                .cancelAt(LocalDateTime.of(2999, 12, 31, 0, 0, 0))
                .build();

        payRepo.save(payment);

        return payMapper.toCreatePaymentOutDTO(payment);
    }

    @Override
    public DeletePaymentOutDTO deletePayment(DeletePaymentInDTO deletePaymentInDTO) {
        Payment payment = payRepo.findById(deletePaymentInDTO.getPaymentId()).orElseThrow(()->new IllegalArgumentException("Not exist paymentId"));

        if (payment.getState().equals(State.CANCEL))
            throw new IllegalArgumentException("Already Canceled");

        payment.setState(State.CANCEL);
        payment.setCancelAt(LocalDateTime.now());

        return payMapper.toDeletePaymentOutDTO(payment);
    }
}
