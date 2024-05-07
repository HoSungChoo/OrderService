package com.hozzi.order.domain.order.mapper;

import com.hozzi.order.domain.order.dto.UpdateOrderByAdminOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByCustomOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByOwnerOutDTO;
import com.hozzi.order.domain.order.entity.OrderManage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderManageMapper {
    OrderManageMapper orderManageMapper = Mappers.getMapper(OrderManageMapper.class);
    UpdateOrderByCustomOutDTO toUpdateOrderByCustomOutDTO(OrderManage orderManage);
    UpdateOrderByOwnerOutDTO toUpdateOrderByOwnerOutDTO(OrderManage orderManage);
    UpdateOrderByAdminOutDTO toUpdateOrderByAdminOutDTO(OrderManage orderManage);
}
