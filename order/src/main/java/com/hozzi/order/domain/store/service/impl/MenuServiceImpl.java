package com.hozzi.order.domain.store.service.impl;

import com.hozzi.order.domain.store.dto.*;
import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.mapper.MenuMapper;
import com.hozzi.order.domain.store.repo.MenuRepo;
import com.hozzi.order.domain.store.repo.StoreRepo;
import com.hozzi.order.domain.store.service.MenuService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepo menuRepo;
    private final StoreRepo storeRepo;
    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuRepo menuRepo, StoreRepo storeRepo, MenuMapper menuMapper) {
        this.menuRepo = menuRepo;
        this.storeRepo = storeRepo;
        this.menuMapper = menuMapper;
    }

    @Override
    public ReadMenuOutDTOs readMenu(Long storeId) {
        List<ReadMenuOutDTO> readMenuOutDTOs = menuRepo.findByStoreIdCustom(storeId).orElseThrow(()->new IllegalArgumentException("Not exist storeId"));

        return ReadMenuOutDTOs.builder().menu(readMenuOutDTOs).build();
    }

    @Override
    public CreateMenuOutDTO createMenu(CreateMenuInDTO createMenuInDTO) {
        Menu menu = Menu.builder()
                .menuName(createMenuInDTO.getMenuName())
                .state(createMenuInDTO.getState())
                .store(storeRepo.findById(createMenuInDTO.getStoreId()).orElseThrow(()->new IllegalArgumentException("Bad Request")))
                .cancelAt(LocalDateTime.of(2999, 12, 31, 0, 0, 0))
                .build();

        menuRepo.save(menu);

        return menuMapper.toCreateMenuOutDTO(menu);
    }

    @Override
    public UpdateMenuOutDTO updateMenu(UpdateMenuInDTO updateMenuInDTO) {
        Menu menu = menuRepo.findById(updateMenuInDTO.getMenuId()).orElseThrow(()->new IllegalArgumentException("Not exist MenuId"));

        menu.setMenuName(updateMenuInDTO.getMenuName());
        menu.setMenuPrice(updateMenuInDTO.getMenuPrice());
        menu.setState(updateMenuInDTO.getState());
        menu.setStore(storeRepo.findById(updateMenuInDTO.getStoreId()).orElseThrow(()->new IllegalArgumentException("Not exist StoreId")));

        return menuMapper.toUpdateMenuOutDTO(menu);
    }
}
