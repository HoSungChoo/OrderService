package com.hozzi.order.domain.order.mapper;

import com.hozzi.order.domain.order.dto.UpdateOrderByAdminOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByCustomOutDTO;
import com.hozzi.order.domain.order.dto.UpdateOrderByOwnerOutDTO;
import com.hozzi.order.domain.order.entity.OrderManage;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T17:35:05+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class OrderManageMapperImpl implements OrderManageMapper {

    @Override
    public UpdateOrderByCustomOutDTO toUpdateOrderByCustomOutDTO(OrderManage orderManage) {
        if ( orderManage == null ) {
            return null;
        }

        UpdateOrderByCustomOutDTO updateOrderByCustomOutDTO = new UpdateOrderByCustomOutDTO();

        return updateOrderByCustomOutDTO;
    }

    @Override
    public UpdateOrderByOwnerOutDTO toUpdateOrderByOwnerOutDTO(OrderManage orderManage) {
        if ( orderManage == null ) {
            return null;
        }

        UpdateOrderByOwnerOutDTO updateOrderByOwnerOutDTO = new UpdateOrderByOwnerOutDTO();

        return updateOrderByOwnerOutDTO;
    }

    @Override
    public UpdateOrderByAdminOutDTO toUpdateOrderByAdminOutDTO(OrderManage orderManage) {
        if ( orderManage == null ) {
            return null;
        }

        UpdateOrderByAdminOutDTO updateOrderByAdminOutDTO = new UpdateOrderByAdminOutDTO();

        return updateOrderByAdminOutDTO;
    }
}
