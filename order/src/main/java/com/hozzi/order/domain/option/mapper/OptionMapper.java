package com.hozzi.order.domain.option.mapper;

import com.hozzi.order.domain.option.dto.CreateOptionOutDTO;
import com.hozzi.order.domain.option.dto.ReadOptionOutDTO;
import com.hozzi.order.domain.option.entity.Option;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OptionMapper {
    ReadOptionOutDTO toReadOptionOutDTO(Option option);
    CreateOptionOutDTO toCreateOptionOutDTO(Option option);
}
