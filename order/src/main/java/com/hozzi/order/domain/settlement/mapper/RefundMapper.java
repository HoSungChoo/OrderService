package com.hozzi.order.domain.settlement.mapper;

import com.hozzi.order.domain.settlement.dto.CreateRefundOutDTO;
import com.hozzi.order.domain.settlement.entity.Refund;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RefundMapper {
    RefundMapper refundMapper = Mappers.getMapper(RefundMapper.class);
    CreateRefundOutDTO toCreateRefundOutDTO(Refund refund);
}
