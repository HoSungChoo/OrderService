package com.hozzi.order.domain.order.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hozzi.order.domain.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    OrderService orderService;
    @Test
    @DisplayName("")
    void readOrderManage_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void readOrderManage_NotExistOrderId_Exception() {
    }
    @Test
    @DisplayName("")
    void createOrder_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void createOrderUsingBasket_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void updateOrderCustom_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void updateOrderCustom_NotExistOrderId_Exception() {
    }
    @Test
    @DisplayName("")
    void updateOrderCustom_NotQualifiedUserId_Exception() {
    }
    @Test
    @DisplayName("")
    void updateOrderOwner_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void updateOrderOwner_NotExistOrderId_Exception() {
    }
    @Test
    @DisplayName("")
    void updateOrderOwner_NotQualifiedUserId_Exception() {
    }
    @Test
    @DisplayName("")
    void updateOrderAdmin_Normal_Success() {
    }
    @Test
    @DisplayName("")
    void updateOrderAdmin_NotExistOrderId_Exception() {
    }
    @Test
    @DisplayName("")
    void updateOrderAdmin_NotQualifiedUserId_Exception() {
    }
}