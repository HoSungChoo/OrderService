package com.hozzi.order.domain.order.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteOrderPartInDTO {
    private Long orderId;
    private Long odId;
    private Long userId;
}
