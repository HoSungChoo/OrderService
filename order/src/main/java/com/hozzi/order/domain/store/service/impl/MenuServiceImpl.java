package com.hozzi.order.domain.store.service.impl;

import com.hozzi.order.domain.store.dto.*;
import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.mapper.MenuMapper;
import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.store.service.MenuService;

import java.time.LocalDateTime;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    private final MenuRepo menuRepo;
    private final StoreRepo storeRepo;

    public MenuServiceImpl(MenuRepo menuRepo, StoreRepo storeRepo) {
        this.menuRepo = menuRepo;
        this.storeRepo = storeRepo;
    }

    @Override
    public ReadMenuOutDTOs readMenu(Long storeId) {
        List<ReadMenuOutDTO> readMenuOutDTOs = menuRepo.findByStoreIdCustom(storeId).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return ReadMenuOutDTOs.builder().menu(readMenuOutDTOs).build();
    }

    @Override
    public CreateMenuOutDTO createMenu(CreateMenuInDTO createMenuInDTO) {
        Menu menu = Menu.builder()
                .menuName(createMenuInDTO.getMenuName())
                .state(createMenuInDTO.getState())
                .store(storeRepo.findById(createMenuInDTO.getStoreId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .cancelAt(LocalDateTime.MAX)
                .build();

        menuRepo.save(menu);

        return MenuMapper.menuMapper.toCreateMenuOutDTO(menu);
    }

    @Override
    public UpdateMenuOutDTO updateMenu(UpdateMenuInDTO updateMenuInDTO) {
        Menu menu = menuRepo.findById(updateMenuInDTO.getMenuId()).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        menu.setMenuName(updateMenuInDTO.getMenuName());
        menu.setMenuPrice(updateMenuInDTO.getMenuPrice());
        menu.setState(updateMenuInDTO.getState());
        menu.setStore(storeRepo.findById(updateMenuInDTO.getStoreId()).orElseThrow(()->new IllegalArgumentException("Bad Request")));

        return MenuMapper.menuMapper.toUpdateMenuOutDTO(menu);
    }
}
