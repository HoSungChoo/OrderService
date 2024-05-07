package com.hozzi.order.domain.order.dto;

import com.hozzi.order.domain.order.enumerate.OmType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderByAdminOutDTO {
    Long orderId;
    Long userId;
    OmType omType;
}
