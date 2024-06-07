package com.hozzi.order.domain.store.service.impl;

import com.hozzi.order.domain.store.dto.*;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.store.mapper.StoreMapper;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.store.service.StoreService;
import com.hozzi.order.domain.user.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepo storeRepo;
    private final UserRepo userRepo;
    private final StoreMapper storeMapper;

    public StoreServiceImpl(StoreRepo storeRepo, UserRepo userRepo, StoreMapper storeMapper) {
        this.storeRepo = storeRepo;
        this.userRepo = userRepo;
        this.storeMapper = storeMapper;
    }

    @Override
    public ReadStoreOutDTOs readStore(Long userId) {
        List<ReadStoreOutDTO> readStoreOutDTOs = storeRepo.findAllByUserIdCustom(userId).orElseThrow(() -> new IllegalArgumentException("Not exist userId"));

        return ReadStoreOutDTOs.builder().stores(readStoreOutDTOs).build();
    }

    @Override
    public CreateStoreOutDTO createStore(CreateStoreInDTO createStoreInDTO) {
        Store store = Store.builder()
                .storeName(createStoreInDTO.getStoreName())
                .storeType(createStoreInDTO.getStoreType())
                .state(createStoreInDTO.getState())
                .cancelAt(LocalDateTime.of(2999, 12, 31, 0, 0, 0))
                .user(userRepo.findById(createStoreInDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("Not Exist UserId")))
                .build();

        storeRepo.save(store);

        return storeMapper.toCreateStoreOutDTO(store);
    }

    @Override
    public UpdateStoreOutDTO updateStore(UpdateStoreInDTO updateStoreInDTO) {
        Store store = storeRepo.findById(updateStoreInDTO.getStoreId()).orElseThrow(() -> new IllegalArgumentException("Not exist storeId"));

        store.setStoreName(updateStoreInDTO.getStoreName());
        store.setStoreType(updateStoreInDTO.getStoreType());
        store.setState(updateStoreInDTO.getState());
        store.setUser(userRepo.findById(updateStoreInDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("Not exist userId")));

        return storeMapper.toUpdateStoreOutDTO(store);
    }
}
