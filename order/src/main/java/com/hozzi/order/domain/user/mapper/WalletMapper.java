package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.user.dto.CreateWalletOutDTO;
import com.hozzi.order.domain.user.dto.DeleteWalletOutDTO;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.entity.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {Wallet.class, User.class})
public interface WalletMapper {
    //WalletMapper walletMapper = Mappers.getMapper(WalletMapper.class);
    //@Mapping(target = "userId", source = "wallet.user.userId")
    CreateWalletOutDTO toCreateWalletOutDTO(Wallet wallet);
    DeleteWalletOutDTO toDeleteWalletOutDTO(Wallet wallet);
    default DeleteWalletOutDTO toDeleteWalletOutDTOCustom(Wallet wallet){
        DeleteWalletOutDTO deleteWalletOutDTO = toDeleteWalletOutDTO(wallet);
        deleteWalletOutDTO.setPaymentId(wallet.getPayment().getPaymentId());

        System.out.println("BAHAMA : " + wallet.getPayment().getPaymentId());
        return deleteWalletOutDTO;
    }
}
