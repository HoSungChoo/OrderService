package com.hozzi.order.domain.settlement.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hozzi.order.domain.settlement.dto.*;
import com.hozzi.order.domain.settlement.enumerate.RefundType;
import com.hozzi.order.domain.settlement.enumerate.SettlementType;
import com.hozzi.order.domain.settlement.service.RefundService;
import com.hozzi.order.domain.settlement.service.SettlementService;
import com.hozzi.order.domain.user.api.UserController;
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
@WebMvcTest(SettlementController.class)
class SettlementControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    SettlementService settlementService;
    @MockBean
    RefundService refundService;

    @Test
    @DisplayName("createReward_Normal_Success")
    void createReward_Normal_Success() throws Exception {
        CreateRewardInDTO createRewardInDTO = CreateRewardInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .balance(100L)
                .build();

        given(settlementService.createReward(createRewardInDTO))
                .willReturn(CreateRewardOutDTO.builder()
                        .settlementId(100L)
                        .balance(100L)
                        .settlementType(SettlementType.REWARD)
                        .userId(100L)
                        .orderId(100L)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .build());

        String content = objectMapper.writeValueAsString(createRewardInDTO);

        mockMvc.perform(post("/settlement/reward")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").exists())
                .andExpect(jsonPath("$.settlementType").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.createAt").exists())
                .andExpect(jsonPath("$.updateAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("createPayout_Normal_Success")
    void createPayout_Normal_Success() throws Exception {
        CreatePayoutInDTO createPayoutInDTO = CreatePayoutInDTO.builder()
                .orderId(100L)
                .userId(100L)
                .balance(100L)
                .build();

        given(settlementService.createPayout(createPayoutInDTO))
                .willReturn(CreatePayoutOutDTO.builder()
                        .settlementId(100L)
                        .balance(100L)
                        .settlementType(SettlementType.PAYOUT)
                        .userId(100L)
                        .orderId(100L)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .build());

        String content = objectMapper.writeValueAsString(createPayoutInDTO);

        mockMvc.perform(post("/settlement/payout")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").exists())
                .andExpect(jsonPath("$.settlementType").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.createAt").exists())
                .andExpect(jsonPath("$.updateAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("createRefund_Normal_Success")
    void createRefund_Normal_Success() throws Exception {
        CreateRefundInDTO createRefundInDTO = CreateRefundInDTO.builder()
                .orderId(100L)
                .customId(100L)
                .ownerId(100L)
                .refundType(RefundType.BOTH)
                .customBalance(100L)
                .ownerBalance(100L)
                .refundReason("no reason")
                .build();

        given(refundService.createRefund(createRefundInDTO))
                .willReturn(CreateRefundOutDTO.builder()
                        .refundId(100L)
                        .orderId(100L)
                        .customId(100L)
                        .ownerId(100L)
                        .customBalance(100L)
                        .ownerBalance(100L)
                        .refundType(RefundType.BOTH)
                        .refundReason("no reason")
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .build());

        String content = objectMapper.writeValueAsString(createRefundInDTO);

        mockMvc.perform(post("/settlement/refund")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.refundId").exists())
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.customId").exists())
                .andExpect(jsonPath("$.ownerId").exists())
                .andExpect(jsonPath("$.customBalance").exists())
                .andExpect(jsonPath("$.ownerBalance").exists())
                .andExpect(jsonPath("$.refundType").exists())
                .andExpect(jsonPath("$.refundReason").exists())
                .andExpect(jsonPath("$.createAt").exists())
                .andExpect(jsonPath("$.updateAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("readReward_Normal_Success")
    void readReward_Normal_Success() throws Exception {
        List<ReadSettlementOutDTO> readSettlementOutDTOS = new ArrayList<>();

        readSettlementOutDTOS.add(ReadSettlementOutDTO.builder()
                .settlementId(100L)
                .userId(100L)
                .orderId(100L)
                .balance(100L)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build());

        readSettlementOutDTOS.add(ReadSettlementOutDTO.builder()
                .settlementId(200L)
                .userId(200L)
                .orderId(200L)
                .balance(200L)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build());

        given(settlementService.readReward("19960610", "20240522"))
                .willReturn(ReadSettlementOutDTOs.builder()
                        .settlements(readSettlementOutDTOS)
                        .build());

        mockMvc.perform(get("/settlement/reward?beginDate=19960610&endDate=20240522"))
                .andExpect(jsonPath("$.settlements[0].settlementId").exists())
                .andExpect(jsonPath("$.settlements[0].userId").exists())
                .andExpect(jsonPath("$.settlements[0].orderId").exists())
                .andExpect(jsonPath("$.settlements[0].balance").exists())
                .andExpect(jsonPath("$.settlements[0].createAt").exists())
                .andExpect(jsonPath("$.settlements[0].updateAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("readPayout_Normal_Success")
    void readPayout_Normal_Success() throws Exception {
        List<ReadSettlementOutDTO> readSettlementOutDTOS = new ArrayList<>();

        readSettlementOutDTOS.add(ReadSettlementOutDTO.builder()
                .settlementId(100L)
                .userId(100L)
                .orderId(100L)
                .balance(100L)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build());

        readSettlementOutDTOS.add(ReadSettlementOutDTO.builder()
                .settlementId(200L)
                .userId(200L)
                .orderId(200L)
                .balance(200L)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build());

        given(settlementService.readPayout("19960610", "20240522"))
                .willReturn(ReadSettlementOutDTOs.builder()
                        .settlements(readSettlementOutDTOS)
                        .build());

        mockMvc.perform(get("/settlement/payout?beginDate=19960610&endDate=20240522"))
                .andExpect(jsonPath("$.settlements[0].settlementId").exists())
                .andExpect(jsonPath("$.settlements[0].userId").exists())
                .andExpect(jsonPath("$.settlements[0].orderId").exists())
                .andExpect(jsonPath("$.settlements[0].balance").exists())
                .andExpect(jsonPath("$.settlements[0].createAt").exists())
                .andExpect(jsonPath("$.settlements[0].updateAt").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("readRefund_Normal_Success")
    void readRefund_Normal_Success() throws Exception {
        List<ReadRefundOutDTO> readRefundOutDTOS = new ArrayList<>();

        readRefundOutDTOS.add(ReadRefundOutDTO.builder()
                .refundId(100L)
                .customBalance(100L)
                .ownerBalance(100L)
                .refundType(RefundType.BOTH)
                .refundReason("no reason")
                .customId(100L)
                .ownerId(100L)
                .orderId(100L)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build());

        readRefundOutDTOS.add(ReadRefundOutDTO.builder()
                .refundId(200L)
                .customBalance(200L)
                .ownerBalance(200L)
                .refundType(RefundType.BOTH)
                .refundReason("no reason")
                .customId(200L)
                .ownerId(200L)
                .orderId(200L)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build());

        given(refundService.readRefund("19960610", "20240522"))
                .willReturn(ReadRefundOutDTOs.builder()
                        .refunds(readRefundOutDTOS)
                        .build());

        mockMvc.perform(get("/settlement/refund?beginDate=19960610&endDate=20240522"))
                .andExpect(jsonPath("$.refunds[0].refundId").exists())
                .andExpect(jsonPath("$.refunds[0].customBalance").exists())
                .andExpect(jsonPath("$.refunds[0].ownerBalance").exists())
                .andExpect(jsonPath("$.refunds[0].refundType").exists())
                .andExpect(jsonPath("$.refunds[0].refundReason").exists())
                .andExpect(jsonPath("$.refunds[0].customId").exists())
                .andExpect(jsonPath("$.refunds[0].ownerId").exists())
                .andExpect(jsonPath("$.refunds[0].orderId").exists())
                .andExpect(jsonPath("$.refunds[0].createAt").exists())
                .andExpect(jsonPath("$.refunds[0].updateAt").exists())
                .andDo(print());
    }
}