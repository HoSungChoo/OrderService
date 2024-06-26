package com.hozzi.order.domain.order.mapper;

import com.hozzi.order.domain.order.dto.CreateOrderOutDTO;
import com.hozzi.order.domain.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);
    CreateOrderOutDTO toCreateOrderOutDTO(Order order);
}
