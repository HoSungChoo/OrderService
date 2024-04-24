package com.hozzi.order.domain.store.dto;

import com.hozzi.order.domain.store.enumerate.StoreType;
import com.hozzi.order.global.enumerate.State;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStoreInDTO {
    private Long userId;
    private String storeName;
    private StoreType storeType;
    private State state;
}
