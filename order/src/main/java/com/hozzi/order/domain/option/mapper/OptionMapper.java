package com.hozzi.order.domain.option.mapper;

import com.hozzi.order.domain.option.dto.CreateOptionOutDTO;
import com.hozzi.order.domain.option.dto.ReadOptionOutDTO;
import com.hozzi.order.domain.option.entity.Option;
import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {Option.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OptionMapper {
    ReadOptionOutDTO toReadOptionOutDTO(Option option);
    CreateOptionOutDTO toCreateOptionOutDTO(Option option);
}
