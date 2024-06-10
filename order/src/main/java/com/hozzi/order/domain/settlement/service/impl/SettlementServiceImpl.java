package com.hozzi.order.domain.settlement.service.impl;

import com.hozzi.order.domain.order.repo.OrderRepo;
import com.hozzi.order.domain.settlement.dto.*;
import com.hozzi.order.domain.settlement.entity.Settlement;
import com.hozzi.order.domain.settlement.enumerate.SettlementType;
import com.hozzi.order.domain.settlement.mapper.SettlementMapper;
import com.hozzi.order.domain.settlement.repo.RefundRepo;
import com.hozzi.order.domain.settlement.repo.SettlementRepo;
import com.hozzi.order.domain.settlement.service.SettlementService;
import com.hozzi.order.domain.user.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SettlementServiceImpl implements SettlementService {
    private final SettlementRepo settlementRepo;
    private final RefundRepo refundRepo;
    private final UserRepo userRepo;
    private final OrderRepo orderRepo;
    private final SettlementMapper settlementMapper;

    public SettlementServiceImpl(SettlementRepo settlementRepo, RefundRepo refundRepo, UserRepo userRepo, OrderRepo orderRepo, SettlementMapper settlementMapper) {
        this.settlementRepo = settlementRepo;
        this.refundRepo = refundRepo;
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
        this.settlementMapper = settlementMapper;
    }

    @Override
    public CreateRewardOutDTO createReward(CreateRewardInDTO createRewardInDTO) {
        Settlement settlement = Settlement.builder()
                .balance(createRewardInDTO.getBalance())
                .settlementType(SettlementType.REWARD)
                .user(userRepo.findById(createRewardInDTO.getUserId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .order(orderRepo.findById(createRewardInDTO.getOrderId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .build();

        settlementRepo.save(settlement);

        return settlementMapper.toCreateRewardOutDTOCustom(settlement);
    }

    @Override
    public CreatePayoutOutDTO createPayout(CreatePayoutInDTO createPayoutInDTO) {
        Settlement settlement = Settlement.builder()
                .balance(createPayoutInDTO.getBalance())
                .settlementType(SettlementType.REWARD)
                .user(userRepo.findById(createPayoutInDTO.getUserId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .order(orderRepo.findById(createPayoutInDTO.getOrderId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .build();

        settlementRepo.save(settlement);

        return settlementMapper.toCreatePayoutOutDTOCustom(settlement);
    }

    @Override
    public ReadSettlementOutDTOs readReward(String beginDate, String endDate) {
        LocalDateTime beginDateTime = LocalDateTime.parse(beginDate, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        List<ReadSettlementOutDTO> readSettlementOutDTOS = settlementRepo.findAllBetweenDate(beginDateTime, endDateTime, SettlementType.REWARD)
                .orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadSettlementOutDTOs.builder().settlements(readSettlementOutDTOS).build();
    }

    @Override
    public ReadSettlementOutDTOs readPayout(String beginDate, String endDate) {
        LocalDateTime beginDateTime = LocalDateTime.parse(beginDate, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        List<ReadSettlementOutDTO> readSettlementOutDTOS = settlementRepo.findAllBetweenDate(beginDateTime, endDateTime, SettlementType.PAYOUT)
                .orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadSettlementOutDTOs.builder().settlements(readSettlementOutDTOS).build();
    }


}
