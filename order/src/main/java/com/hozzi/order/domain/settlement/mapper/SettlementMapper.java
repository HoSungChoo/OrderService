package com.hozzi.order.domain.settlement.mapper;

import com.hozzi.order.domain.settlement.dto.CreatePayoutOutDTO;
import com.hozzi.order.domain.settlement.dto.CreateRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.CreateRewardOutDTO;
import com.hozzi.order.domain.settlement.entity.Settlement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SettlementMapper {
    CreateRewardOutDTO toCreateRewardOutDTO(Settlement settlement);
    CreatePayoutOutDTO toCreatePayoutOutDTO(Settlement settlement);
    default CreateRewardOutDTO toCreateRewardOutDTOCustom(Settlement settlement){
        CreateRewardOutDTO createRewardOutDTO = toCreateRewardOutDTOCustom(settlement);

        createRewardOutDTO.setUserId(settlement.getUser().getUserId());
        createRewardOutDTO.setOrderId(settlement.getOrder().getOrderId());

        return createRewardOutDTO;
    }
    default CreatePayoutOutDTO toCreatePayoutOutDTOCustom(Settlement settlement){
        CreatePayoutOutDTO createPayoutOutDTO = toCreatePayoutOutDTOCustom(settlement);

        createPayoutOutDTO.setUserId(settlement.getUser().getUserId());
        createPayoutOutDTO.setOrderId(settlement.getOrder().getOrderId());

        return createPayoutOutDTO;
    }
}
