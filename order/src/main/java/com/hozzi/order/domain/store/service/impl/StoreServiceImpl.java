package com.hozzi.order.domain.store.service.impl;

import com.hozzi.order.domain.store.dto.*;
import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.store.mapper.StoreMapper;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.store.service.StoreService;
import com.hozzi.order.domain.user.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepo storeRepo;
    private final UserRepo userRepo;

    public StoreServiceImpl(StoreRepo storeRepo, UserRepo userRepo) {
        this.storeRepo = storeRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ReadStoreOutDTOs readStore(Long userId) {
        List<ReadStoreOutDTO> readStoreOutDTOs = storeRepo.findAllByUserIdCustom(userId).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadStoreOutDTOs.builder().stores(readStoreOutDTOs).build();
    }

    @Override
    public CreateStoreOutDTO createStore(CreateStoreInDTO createStoreInDTO) {
        Store store = Store.builder()
                .storeName(createStoreInDTO.getStoreName())
                .storeType(createStoreInDTO.getStoreType())
                .state(createStoreInDTO.getState())
                .build();

        storeRepo.save(store);

        return StoreMapper.storeMapper.toCreateStoreOutDTO(store);
    }

    @Override
    public UpdateStoreOutDTO updateStore(UpdateStoreInDTO updateStoreInDTO) {
        Store store = storeRepo.findById(updateStoreInDTO.getStoreId()).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        store.setStoreName(updateStoreInDTO.getStoreName());
        store.setStoreType(updateStoreInDTO.getStoreType());
        store.setState(updateStoreInDTO.getState());
        store.setUser(userRepo.findById(updateStoreInDTO.getUserId()).orElseThrow(()->new IllegalArgumentException("Bad Request")));

        return StoreMapper.storeMapper.toUpdateStoreOutDTO(store);
    }
}
