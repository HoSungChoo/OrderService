package com.hozzi.order.domain.option.mapper;

import com.hozzi.order.domain.option.dto.CreateOptionOutDTO;
import com.hozzi.order.domain.option.dto.CreateOptionOutDTO.CreateOptionOutDTOBuilder;
import com.hozzi.order.domain.option.dto.ReadOptionOutDTO;
import com.hozzi.order.domain.option.dto.ReadOptionOutDTO.ReadOptionOutDTOBuilder;
import com.hozzi.order.domain.option.entity.Option;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-13T14:48:42+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class OptionMapperImpl implements OptionMapper {

    @Override
    public ReadOptionOutDTO toReadOptionOutDTO(Option option) {
        if ( option == null ) {
            return null;
        }

        ReadOptionOutDTOBuilder readOptionOutDTO = ReadOptionOutDTO.builder();

        readOptionOutDTO.optionId( option.getOptionId() );
        readOptionOutDTO.optionName( option.getOptionName() );
        readOptionOutDTO.detail( option.getDetail() );
        readOptionOutDTO.value( option.getValue() );
        readOptionOutDTO.createAt( option.getCreateAt() );
        readOptionOutDTO.updateAt( option.getUpdateAt() );

        return readOptionOutDTO.build();
    }

    @Override
    public CreateOptionOutDTO toCreateOptionOutDTO(Option option) {
        if ( option == null ) {
            return null;
        }

        CreateOptionOutDTOBuilder createOptionOutDTO = CreateOptionOutDTO.builder();

        createOptionOutDTO.optionId( option.getOptionId() );
        createOptionOutDTO.optionName( option.getOptionName() );
        createOptionOutDTO.detail( option.getDetail() );
        createOptionOutDTO.value( option.getValue() );
        createOptionOutDTO.createAt( option.getCreateAt() );
        createOptionOutDTO.updateAt( option.getUpdateAt() );

        return createOptionOutDTO.build();
    }
}
