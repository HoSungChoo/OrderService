package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.user.dto.CreateBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.entity.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BasketMapper {
    BasketMapper basketMapper = Mappers.getMapper(BasketMapper.class);
    ReadBasketOutDTO toReadBasketOutDTO(Basket basket);
    CreateBasketOutDTO toCreateBasketOutDTO(Basket basket);
}
