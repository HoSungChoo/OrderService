package com.hozzi.order.domain.pay.mapper;

import com.hozzi.order.domain.pay.dto.CreatePaymentOutDTO;
import com.hozzi.order.domain.pay.dto.DeletePaymentOutDTO;
import com.hozzi.order.domain.pay.dto.ReadPaymentOutDTO;
import com.hozzi.order.domain.pay.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PayMapper {
    ReadPaymentOutDTO toReadPaymentOutDTO(Payment payment);
    CreatePaymentOutDTO toCreatePaymentOutDTO(Payment payment);
    DeletePaymentOutDTO toDeletePaymentOutDTO(Payment payment);
}
