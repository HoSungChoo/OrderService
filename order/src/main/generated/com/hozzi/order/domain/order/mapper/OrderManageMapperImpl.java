package com.hozzi.order.domain.order.mapper;

import com.hozzi.order.domain.order.dto.UpdateOrderByAdminOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByAdminOutDTO.UpdateOrderByAdminOutDTOBuilder;
import com.hozzi.order.domain.order.dto.UpdateOrderByCustomOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByCustomOutDTO.UpdateOrderByCustomOutDTOBuilder;
import com.hozzi.order.domain.order.dto.UpdateOrderByOwnerOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByOwnerOutDTO.UpdateOrderByOwnerOutDTOBuilder;
import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.order.entity.OrderManage;
import com.hozzi.order.domain.user.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-15T11:43:14+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class OrderManageMapperImpl implements OrderManageMapper {

    @Override
    public UpdateOrderByCustomOutDTO toUpdateOrderByCustomOutDTO(OrderManage orderManage) {
        if ( orderManage == null ) {
            return null;
        }

        UpdateOrderByCustomOutDTOBuilder updateOrderByCustomOutDTO = UpdateOrderByCustomOutDTO.builder();

        updateOrderByCustomOutDTO.omType( orderManage.getOmType() );

        return updateOrderByCustomOutDTO.build();
    }

    @Override
    public UpdateOrderByOwnerOutDTO toUpdateOrderByOwnerOutDTO(OrderManage orderManage) {
        if ( orderManage == null ) {
            return null;
        }

        UpdateOrderByOwnerOutDTOBuilder updateOrderByOwnerOutDTO = UpdateOrderByOwnerOutDTO.builder();

        updateOrderByOwnerOutDTO.omType( orderManage.getOmType() );

        return updateOrderByOwnerOutDTO.build();
    }

    @Override
    public UpdateOrderByAdminOutDTO toUpdateOrderByAdminOutDTO(OrderManage orderManage) {
        if ( orderManage == null ) {
            return null;
        }

        UpdateOrderByAdminOutDTOBuilder updateOrderByAdminOutDTO = UpdateOrderByAdminOutDTO.builder();

        updateOrderByAdminOutDTO.omType( orderManage.getOmType() );

        return updateOrderByAdminOutDTO.build();
    }
}
