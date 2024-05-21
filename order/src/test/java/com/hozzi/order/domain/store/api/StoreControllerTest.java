package com.hozzi.order.domain.store.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hozzi.order.domain.store.service.MenuService;
import com.hozzi.order.domain.store.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(StoreController.class)
class StoreControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    StoreService storeService;
    @MockBean
    MenuService menuService;
    @Test
    void readStore() {
        
    }

    @Test
    void createStore() {
    }

    @Test
    void updateStore() {
    }

    @Test
    void readMenu() {
    }

    @Test
    void createMenu() {
    }

    @Test
    void updateMenu() {
    }
}