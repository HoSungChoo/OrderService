package com.hozzi.order.domain.user.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.service.BasketService;
import com.hozzi.order.domain.user.service.impl.BasketServiceImpl;
import com.hozzi.order.domain.user.service.impl.UserServiceImpl;
import com.hozzi.order.domain.user.service.impl.WalletServiceImpl;
import com.hozzi.order.global.enumerate.State;
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

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    UserServiceImpl userService;
    @MockBean
    WalletServiceImpl walletService;
    @MockBean
    BasketServiceImpl basketService;

    @Test
    @DisplayName("readUser_Normal_Success")
    void readUser_Normal_Success() throws Exception {
        given(userService.readUser(100L))
                .willReturn(ReadUserOutDTO.builder()
                        .userId(100L)
                        .gender(Gender.Male)
                        .userName("Ho Sung")
                        .age(29)
                        .userType(UserType.USER)
                        .balance(100_000L)
                        .point(20_000L)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .build());

        mockMvc.perform(get("/user/" + "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.gender").exists())
                .andExpect(jsonPath("$.userName").exists())
                .andExpect(jsonPath("$.age").exists())
                .andExpect(jsonPath("$.userType").exists())
                .andExpect(jsonPath("$.balance").exists())
                .andExpect(jsonPath("$.point").exists())
                .andDo(print());

        verify(userService).readUser(100L);
    }

    @Test
    @DisplayName("readUser_NotExistUserId_Exception")
    void readUser_NotExistUserId_Exception() throws Exception {
        given(userService.readUser(100L)).willThrow(new IllegalArgumentException());

        mockMvc.perform(get("/user/" + "100"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("updateUser_Normal_Success")
    void updateUser_Normal_Success() throws Exception {
        UpdateUserInDTO updateUserInDTO = UpdateUserInDTO.builder()
                .userId(100L)
                .gender(Gender.Male)
                .userName("HoZzi")
                .age(29)
                .build();

        given(userService.updateUser(updateUserInDTO))
                .willReturn(UpdateUserOutDTO.builder()
                        .userId(100L)
                        .gender(Gender.Male)
                        .userName("HoZzi")
                        .age(29)
                        .userType(UserType.USER)
                        .balance(100_000L)
                        .point(20_000L)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .build());

        String content = objectMapper.writeValueAsString(updateUserInDTO);

        mockMvc.perform(put("/user")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.gender").exists())
                .andExpect(jsonPath("$.userName").exists())
                .andExpect(jsonPath("$.age").exists())
                .andExpect(jsonPath("$.userType").exists())
                .andExpect(jsonPath("$.balance").exists())
                .andExpect(jsonPath("$.point").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("updateUser_NotExistUserId_Exception")
    void updateUser_NotExistUserId_Exception() throws Exception {
        UpdateUserInDTO updateUserInDTO = UpdateUserInDTO.builder()
                .userId(100L)
                .gender(Gender.Male)
                .userName("Ho Sung")
                .age(29)
                .build();

        String content = objectMapper.writeValueAsString(updateUserInDTO);

        given(userService.updateUser(updateUserInDTO)).willThrow(new IllegalArgumentException());

        mockMvc.perform(put("/user")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("deleteUser_Normal_Success")
    void deleteUser_Normal_Success() throws Exception {
        DeleteUserInDTO deleteUserInDTO = DeleteUserInDTO.builder()
                .userId(100L)
                .build();

        String content = objectMapper.writeValueAsString(deleteUserInDTO);

        given(userService.deleteUser(deleteUserInDTO))
                .willReturn(DeleteUserOutDTO.builder()
                        .userId(100L)
                        .gender(Gender.Male)
                        .userName("Ho Sung")
                        .age(29)
                        .userType(UserType.QUIT)
                        .balance(0L)
                        .point(0L)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .build());

        mockMvc.perform(put("/user/exit")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.gender").exists())
                .andExpect(jsonPath("$.userName").exists())
                .andExpect(jsonPath("$.age").exists())
                .andExpect(jsonPath("$.userType").exists())
                .andExpect(jsonPath("$.balance").exists())
                .andExpect(jsonPath("$.point").exists())
                .andDo(print());
    }

    @Test
    @DisplayName("deleteUser_NotExistUserId_Exception")
    void deleteUser_NotExistUserId_Exception() throws Exception {
        DeleteUserInDTO deleteUserInDTO = DeleteUserInDTO.builder()
                .userId(100L)
                .build();

        String content = objectMapper.writeValueAsString(deleteUserInDTO);

        given(userService.deleteUser(deleteUserInDTO)).willThrow(new IllegalArgumentException());

        mockMvc.perform(put("/user/exit")
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("readWallet_Normal_Success")
    void readWallet_Normal_Success() throws Exception {
        ReadWalletOutDTO readWalletOutDTO = ReadWalletOutDTO.builder()
                .walletId(100L)
                .state(State.ENROLL)
                .paymentId(1L)
                .paymentName("HozziPay")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        List<ReadWalletOutDTO> readWalletOutDTOs = new ArrayList<>();
        readWalletOutDTOs.add(readWalletOutDTO);

        given(walletService.readWallet(100L))
                .willReturn(ReadWalletOutDTOs.builder()
                        .pay(readWalletOutDTOs)
                        .build());

        mockMvc.perform(get("/user/pay/" + "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pay[0].walletId").exists())
                .andExpect(jsonPath("$.pay[0].state").exists())
                .andExpect(jsonPath("$.pay[0].paymentId").exists())
                .andExpect(jsonPath("$.pay[0].paymentName").exists())
                .andExpect(jsonPath("$.pay[0].createAt").exists())
                .andExpect(jsonPath("$.pay[0].updateAt").exists())
                .andDo(print());

    }

    @Test
    @DisplayName("readWallet_NotExistUserId_Exception")
    void readWallet_NotExistUserId_Exception() throws Exception {
        given(walletService.readWallet(100L))
                .willThrow(new IllegalArgumentException());

        mockMvc.perform(get("/user/pay/" + "100"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }

    @Test
    @DisplayName("createWallet_Normal_Success")
    void createWallet_Normal_Success() throws Exception {
        CreateWalletInDTO createWalletInDTO = CreateWalletInDTO.builder()
                .userId(100L)
                .paymentId(100L)
                .build();

        given(walletService.createWallet(createWalletInDTO))
                .willReturn(CreateWalletOutDTO.builder()
                        .walletId(100L)
                        .state(State.ENROLL)
                        .userId(100L)
                        .createAt(LocalDateTime.now())
                        .updateAt(LocalDateTime.now())
                        .build());

        mockMvc.perform(get("/user/pay/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.walletId").exists())
                .andExpect(jsonPath("$.state").exists())
                .andExpect(jsonPath("$.userId").exists())
                .andExpect(jsonPath("$.createAt").exists())
                .andExpect(jsonPath("$.updateAt").exists())
                .andDo(print());
    }
}
