package com.hozzi.order.domain.store.mapper;

import com.hozzi.order.domain.store.dto.CreateMenuOutDTO;
import com.hozzi.order.domain.store.dto.UpdateMenuOutDTO;
import com.hozzi.order.domain.store.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    MenuMapper menuMapper = Mappers.getMapper(MenuMapper.class);
    CreateMenuOutDTO toCreateMenuOutDTO(Menu menu);
    UpdateMenuOutDTO toUpdateMenuOutDTO(Menu menu);
    default CreateMenuOutDTO toCreateMenuOutDTOCustom(Menu menu){
        CreateMenuOutDTO createMenuOutDTO = menuMapper.toCreateMenuOutDTOCustom(menu);
        createMenuOutDTO.setStoreId(menu.getStore().getStoreId());

        return createMenuOutDTO;
    }
    default UpdateMenuOutDTO toUpdateMenuOutDTOCustom(Menu menu){
        UpdateMenuOutDTO updateMenuOutDTO = menuMapper.toUpdateMenuOutDTO(menu);
        updateMenuOutDTO.setStoreId(menu.getStore().getStoreId());

        return updateMenuOutDTO;
    }
}
