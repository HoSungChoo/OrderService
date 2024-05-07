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
    default ReadBasketOutDTO toReadBasketOutDTOCustom(Basket basket){
        ReadBasketOutDTO readBasketOutDTO = basketMapper.toReadBasketOutDTO(basket);

        readBasketOutDTO.setUserId(basket.getUser().getUserId());
        readBasketOutDTO.setStoreId(basket.getStore().getStoreId());
        readBasketOutDTO.setMenuId(basket.getMenu().getMenuId());

        return readBasketOutDTO;
    }

    default CreateBasketOutDTO toCreateBasketOutDTOCustom(Basket basket){
        CreateBasketOutDTO createBasketOutDTO = basketMapper.toCreateBasketOutDTO(basket);

        createBasketOutDTO.setUserId(basket.getUser().getUserId());
        createBasketOutDTO.setStoreId(basket.getStore().getStoreId());
        createBasketOutDTO.setMenuId(basket.getMenu().getMenuId());

        return createBasketOutDTO;
    }

}
