package com.hozzi.order.domain.order.mapper;

import com.hozzi.order.domain.option.entity.Option;
import com.hozzi.order.domain.order.dto.CreateOrderOutDTO;
import com.hozzi.order.domain.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {Order.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    CreateOrderOutDTO toCreateOrderOutDTO(Order order);
}
