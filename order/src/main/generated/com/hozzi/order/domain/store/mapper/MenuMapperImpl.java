package com.hozzi.order.domain.store.mapper;

import com.hozzi.order.domain.store.dto.CreateMenuOutDTO;
import com.hozzi.order.domain.store.dto.CreateMenuOutDTO.CreateMenuOutDTOBuilder;
import com.hozzi.order.domain.store.dto.UpdateMenuOutDTO;
import com.hozzi.order.domain.store.dto.UpdateMenuOutDTO.UpdateMenuOutDTOBuilder;
import com.hozzi.order.domain.store.entity.Menu;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-05T11:58:08+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class MenuMapperImpl implements MenuMapper {

    @Override
    public CreateMenuOutDTO toCreateMenuOutDTO(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        CreateMenuOutDTOBuilder createMenuOutDTO = CreateMenuOutDTO.builder();

        createMenuOutDTO.menuId( menu.getMenuId() );
        createMenuOutDTO.menuName( menu.getMenuName() );
        createMenuOutDTO.menuPrice( menu.getMenuPrice() );
        createMenuOutDTO.state( menu.getState() );
        createMenuOutDTO.createAt( menu.getCreateAt() );
        createMenuOutDTO.updateAt( menu.getUpdateAt() );
        createMenuOutDTO.cancelAt( menu.getCancelAt() );

        return createMenuOutDTO.build();
    }

    @Override
    public UpdateMenuOutDTO toUpdateMenuOutDTO(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        UpdateMenuOutDTOBuilder updateMenuOutDTO = UpdateMenuOutDTO.builder();

        updateMenuOutDTO.menuId( menu.getMenuId() );
        updateMenuOutDTO.menuName( menu.getMenuName() );
        updateMenuOutDTO.menuPrice( menu.getMenuPrice() );
        updateMenuOutDTO.state( menu.getState() );
        updateMenuOutDTO.createAt( menu.getCreateAt() );
        updateMenuOutDTO.updateAt( menu.getUpdateAt() );
        updateMenuOutDTO.cancelAt( menu.getCancelAt() );

        return updateMenuOutDTO.build();
    }
}
