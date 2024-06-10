package com.hozzi.order.domain.settlement.mapper;

import com.hozzi.order.domain.settlement.dto.CreatePayoutOutDTO;
import com.hozzi.order.domain.settlement.dto.CreatePayoutOutDTO.CreatePayoutOutDTOBuilder;
import com.hozzi.order.domain.settlement.dto.CreateRewardOutDTO;
import com.hozzi.order.domain.settlement.dto.CreateRewardOutDTO.CreateRewardOutDTOBuilder;
import com.hozzi.order.domain.settlement.entity.Settlement;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T17:24:21+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SettlementMapperImpl implements SettlementMapper {

    @Override
    public CreateRewardOutDTO toCreateRewardOutDTO(Settlement settlement) {
        if ( settlement == null ) {
            return null;
        }

        CreateRewardOutDTOBuilder createRewardOutDTO = CreateRewardOutDTO.builder();

        createRewardOutDTO.settlementId( settlement.getSettlementId() );
        createRewardOutDTO.balance( settlement.getBalance() );
        createRewardOutDTO.settlementType( settlement.getSettlementType() );
        createRewardOutDTO.createAt( settlement.getCreateAt() );
        createRewardOutDTO.updateAt( settlement.getUpdateAt() );

        return createRewardOutDTO.build();
    }

    @Override
    public CreatePayoutOutDTO toCreatePayoutOutDTO(Settlement settlement) {
        if ( settlement == null ) {
            return null;
        }

        CreatePayoutOutDTOBuilder createPayoutOutDTO = CreatePayoutOutDTO.builder();

        createPayoutOutDTO.settlementId( settlement.getSettlementId() );
        createPayoutOutDTO.balance( settlement.getBalance() );
        createPayoutOutDTO.settlementType( settlement.getSettlementType() );
        createPayoutOutDTO.createAt( settlement.getCreateAt() );
        createPayoutOutDTO.updateAt( settlement.getUpdateAt() );

        return createPayoutOutDTO.build();
    }
}
