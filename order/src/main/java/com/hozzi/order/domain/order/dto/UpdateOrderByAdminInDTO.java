package com.hozzi.order.domain.order.dto;

import com.hozzi.order.domain.order.enumerate.OmType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateOrderByAdminInDTO {
    private Long orderId;
    private Long userId;
    private OmType omType;
}
