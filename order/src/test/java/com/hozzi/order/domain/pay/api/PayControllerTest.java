package com.hozzi.order.domain.pay.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hozzi.order.domain.pay.dto.ReadPaymentOutDTO;
import com.hozzi.order.domain.pay.dto.ReadPaymentOutDTOs;
import com.hozzi.order.domain.pay.service.PayService;
import com.hozzi.order.global.enumerate.State;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

@WebMvcTest(PayController.class)
class PayControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    PayService payService;
    @Test
    @DisplayName("readPayments_Normal_Success")
    void readPayments_Normal_Success() throws Exception{
        List<ReadPaymentOutDTO> readPaymentOutDTOS = new ArrayList<>();

        readPaymentOutDTOS.add(ReadPaymentOutDTO.builder()
                        .paymentId(1L)
                        .paymentName("google pay")
                        .state(State.ENROLL)
                        .discountRate(0.1F)
                        .rewardRate(0.1F)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .cancelAt(LocalDateTime.of(2999, 12, 31, 0, 0, 0))
                .build());

        readPaymentOutDTOS.add(ReadPaymentOutDTO.builder()
                .paymentId(2L)
                .paymentName("samsung pay")
                .state(State.ENROLL)
                .discountRate(0.2F)
                .rewardRate(0.2F)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .cancelAt(LocalDateTime.of(2999, 12, 31, 0, 0, 0))
                .build());

        readPaymentOutDTOS.add(ReadPaymentOutDTO.builder()
                .paymentId(3L)
                .paymentName("naver pay")
                .state(State.CANCEL)
                .discountRate(0.3F)
                .rewardRate(0.3F)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .cancelAt(LocalDateTime.now())
                .build());

        given(payService.readPayments())
                .willReturn(ReadPaymentOutDTOs.builder().payments(readPaymentOutDTOS).build());

        mockMvc.perform(get("/pay"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.payments[0].paymentId").exists())
                .andExpect(jsonPath("$.payments[0].paymentName").exists())
                .andExpect(jsonPath("$.payments[0].state").exists())
                .andExpect(jsonPath("$.payments[0].discountRate").exists())
                .andExpect(jsonPath("$.payments[0].rewardRate").exists())
                .andExpect(jsonPath("$.payments[0].createAt").exists())
                .andExpect(jsonPath("$.payments[0].updateAt").exists())
                .andExpect(jsonPath("$.payments[0].cancelAt").exists())
                .andExpect(jsonPath("$.payments[1].paymentId").exists())
                .andExpect(jsonPath("$.payments[1].paymentName").exists())
                .andExpect(jsonPath("$.payments[1].state").exists())
                .andExpect(jsonPath("$.payments[1].discountRate").exists())
                .andExpect(jsonPath("$.payments[1].rewardRate").exists())
                .andExpect(jsonPath("$.payments[1].createAt").exists())
                .andExpect(jsonPath("$.payments[1].updateAt").exists())
                .andExpect(jsonPath("$.payments[1].cancelAt").exists())
                .andExpect(jsonPath("$.payments[2].paymentId").exists())
                .andExpect(jsonPath("$.payments[2].paymentName").exists())
                .andExpect(jsonPath("$.payments[2].state").exists())
                .andExpect(jsonPath("$.payments[2].discountRate").exists())
                .andExpect(jsonPath("$.payments[2].rewardRate").exists())
                .andExpect(jsonPath("$.payments[2].createAt").exists())
                .andExpect(jsonPath("$.payments[2].updateAt").exists())
                .andExpect(jsonPath("$.payments[2].cancelAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("readPayment_NotExistPaymentId_Exception")
    void readPayment_NotExistPaymentId_Exception() {

    }

    @Test
    @DisplayName("readPayment_Normal_Success")
    void readPayment_Normal_Success() {

    }
    @Test
    @DisplayName("createPayment_Normal_Success")
    void createPayment_Normal_Success() {
    }

    @Test
    @DisplayName("createPayment_DuplicationPaymentName_Exception")
    void createPayment_DuplicationPaymentName_Exception() {

    }

    @Test
    @DisplayName("deletePayment_Normal_Success")
    void deletePayment_Normal_Success() {
    }

    @Test
    @DisplayName("deletePayment_NotExistPaymentId_Exception")
    void deletePayment_NotExistPaymentId_Exception() {

    }
}