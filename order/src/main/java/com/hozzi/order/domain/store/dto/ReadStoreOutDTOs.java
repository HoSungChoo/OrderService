package com.hozzi.order.domain.store.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadStoreOutDTOs {
    List<ReadStoreOutDTO> stores;
}
