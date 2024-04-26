package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.user.dto.CreateWalletInDTO;
import com.hozzi.order.domain.user.dto.CreateWalletOutDTO;
import com.hozzi.order.domain.user.entity.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WalletMapper {
    WalletMapper walletMapper = Mappers.getMapper(WalletMapper.class);
    CreateWalletOutDTO toCreateWalletOutDTO(Wallet wallet);
}
