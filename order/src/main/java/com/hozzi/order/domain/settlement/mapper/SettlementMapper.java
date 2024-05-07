package com.hozzi.order.domain.settlement.mapper;

import com.hozzi.order.domain.settlement.dto.CreatePayoutOutDTO;
import com.hozzi.order.domain.settlement.dto.CreateRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.CreateRewardOutDTO;
import com.hozzi.order.domain.settlement.entity.Settlement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SettlementMapper {
    SettlementMapper settlementMapper = Mappers.getMapper(SettlementMapper.class);
    CreateRewardOutDTO toCreateRewardOutDTO(Settlement settlement);
    CreatePayoutOutDTO toCreatePayoutOutDTO(Settlement settlement);
}
