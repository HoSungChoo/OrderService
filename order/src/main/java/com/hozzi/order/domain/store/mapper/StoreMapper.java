package com.hozzi.order.domain.store.mapper;

import com.hozzi.order.domain.option.entity.Option;
import com.hozzi.order.domain.store.dto.CreateStoreOutDTO;
import com.hozzi.order.domain.store.dto.UpdateStoreOutDTO;
import com.hozzi.order.domain.store.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {Store.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StoreMapper {
    CreateStoreOutDTO toCreateStoreOutDTO(Store store);
    UpdateStoreOutDTO toUpdateStoreOutDTO(Store store);
}
