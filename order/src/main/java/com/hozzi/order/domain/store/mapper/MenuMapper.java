package com.hozzi.order.domain.store.mapper;

import com.hozzi.order.domain.store.dto.CreateMenuOutDTO;
import com.hozzi.order.domain.store.dto.UpdateMenuOutDTO;
import com.hozzi.order.domain.store.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper {
    CreateMenuOutDTO toCreateMenuOutDTO(Menu menu);
    UpdateMenuOutDTO toUpdateMenuOutDTO(Menu menu);
    default CreateMenuOutDTO toCreateMenuOutDTOCustom(Menu menu){
        CreateMenuOutDTO createMenuOutDTO = toCreateMenuOutDTOCustom(menu);
        createMenuOutDTO.setStoreId(menu.getStore().getStoreId());

        return createMenuOutDTO;
    }
    default UpdateMenuOutDTO toUpdateMenuOutDTOCustom(Menu menu){
        UpdateMenuOutDTO updateMenuOutDTO = toUpdateMenuOutDTO(menu);
        updateMenuOutDTO.setStoreId(menu.getStore().getStoreId());

        return updateMenuOutDTO;
    }
}
