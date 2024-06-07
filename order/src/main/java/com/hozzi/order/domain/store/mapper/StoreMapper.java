package com.hozzi.order.domain.store.mapper;

import com.hozzi.order.domain.store.dto.CreateStoreOutDTO;
import com.hozzi.order.domain.store.dto.UpdateStoreOutDTO;
import com.hozzi.order.domain.store.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    CreateStoreOutDTO toCreateStoreOutDTO(Store store);
    UpdateStoreOutDTO toUpdateStoreOutDTO(Store store);
}
