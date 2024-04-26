package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.user.dto.ReadUserOutDTO;
import com.hozzi.order.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    ReadUserOutDTO toDTO(User user);
}
