package com.hozzi.order.domain.store.mapper;

import com.hozzi.order.domain.store.dto.CreateStoreOutDTO;
import com.hozzi.order.domain.store.dto.CreateStoreOutDTO.CreateStoreOutDTOBuilder;
import com.hozzi.order.domain.store.dto.UpdateStoreOutDTO;
import com.hozzi.order.domain.store.dto.UpdateStoreOutDTO.UpdateStoreOutDTOBuilder;
import com.hozzi.order.domain.store.entity.Store;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T22:40:14+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class StoreMapperImpl implements StoreMapper {

    @Override
    public CreateStoreOutDTO toCreateStoreOutDTO(Store store) {
        if ( store == null ) {
            return null;
        }

        CreateStoreOutDTOBuilder createStoreOutDTO = CreateStoreOutDTO.builder();

        createStoreOutDTO.storeId( store.getStoreId() );
        createStoreOutDTO.storeName( store.getStoreName() );
        createStoreOutDTO.storeType( store.getStoreType() );
        createStoreOutDTO.state( store.getState() );
        createStoreOutDTO.createAt( store.getCreateAt() );
        createStoreOutDTO.updateAt( store.getUpdateAt() );
        createStoreOutDTO.cancelAt( store.getCancelAt() );

        return createStoreOutDTO.build();
    }

    @Override
    public UpdateStoreOutDTO toUpdateStoreOutDTO(Store store) {
        if ( store == null ) {
            return null;
        }

        UpdateStoreOutDTOBuilder updateStoreOutDTO = UpdateStoreOutDTO.builder();

        updateStoreOutDTO.storeId( store.getStoreId() );
        updateStoreOutDTO.storeName( store.getStoreName() );
        updateStoreOutDTO.storeType( store.getStoreType() );
        updateStoreOutDTO.state( store.getState() );
        updateStoreOutDTO.createAt( store.getCreateAt() );
        updateStoreOutDTO.updateAt( store.getUpdateAt() );
        updateStoreOutDTO.cancelAt( store.getCancelAt() );

        return updateStoreOutDTO.build();
    }
}
