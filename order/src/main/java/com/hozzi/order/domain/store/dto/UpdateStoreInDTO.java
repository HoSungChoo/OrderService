package com.hozzi.order.domain.store.dto;

import com.hozzi.order.domain.store.enumerate.StoreType;
import com.hozzi.order.global.enumerate.State;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateStoreInDTO {
    private Long userId;
    private Long storeId;
    private String storeName;
    private StoreType storeType;
    private State state;
}
