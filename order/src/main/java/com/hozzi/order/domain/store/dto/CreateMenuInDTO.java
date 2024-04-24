package com.hozzi.order.domain.store.dto;

import com.hozzi.order.global.enumerate.State;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMenuInDTO {
    private String menuName;
    private Long storeId;
    private Long menuPrice;
    private State state;
}
