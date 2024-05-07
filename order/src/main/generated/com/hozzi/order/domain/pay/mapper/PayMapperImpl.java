package com.hozzi.order.domain.pay.mapper;

import com.hozzi.order.domain.pay.dto.CreatePaymentOutDTO;
import com.hozzi.order.domain.pay.dto.CreatePaymentOutDTO.CreatePaymentOutDTOBuilder;
import com.hozzi.order.domain.pay.dto.ReadPaymentOutDTO;
import com.hozzi.order.domain.pay.dto.ReadPaymentOutDTO.ReadPaymentOutDTOBuilder;
import com.hozzi.order.domain.pay.entity.Payment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T17:24:55+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PayMapperImpl implements PayMapper {

    @Override
    public ReadPaymentOutDTO toReadPaymentOutDTO(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        ReadPaymentOutDTOBuilder readPaymentOutDTO = ReadPaymentOutDTO.builder();

        readPaymentOutDTO.paymentId( payment.getPaymentId() );
        readPaymentOutDTO.paymentName( payment.getPaymentName() );
        readPaymentOutDTO.state( payment.getState() );
        readPaymentOutDTO.discountRate( payment.getDiscountRate() );
        readPaymentOutDTO.rewardRate( payment.getRewardRate() );
        readPaymentOutDTO.createAt( payment.getCreateAt() );
        readPaymentOutDTO.updateAt( payment.getUpdateAt() );
        readPaymentOutDTO.cancelAt( payment.getCancelAt() );

        return readPaymentOutDTO.build();
    }

    @Override
    public CreatePaymentOutDTO toCreatePaymentOutDTO(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        CreatePaymentOutDTOBuilder createPaymentOutDTO = CreatePaymentOutDTO.builder();

        createPaymentOutDTO.paymentId( payment.getPaymentId() );
        createPaymentOutDTO.paymentName( payment.getPaymentName() );
        createPaymentOutDTO.state( payment.getState() );
        createPaymentOutDTO.discountRate( payment.getDiscountRate() );
        createPaymentOutDTO.rewardRate( payment.getRewardRate() );
        createPaymentOutDTO.createAt( payment.getCreateAt() );
        createPaymentOutDTO.updateAt( payment.getUpdateAt() );
        createPaymentOutDTO.cancelAt( payment.getCancelAt() );

        return createPaymentOutDTO.build();
    }
}
