package com.hozzi.order.domain.store.dto;

import com.hozzi.order.global.enumerate.State;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class UpdateMenuInDTO {
    private Long menuId;
    private String menuName;
    private Long storeId;
    private Long menuPrice;
    private State state;
}
