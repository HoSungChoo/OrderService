package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.user.dto.CreateBasketOutDTO;
import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {Store.class, Menu.class, User.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BasketMapper {
    ReadBasketOutDTO toReadBasketOutDTO(Basket basket);
    default ReadBasketOutDTO toReadBasketOutDTOCustom(Basket basket){
        ReadBasketOutDTO readBasketOutDTO = toReadBasketOutDTO(basket);

        readBasketOutDTO.setUserId(basket.getUser().getUserId());
        readBasketOutDTO.setStoreId(basket.getStore().getStoreId());
        readBasketOutDTO.setMenuId(basket.getMenu().getMenuId());

        return readBasketOutDTO;
    }
    CreateBasketOutDTO toCreateBasketOutDTO(Basket basket);
    default CreateBasketOutDTO toCreateBasketOutDTOCustom(Basket basket){
        CreateBasketOutDTO createBasketOutDTO = toCreateBasketOutDTO(basket);

        createBasketOutDTO.setUserId(basket.getUser().getUserId());
        createBasketOutDTO.setStoreId(basket.getStore().getStoreId());
        createBasketOutDTO.setMenuId(basket.getMenu().getMenuId());

        return createBasketOutDTO;
    }

}
