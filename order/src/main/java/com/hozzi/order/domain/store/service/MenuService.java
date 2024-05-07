package com.hozzi.order.domain.store.service;

import com.hozzi.order.domain.store.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface MenuService {
    ReadMenuOutDTOs readMenu(Long storeId);
    CreateMenuOutDTO createMenu(CreateMenuInDTO createMenuInDTO);
    UpdateMenuOutDTO updateMenu(UpdateMenuInDTO updateMenuInDTO);
}
