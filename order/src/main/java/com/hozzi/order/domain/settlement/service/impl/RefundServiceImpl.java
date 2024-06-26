package com.hozzi.order.domain.settlement.service.impl;

import com.hozzi.order.domain.order.repo.OrderRepo;
import com.hozzi.order.domain.settlement.dto.CreateRefundInDTO;
import com.hozzi.order.domain.settlement.dto.CreateRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.ReadRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.ReadRefundOutDTOs;
import com.hozzi.order.domain.settlement.entity.Refund;
import com.hozzi.order.domain.settlement.mapper.RefundMapper;
import com.hozzi.order.domain.settlement.repo.RefundRepo;
import com.hozzi.order.domain.settlement.service.RefundService;
import com.hozzi.order.domain.user.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RefundServiceImpl implements RefundService {
    private final RefundRepo refundRepo;
    private final UserRepo userRepo;
    private final OrderRepo orderRepo;
    private final RefundMapper refundMapper;

    public RefundServiceImpl(RefundRepo refundRepo, UserRepo userRepo, OrderRepo orderRepo, RefundMapper refundMapper) {
        this.refundRepo = refundRepo;
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
        this.refundMapper = refundMapper;
    }

    @Override
    public CreateRefundOutDTO createRefund(CreateRefundInDTO createRefundInDTO) {
        Refund refund = Refund.builder()
                .customBalance(createRefundInDTO.getCustomBalance())
                .ownerBalance(createRefundInDTO.getOwnerBalance())
                .refundType(createRefundInDTO.getRefundType())
                .refundReason(createRefundInDTO.getRefundReason())
                .custom(userRepo.findById(createRefundInDTO.getCustomId()).orElseThrow(()->new IllegalArgumentException("Not exist customId")))
                .owner(userRepo.findById(createRefundInDTO.getOwnerId()).orElseThrow(()->new IllegalArgumentException("Not exist ownerId")))
                .order(orderRepo.findById(createRefundInDTO.getOrderId()).orElseThrow(()->new IllegalArgumentException("Not exist orderId")))
                .build();

        refundRepo.save(refund);

        return refundMapper.toCreateRefundOutDTO(refund);
    }

    @Override
    public ReadRefundOutDTOs readRefund(String beginDate, String endDate) {
        LocalDateTime beginDateTime = LocalDateTime.parse(beginDate, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        List<ReadRefundOutDTO> readRefundOutDTOS = refundRepo.findAllBetweenDate(beginDateTime, endDateTime)
                .orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadRefundOutDTOs.builder().refunds(readRefundOutDTOS).build();
    }
}
