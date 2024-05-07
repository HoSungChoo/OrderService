package com.hozzi.order.domain.pay.service;

import com.hozzi.order.domain.pay.dto.*;

public interface PayService {
    ReadPaymentOutDTOs readPayments();
    ReadPaymentOutDTO readPayment(Long paymentId);
    CreatePaymentOutDTO createPayment(CreatePaymentInDTO createPaymentInDTO);
    DeletePaymentOutDTO deletePayment(DeletePaymentInDTO deletePaymentInDTO);
}
