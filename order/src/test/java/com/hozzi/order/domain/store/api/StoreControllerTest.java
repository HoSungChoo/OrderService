package com.hozzi.order.domain.store.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hozzi.order.domain.store.dto.*;
import com.hozzi.order.domain.store.enumerate.StoreType;
import com.hozzi.order.domain.store.service.MenuService;
import com.hozzi.order.domain.store.service.StoreService;
import com.hozzi.order.global.enumerate.State;
import org.hibernate.sql.Update;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.net.ssl.SSLEngineResult;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("readStore_Normal_Success")
    void readStore_Normal_Success() throws Exception {
        Long userId = 100L;
        List<ReadStoreOutDTO> readStoreOutDTOS = new ArrayList<>();

        readStoreOutDTOS.add(ReadStoreOutDTO.builder()
                .storeId(1L)
                .storeName("store 1L")
                .storeType(StoreType.SNACK)
                .state(State.ENROLL)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .cancelAt(LocalDateTime.now())
                .build());

        readStoreOutDTOS.add(ReadStoreOutDTO.builder()
                .storeId(2L)
                .storeName("store 2L")
                .storeType(StoreType.CHINESE)
                .state(State.ENROLL)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .cancelAt(LocalDateTime.now())
                .build());

        given(storeService.readStore(userId))
                .willReturn(ReadStoreOutDTOs
                        .builder()
                        .stores(readStoreOutDTOS)
                        .build());

        mockMvc.perform(get("/pay/" + 100))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stores[0].storeId").exists())
                .andExpect(jsonPath("$.stores[0].storeName").exists())
                .andExpect(jsonPath("$.stores[0].storeType").exists())
                .andExpect(jsonPath("$.stores[0].state").exists())
                .andExpect(jsonPath("$.stores[0].createAt").exists())
                .andExpect(jsonPath("$.stores[0].updateAt").exists())
                .andExpect(jsonPath("$.stores[0].cancelAt").exists())
                .andExpect(jsonPath("$.stores[1].storeId").exists())
                .andExpect(jsonPath("$.stores[1].storeName").exists())
                .andExpect(jsonPath("$.stores[1].storeType").exists())
                .andExpect(jsonPath("$.stores[1].state").exists())
                .andExpect(jsonPath("$.stores[1].createAt").exists())
                .andExpect(jsonPath("$.stores[1].updateAt").exists())
                .andExpect(jsonPath("$.stores[1].cancelAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("createStore_Normal_Success")
    void createStore_Normal_Success() throws Exception {
        CreateStoreInDTO createStoreInDTO = CreateStoreInDTO.builder()
                .userId(100L)
                .storeType(StoreType.KOREAN)
                .storeName("store Name")
                .state(State.ENROLL)
                .build();

        given(storeService.createStore(createStoreInDTO))
                .willReturn(CreateStoreOutDTO.builder()
                        .storeId(200L)
                        .storeType(StoreType.KOREAN)
                        .storeName("store Name")
                        .state(State.ENROLL)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .cancelAt(LocalDateTime.now())
                        .build());

        String content = objectMapper.writeValueAsString(createStoreInDTO);

        mockMvc.perform(post("/store")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.storeId").exists())
                .andExpect(jsonPath("$.storeName").exists())
                .andExpect(jsonPath("$.storeType").exists())
                .andExpect(jsonPath("$.state").exists())
                .andExpect(jsonPath("$.createAt").exists())
                .andExpect(jsonPath("$.updateAt").exists())
                .andExpect(jsonPath("$.cancelAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("updateStore_Normal_Success")
    void updateStore_Normal_Success() throws Exception {
        UpdateStoreInDTO updateStoreInDTO = UpdateStoreInDTO.builder()
                .storeId(200L)
                .userId(100L)
                .storeType(StoreType.KOREAN)
                .storeName("store Name")
                .state(State.ENROLL)
                .build();

        given(storeService.updateStore(updateStoreInDTO))
                .willReturn(UpdateStoreOutDTO.builder()
                        .storeId(200L)
                        .storeType(StoreType.KOREAN)
                        .storeName("store Name")
                        .state(State.ENROLL)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .cancelAt(LocalDateTime.now())
                        .build());

        String content = objectMapper.writeValueAsString(updateStoreInDTO);

        mockMvc.perform(put("/store")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.storeId").exists())
                .andExpect(jsonPath("$.storeType").exists())
                .andExpect(jsonPath("$.storeName").exists())
                .andExpect(jsonPath("$.state").exists())
                .andExpect(jsonPath("$.createAt").exists())
                .andExpect(jsonPath("$.updateAt").exists())
                .andExpect(jsonPath("$.cancelAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("updateStore_NotExistStoreId_Exception")
    void updateStore_NotExistStoreId_Exception() throws Exception {
        UpdateStoreInDTO updateStoreInDTO = UpdateStoreInDTO.builder()
                .storeId(200L)
                .userId(100L)
                .storeType(StoreType.KOREAN)
                .storeName("store Name")
                .state(State.ENROLL)
                .build();

        given(storeService.updateStore(updateStoreInDTO))
                .willThrow(new IllegalArgumentException("Not exist StoreId"));

        String content = objectMapper.writeValueAsString(updateStoreInDTO);

        mockMvc.perform(put("/store")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("updateStore_NotExistUserId_Exception")
    void updateStore_NotExistUserId_Exception() throws Exception {
        UpdateStoreInDTO updateStoreInDTO = UpdateStoreInDTO.builder()
                .storeId(200L)
                .userId(100L)
                .storeType(StoreType.KOREAN)
                .storeName("store Name")
                .state(State.ENROLL)
                .build();

        given(storeService.updateStore(updateStoreInDTO))
                .willThrow(new IllegalArgumentException("Not exist userId"));

        String content = objectMapper.writeValueAsString(updateStoreInDTO);

        mockMvc.perform(put("/store")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("updateStore_NotMatchedStoreIdAndUserId_Exception")
    void updateStore_NotMatchedStoreIdAndUserId_Exception() throws Exception {
        UpdateStoreInDTO updateStoreInDTO = UpdateStoreInDTO.builder()
                .storeId(200L)
                .userId(100L)
                .storeType(StoreType.KOREAN)
                .storeName("store Name")
                .state(State.ENROLL)
                .build();

        given(storeService.updateStore(updateStoreInDTO))
                .willThrow(new IllegalArgumentException("Not matched storeId and userId"));

        String content = objectMapper.writeValueAsString(updateStoreInDTO);

        mockMvc.perform(put("/store")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("readMenu_Normal_Success")
    void readMenu_Normal_Success() throws Exception {
        Long storeId = 100L;
        List<ReadMenuOutDTO> readMenuOutDTOS = new ArrayList<>();

        readMenuOutDTOS.add(ReadMenuOutDTO.builder()
                .menuId(100L)
                .menuName("menu Name 1")
                .menuPrice(10000L)
                .state(State.ENROLL)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .cancelAt(LocalDateTime.now())
                .build());

        readMenuOutDTOS.add(ReadMenuOutDTO.builder()
                .menuId(200L)
                .menuName("menu Name 2")
                .menuPrice(20000L)
                .state(State.ENROLL)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .cancelAt(LocalDateTime.now())
                .build());

        given(menuService.readMenu(storeId))
                .willReturn(ReadMenuOutDTOs.builder()
                        .menu(readMenuOutDTOS)
                        .build());

        mockMvc.perform(get("/store/menu/" + 100L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.menu[0].menuId").exists())
                .andExpect(jsonPath("$.menu[0].menuName").exists())
                .andExpect(jsonPath("$.menu[0].menuPrice").exists())
                .andExpect(jsonPath("$.menu[0].state").exists())
                .andExpect(jsonPath("$.menu[0].createAt").exists())
                .andExpect(jsonPath("$.menu[0].updateAt").exists())
                .andExpect(jsonPath("$.menu[0].cancelAt").exists())
                .andExpect(jsonPath("$.menu[1].menuId").exists())
                .andExpect(jsonPath("$.menu[1].menuName").exists())
                .andExpect(jsonPath("$.menu[1].menuPrice").exists())
                .andExpect(jsonPath("$.menu[1].state").exists())
                .andExpect(jsonPath("$.menu[1].createAt").exists())
                .andExpect(jsonPath("$.menu[1].updateAt").exists())
                .andExpect(jsonPath("$.menu[1].cancelAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("readMenu_NotExistStoreId")
    void readMenu_NotExistStoreId_Exception() throws Exception {
        Long storeId = 100L;

        given(menuService.readMenu(storeId))
                .willThrow(new IllegalArgumentException("Not exist storeId"));

        mockMvc.perform(get("/store/menu/" + storeId))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("createMenu_Normal_Success")
    void createMenu_Normal_Success() throws Exception {
        CreateMenuInDTO createMenuInDTO = CreateMenuInDTO.builder()
                .menuName("menu name")
                .storeId(100L)
                .menuPrice(10000L)
                .state(State.ENROLL)
                .build();

        given(menuService.createMenu(createMenuInDTO))
                .willReturn(CreateMenuOutDTO.builder()
                        .menuId(100L)
                        .menuName("menu name")
                        .storeId(100L)
                        .menuPrice(10000L)
                        .state(State.ENROLL)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .cancelAt(LocalDateTime.now())
                        .build());

        String content = objectMapper.writeValueAsString(createMenuInDTO);

        mockMvc.perform(post("/store/menu")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.menuId").exists())
                .andExpect(jsonPath("$.menuName").exists())
                .andExpect(jsonPath("$.storeId").exists())
                .andExpect(jsonPath("$.menuPrice").exists())
                .andExpect(jsonPath("$.state").exists())
                .andExpect(jsonPath("$.createAt").exists())
                .andExpect(jsonPath("$.updateAt").exists())
                .andExpect(jsonPath("$.cancelAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("updateMenu_Normal_Success")
    void updateMenu_Normal_Success() throws Exception {
        UpdateMenuInDTO updateMenuInDTO = UpdateMenuInDTO.builder()
                .menuId(100L)
                .menuName("menu name")
                .storeId(100L)
                .menuPrice(10000L)
                .state(State.ENROLL)
                .build();

        given(menuService.updateMenu(updateMenuInDTO))
                .willReturn(UpdateMenuOutDTO.builder()
                        .menuId(100L)
                        .menuName("menu name")
                        .storeId(100L)
                        .menuPrice(10000L)
                        .state(State.ENROLL)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .cancelAt(LocalDateTime.now())
                        .build());

        String content = objectMapper.writeValueAsString(updateMenuInDTO);

        mockMvc.perform(put("/store/menu")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.menuId").exists())
                .andExpect(jsonPath("$.menuName").exists())
                .andExpect(jsonPath("$.storeId").exists())
                .andExpect(jsonPath("$.menuPrice").exists())
                .andExpect(jsonPath("$.state").exists())
                .andExpect(jsonPath("$.createAt").exists())
                .andExpect(jsonPath("$.updateAt").exists())
                .andExpect(jsonPath("$.cancelAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("updateMenu_NotExistMenuId_Exception")
    void updateMenu_NotExistMenuId_Exception() throws Exception {
        UpdateMenuInDTO updateMenuInDTO = UpdateMenuInDTO.builder()
                .menuId(100L)
                .menuName("menu name")
                .storeId(100L)
                .menuPrice(10000L)
                .state(State.ENROLL)
                .build();

        given(menuService.updateMenu(updateMenuInDTO))
                .willThrow(new IllegalArgumentException("Not exist menuId"));

        String content = objectMapper.writeValueAsString(updateMenuInDTO);

        mockMvc.perform(put("/store/menu")
                .content(content)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("updateMenu_NotMatchedMenuIdAndStoreId_Exception")
    void updateMenu_NotMatchedMenuIdAndStoreId_Exception() throws Exception {
        UpdateMenuInDTO updateMenuInDTO = UpdateMenuInDTO.builder()
                .menuId(100L)
                .menuName("menu name")
                .storeId(100L)
                .menuPrice(10000L)
                .state(State.ENROLL)
                .build();

        given(menuService.updateMenu(updateMenuInDTO))
                .willThrow(new IllegalArgumentException("Not matched storeId and menuId"));

        String content = objectMapper.writeValueAsString(updateMenuInDTO);

        mockMvc.perform(put("/store/menu")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }
}