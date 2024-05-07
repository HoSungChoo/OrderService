package com.hozzi.order.domain.settlement.mapper;

import com.hozzi.order.domain.settlement.dto.CreateRefundOutDTO;
import com.hozzi.order.domain.settlement.dto.CreateRefundOutDTO.CreateRefundOutDTOBuilder;
import com.hozzi.order.domain.settlement.entity.Refund;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T22:20:59+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class RefundMapperImpl implements RefundMapper {

    @Override
    public CreateRefundOutDTO toCreateRefundOutDTO(Refund refund) {
        if ( refund == null ) {
            return null;
        }

        CreateRefundOutDTOBuilder createRefundOutDTO = CreateRefundOutDTO.builder();

        createRefundOutDTO.refundId( refund.getRefundId() );
        createRefundOutDTO.customBalance( refund.getCustomBalance() );
        createRefundOutDTO.ownerBalance( refund.getOwnerBalance() );
        createRefundOutDTO.refundType( refund.getRefundType() );
        createRefundOutDTO.refundReason( refund.getRefundReason() );
        createRefundOutDTO.createAt( refund.getCreateAt() );
        createRefundOutDTO.updateAt( refund.getUpdateAt() );

        return createRefundOutDTO.build();
    }
}
