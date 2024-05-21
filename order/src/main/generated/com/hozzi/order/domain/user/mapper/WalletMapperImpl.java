package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.user.dto.CreateWalletOutDTO;
import com.hozzi.order.domain.user.dto.CreateWalletOutDTO.CreateWalletOutDTOBuilder;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.entity.Wallet;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-21T18:03:37+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class WalletMapperImpl implements WalletMapper {

    @Override
    public CreateWalletOutDTO toCreateWalletOutDTO(Wallet wallet) {
        if ( wallet == null ) {
            return null;
        }

        CreateWalletOutDTOBuilder createWalletOutDTO = CreateWalletOutDTO.builder();

        createWalletOutDTO.userId( walletUserUserId( wallet ) );
        createWalletOutDTO.walletId( wallet.getWalletId() );
        createWalletOutDTO.state( wallet.getState() );
        createWalletOutDTO.createAt( wallet.getCreateAt() );
        createWalletOutDTO.updateAt( wallet.getUpdateAt() );

        return createWalletOutDTO.build();
    }

    private Long walletUserUserId(Wallet wallet) {
        if ( wallet == null ) {
            return null;
        }
        User user = wallet.getUser();
        if ( user == null ) {
            return null;
        }
        Long userId = user.getUserId();
        if ( userId == null ) {
            return null;
        }
        return userId;
    }
}
