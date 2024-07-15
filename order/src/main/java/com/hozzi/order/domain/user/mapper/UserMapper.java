package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.user.dto.DeleteUserOutDTO;
import com.hozzi.order.domain.user.dto.ReadUserOutDTO;
import com.hozzi.order.domain.user.dto.UpdateUserOutDTO;
import com.hozzi.order.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    ReadUserOutDTO toReadUserOutDTO(User user);
    UpdateUserOutDTO toUpdateUserOutDTO(User user);
    DeleteUserOutDTO toDeleteUserOutDTO(User user);
}
