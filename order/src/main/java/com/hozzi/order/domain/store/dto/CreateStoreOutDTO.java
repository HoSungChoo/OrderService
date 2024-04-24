package com.hozzi.order.domain.store.dto;

import com.hozzi.order.domain.store.enumerate.StoreType;
import com.hozzi.order.global.enumerate.State;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStoreOutDTO {
    private Long storeId;
    private String storeName;
    private StoreType storeType;
    private State state;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime cancelAt;
}
