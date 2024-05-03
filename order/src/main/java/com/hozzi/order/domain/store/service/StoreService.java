package com.hozzi.order.domain.store.service;

import com.hozzi.order.domain.store.dto.*;

public interface StoreService {
    ReadStoreOutDTOs readStore(Long userId);
    CreateStoreOutDTO createStore(CreateStoreInDTO createStoreInDTO);
    UpdateStoreOutDTO updateStore(UpdateStoreInDTO updateStoreInDTO);
}
