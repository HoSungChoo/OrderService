package com.hozzi.order.domain.order.mapper;

import com.hozzi.order.domain.order.dto.UpdateOrderByAdminOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByAdminOutDTO.UpdateOrderByAdminOutDTOBuilder;
import com.hozzi.order.domain.order.dto.UpdateOrderByCustomOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByCustomOutDTO.UpdateOrderByCustomOutDTOBuilder;
import com.hozzi.order.domain.order.dto.UpdateOrderByOwnerOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByOwnerOutDTO.UpdateOrderByOwnerOutDTOBuilder;
import com.hozzi.order.domain.order.entity.OrderManage;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-05T16:39:17+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
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
