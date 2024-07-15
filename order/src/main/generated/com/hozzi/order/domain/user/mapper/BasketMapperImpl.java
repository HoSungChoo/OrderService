package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.user.dto.CreateBasketOutDTO;
import com.hozzi.order.domain.user.dto.CreateBasketOutDTO.CreateBasketOutDTOBuilder;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO.ReadBasketOutDTOBuilder;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-15T10:46:54+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class BasketMapperImpl implements BasketMapper {

    @Override
    public ReadBasketOutDTO toReadBasketOutDTO(Basket basket) {
        if ( basket == null ) {
            return null;
        }

        ReadBasketOutDTOBuilder readBasketOutDTO = ReadBasketOutDTO.builder();

        readBasketOutDTO.basketId( basket.getBasketId() );
        readBasketOutDTO.amount( basket.getAmount() );
        readBasketOutDTO.createAt( basket.getCreateAt() );
        readBasketOutDTO.updateAt( basket.getUpdateAt() );

        return readBasketOutDTO.build();
    }

    @Override
    public CreateBasketOutDTO toCreateBasketOutDTO(Basket basket) {
        if ( basket == null ) {
            return null;
        }

        CreateBasketOutDTOBuilder createBasketOutDTO = CreateBasketOutDTO.builder();

        createBasketOutDTO.basketId( basket.getBasketId() );
        createBasketOutDTO.amount( basket.getAmount() );
        createBasketOutDTO.createAt( basket.getCreateAt() );
        createBasketOutDTO.updateAt( basket.getUpdateAt() );

        return createBasketOutDTO.build();
    }
}
