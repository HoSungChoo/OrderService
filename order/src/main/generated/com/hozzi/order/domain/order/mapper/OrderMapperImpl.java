package com.hozzi.order.domain.order.mapper;

import com.hozzi.order.domain.order.dto.CreateOrderOutDTO;
import com.hozzi.order.domain.order.dto.CreateOrderOutDTO.CreateOrderOutDTOBuilder;
import com.hozzi.order.domain.order.entity.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-15T10:22:32+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public CreateOrderOutDTO toCreateOrderOutDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        CreateOrderOutDTOBuilder createOrderOutDTO = CreateOrderOutDTO.builder();

        createOrderOutDTO.orderId( order.getOrderId() );
        createOrderOutDTO.balance( order.getBalance() );
        createOrderOutDTO.reward( order.getReward() );
        createOrderOutDTO.createAt( order.getCreateAt() );

        return createOrderOutDTO.build();
    }
}
