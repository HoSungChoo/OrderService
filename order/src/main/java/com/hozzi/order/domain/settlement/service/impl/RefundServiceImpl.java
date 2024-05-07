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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RefundServiceImpl implements RefundService {
    private final RefundRepo refundRepo;
    private final UserRepo userRepo;
    private final OrderRepo orderRepo;

    public RefundServiceImpl(RefundRepo refundRepo, UserRepo userRepo, OrderRepo orderRepo) {
        this.refundRepo = refundRepo;
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public CreateRefundOutDTO createRefund(CreateRefundInDTO createRefundInDTO) {
        Refund refund = Refund.builder()
                .customBalance(createRefundInDTO.getCustomBalance())
                .ownerBalance(createRefundInDTO.getOwnerBalance())
                .refundType(createRefundInDTO.getRefundType())
                .refundReason(createRefundInDTO.getRefundReason())
                .custom(userRepo.findById(createRefundInDTO.getCustomId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .owner(userRepo.findById(createRefundInDTO.getOwnerId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .order(orderRepo.findById(createRefundInDTO.getOwnerId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .build();

        refundRepo.save(refund);

        return RefundMapper.refundMapper.toCreateRefundOutDTO(refund);
    }

    @Override
    public ReadRefundOutDTOs readRefund(String beginDate, String endDate) {
        LocalDateTime beginDateTime = LocalDateTime.parse(beginDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd"));

        List<ReadRefundOutDTO> readRefundOutDTOS = refundRepo.findAllBetweenDate(beginDateTime, endDateTime)
                .orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadRefundOutDTOs.builder().refunds(readRefundOutDTOS).build();
    }
}
