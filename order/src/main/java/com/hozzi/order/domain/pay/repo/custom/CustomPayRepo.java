package com.hozzi.order.domain.pay.repo.custom;

import com.hozzi.order.domain.pay.dto.ReadPaymentOutDTO;

import java.util.List;
import java.util.Optional;

public interface CustomPayRepo {
    Optional<List<ReadPaymentOutDTO>> findAllByC();
}
