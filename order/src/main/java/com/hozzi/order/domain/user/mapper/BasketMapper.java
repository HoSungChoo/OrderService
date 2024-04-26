package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.user.dto.CreateBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.entity.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BasketMapper {
    BasketMapper basketMapper = Mappers.getMapper(BasketMapper.class);
    default ReadBasketOutDTO toReadBasketOutDTO(Basket basket){
        return ReadBasketOutDTO.builder()
                .basketId(basket.getBasketId())
                .userId(basket.getUser().getUserId())
                .storeId(basket.getStore().getStoreId())
                .menuId(basket.getMenu().getMenuId())
                .amount(basket.getAmount())
                .createAt(basket.getCreateAt())
                .updateAt(basket.getUpdateAt())
                .build();
    }
    default CreateBasketOutDTO toCreateBasketOutDTO(Basket basket){
        return CreateBasketOutDTO.builder()
                .basketId(basket.getBasketId())
                .userId(basket.getUser().getUserId())
                .storeId(basket.getStore().getStoreId())
                .menuId(basket.getMenu().getMenuId())
                .amount(basket.getAmount())
                .createAt(basket.getCreateAt())
                .updateAt(basket.getUpdateAt())
                .build();
    }

}
