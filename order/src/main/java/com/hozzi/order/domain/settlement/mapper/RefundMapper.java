package com.hozzi.order.domain.settlement.mapper;

import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.settlement.dto.CreateRefundOutDTO;
import com.hozzi.order.domain.settlement.entity.Refund;
import com.hozzi.order.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {Order.class, User.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RefundMapper {
    CreateRefundOutDTO toCreateRefundOutDTO(Refund refund);
    default CreateRefundOutDTO toCreateRefundOutDTOCustom(Refund refund){
        CreateRefundOutDTO createRefundOutDTO = toCreateRefundOutDTOCustom(refund);

        createRefundOutDTO.setOrderId(refund.getOrder().getOrderId());
        createRefundOutDTO.setCustomId(refund.getCustom().getUserId());
        createRefundOutDTO.setOwnerId(refund.getOwner().getUserId());

        return createRefundOutDTO;
    }
}
