package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.user.dto.CreateWalletInDTO;
import com.hozzi.order.domain.user.dto.CreateWalletOutDTO;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.entity.Wallet;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {Wallet.class, User.class})
public interface WalletMapper {
    WalletMapper walletMapper = Mappers.getMapper(WalletMapper.class);
    @Mapping(target = "userId", source = "wallet.user.userId")
    CreateWalletOutDTO toCreateWalletOutDTO(Wallet wallet);

}
