package com.hozzi.order.domain.order.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hozzi.order.domain.order.dto.*;
import com.hozzi.order.domain.order.enumerate.OmType;
import com.hozzi.order.domain.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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

@WebMvcTest(OrderController.class)
class OrderControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    OrderService orderService;

    @Test
    @DisplayName("")
    void readOrderManage_Normal_Success() throws Exception {
        List<ReadOrderManageOutDTO> readOrderManageOutDTOS = new ArrayList<>();

        readOrderManageOutDTOS.add(ReadOrderManageOutDTO.builder()
                .omId(100L)
                .omType(OmType.ORDER)
                .orderId(100L)
                .userId(100L)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build());

        given(orderService.readOrderManage(100L))
                .willReturn(ReadOrderManageOutDTOs.builder()
                        .orderManage(readOrderManageOutDTOS)
                        .build());

        mockMvc.perform(get("/order/" + 100))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderManage[0].omId").exists())
                .andExpect(jsonPath("$.orderManage[0].omType").exists())
                .andExpect(jsonPath("$.orderManage[0].orderId").exists())
                .andExpect(jsonPath("$.orderManage[0].userId").exists())
                .andExpect(jsonPath("$.orderManage[0].createAt").exists())
                .andExpect(jsonPath("$.orderManage[0].updateAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("readOrderManage_NotExistOrderId_Exception")
    void readOrderManage_NotExistOrderId_Exception() throws Exception {
        given(orderService.readOrderManage(100L))
                .willThrow(new IllegalArgumentException());

        mockMvc.perform(get("/order/" + 100))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("createOrder_Normal_Success")
    void createOrder_Normal_Success() throws Exception {
        CreateOrderInDTO createOrderInDTO = CreateOrderInDTO.builder()
                .walletId(100L)
                .storeId(100L)
                .menuId(100L)
                .amount(1)
                .build();

        given(orderService.createOrder(createOrderInDTO))
                .willReturn(CreateOrderOutDTO.builder()
                        .orderId(100L)
                        .balance(100L)
                        .reward(100L)
                        .createAt(LocalDateTime.now())
                        .build());

        String content = objectMapper.writeValueAsString(createOrderInDTO);

        mockMvc.perform(post("/order")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.balance").exists())
                .andExpect(jsonPath("$.reward").exists())
                .andExpect(jsonPath("$.createAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("createOrderUsingBasket_Normal_Success")
    void createOrderUsingBasket_Normal_Success() throws Exception {
        CreateOrderUsingBasketInDTO createOrderUsingBasketInDTO = CreateOrderUsingBasketInDTO.builder()
                .userId(100L)
                .walletId(100L)
                .build();

        List<CreateOrderOutDTO> createOrderOutDTOS = new ArrayList<>();

        createOrderOutDTOS.add(CreateOrderOutDTO.builder()
                .orderId(100L)
        .balance(100L)
        .reward(100L)
        .createAt(LocalDateTime.now())
                .build());

        given(orderService.createOrderUsingBasket(createOrderUsingBasketInDTO))
                .willReturn(CreateOrderUsingBasketOutDTOs.builder()
                        .results(createOrderOutDTOS)
                        .build());

        String content = objectMapper.writeValueAsString(createOrderUsingBasketInDTO);

        mockMvc.perform(post("/order/item")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results[0].orderId").exists())
                .andExpect(jsonPath("$.results[0].balance").exists())
                .andExpect(jsonPath("$.results[0].reward").exists())
                .andExpect(jsonPath("$.results[0].createAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("updateOrderCustom_Normal_Success")
    void updateOrderCustom_Normal_Success() throws Exception {
        UpdateOrderByCustomInDTO updateOrderByCustomInDTO = UpdateOrderByCustomInDTO.builder()
                .orderId(100L)
        .userId(100L)
        .omType(OmType.ORDER)
                .build();

        given(orderService.updateOrder(updateOrderByCustomInDTO))
                .willReturn(UpdateOrderByCustomOutDTO.builder()
                        .orderId(100L)
                        .userId(100L)
                        .omType(OmType.ORDER)
                        .build());

        String content = objectMapper.writeValueAsString(updateOrderByCustomInDTO);

        mockMvc.perform(post("/order/custom")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.omType").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("updateOrderCustom_NotExistOrderId_Exception")
    void updateOrderCustom_NotExistOrderId_Exception() throws Exception {
        UpdateOrderByCustomInDTO updateOrderByCustomInDTO = UpdateOrderByCustomInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .omType(OmType.ORDER)
                .build();

        given(orderService.updateOrder(updateOrderByCustomInDTO))
                .willThrow(new IllegalArgumentException("Not exist orderId"));

        String content = objectMapper.writeValueAsString(updateOrderByCustomInDTO);

        mockMvc.perform(post("/order/custom")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("updateOrderCustom_NotQualifiedUserId_Exception")
    void updateOrderCustom_NotQualifiedUserId_Exception() throws Exception {
        UpdateOrderByCustomInDTO updateOrderByCustomInDTO = UpdateOrderByCustomInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .omType(OmType.ORDER)
                .build();

        given(orderService.updateOrder(updateOrderByCustomInDTO))
                .willThrow(new IllegalArgumentException("Not qualified userId"));

        String content = objectMapper.writeValueAsString(updateOrderByCustomInDTO);

        mockMvc.perform(post("/order/custom")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("updateOrderOwner_Normal_Success")
    void updateOrderOwner_Normal_Success() throws Exception {
        UpdateOrderByOwnerInDTO updateOrderByOwnerInDTO = UpdateOrderByOwnerInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .omType(OmType.ORDER)
                .build();

        given(orderService.updateOrder(updateOrderByOwnerInDTO))
                .willReturn(UpdateOrderByOwnerOutDTO.builder()
                        .orderId(100L)
                        .userId(100L)
                        .omType(OmType.ORDER)
                        .build());

        String content = objectMapper.writeValueAsString(updateOrderByOwnerInDTO);

        mockMvc.perform(post("/order/owner")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.omType").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("updateOrderOwner_NotExistOrderId_Exception")
    void updateOrderOwner_NotExistOrderId_Exception() throws Exception {
        UpdateOrderByOwnerInDTO updateOrderByOwnerInDTO = UpdateOrderByOwnerInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .omType(OmType.ORDER)
                .build();

        given(orderService.updateOrder(updateOrderByOwnerInDTO))
                .willThrow(new IllegalArgumentException("not exist orderId"));

        String content = objectMapper.writeValueAsString(updateOrderByOwnerInDTO);

        mockMvc.perform(post("/order/owner")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("updateOrderOwner_NotQualifiedUserId_Exception")
    void updateOrderOwner_NotQualifiedUserId_Exception() throws Exception {
        UpdateOrderByOwnerInDTO updateOrderByOwnerInDTO = UpdateOrderByOwnerInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .omType(OmType.ORDER)
                .build();

        given(orderService.updateOrder(updateOrderByOwnerInDTO))
                .willThrow(new IllegalArgumentException("Not qualified userId"));

        String content = objectMapper.writeValueAsString(updateOrderByOwnerInDTO);

        mockMvc.perform(post("/order/owner")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("updateOrderAdmin_Normal_Success")
    void updateOrderAdmin_Normal_Success() throws Exception {
        UpdateOrderByAdminInDTO updateOrderByAdminInDTO = UpdateOrderByAdminInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .omType(OmType.ORDER)
                .build();

        given(orderService.updateOrder(updateOrderByAdminInDTO))
                .willReturn(UpdateOrderByAdminOutDTO.builder()
                        .orderId(100L)
                        .userId(100L)
                        .omType(OmType.ORDER)
                        .build());

        String content = objectMapper.writeValueAsString(updateOrderByAdminInDTO);

        mockMvc.perform(post("/order/admin")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.omType").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("updateOrderAdmin_NotExistOrderId_Exception")
    void updateOrderAdmin_NotExistOrderId_Exception() throws Exception {
        UpdateOrderByAdminInDTO updateOrderByAdminInDTO = UpdateOrderByAdminInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .omType(OmType.ORDER)
                .build();

        given(orderService.updateOrder(updateOrderByAdminInDTO))
                .willThrow(new IllegalArgumentException("not exist orderId"));

        String content = objectMapper.writeValueAsString(updateOrderByAdminInDTO);

        mockMvc.perform(post("/order/admin")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("updateOrderAdmin_NotQualifiedUserId_Exception")
    void updateOrderAdmin_NotQualifiedUserId_Exception() throws Exception {
        UpdateOrderByAdminInDTO updateOrderByAdminInDTO = UpdateOrderByAdminInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .omType(OmType.ORDER)
                .build();

        given(orderService.updateOrder(updateOrderByAdminInDTO))
                .willThrow(new IllegalArgumentException("Not qualified userId"));

        String content = objectMapper.writeValueAsString(updateOrderByAdminInDTO);

        mockMvc.perform(post("/order/admin")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }
}