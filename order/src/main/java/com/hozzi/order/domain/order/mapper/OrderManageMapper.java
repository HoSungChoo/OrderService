package com.hozzi.order.domain.order.mapper;

import com.hozzi.order.domain.order.dto.UpdateOrderByAdminOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByCustomOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByOwnerOutDTO;
import com.hozzi.order.domain.order.entity.OrderManage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderManageMapper {
    UpdateOrderByCustomOutDTO toUpdateOrderByCustomOutDTO(OrderManage orderManage);
    UpdateOrderByOwnerOutDTO toUpdateOrderByOwnerOutDTO(OrderManage orderManage);
    UpdateOrderByAdminOutDTO toUpdateOrderByAdminOutDTO(OrderManage orderManage);
    default UpdateOrderByCustomOutDTO toUpdateOrderByCustomOutDTOCustom(OrderManage orderManage){
        UpdateOrderByCustomOutDTO updateOrderByCustomOutDTO = toUpdateOrderByCustomOutDTOCustom(orderManage);

        updateOrderByCustomOutDTO.setOrderId(orderManage.getOrder().getOrderId());
        updateOrderByCustomOutDTO.setUserId(orderManage.getUser().getUserId());

        return updateOrderByCustomOutDTO;
    }
    default UpdateOrderByOwnerOutDTO toUpdateOrderByOwnerOutDTOCustom(OrderManage orderManage){
        UpdateOrderByOwnerOutDTO updateOrderByOwnerOutDTO = toUpdateOrderByOwnerOutDTOCustom(orderManage);

        updateOrderByOwnerOutDTO.setOrderId(orderManage.getOrder().getOrderId());
        updateOrderByOwnerOutDTO.setUserId(orderManage.getUser().getUserId());

        return updateOrderByOwnerOutDTO;
    }
    default UpdateOrderByAdminOutDTO toUpdateOrderByAdminOutDTOCustom(OrderManage orderManage){
        UpdateOrderByAdminOutDTO updateOrderByAdminOutDTO = toUpdateOrderByAdminOutDTOCustom(orderManage);

        updateOrderByAdminOutDTO.setOrderId(orderManage.getOrder().getOrderId());
        updateOrderByAdminOutDTO.setUserId(orderManage.getUser().getUserId());

        return updateOrderByAdminOutDTO;
    }
}
