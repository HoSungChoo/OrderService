package com.hozzi.order.domain.user.api;

import com.hozzi.order.domain.user.dto.ReadUserOutDTO;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.service.BasketService;
import com.hozzi.order.domain.user.service.impl.BasketServiceImpl;
import com.hozzi.order.domain.user.service.impl.UserServiceImpl;
import com.hozzi.order.domain.user.service.impl.WalletServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
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
                .andReturn();
    }
    @Test
    @DisplayName("readUser_NotExistUserId_Exception")
    void readUser_NotExistUserId_Exception() throws Exception {
        given(userService.readUser(100L)).willThrow(new IllegalArgumentException());

        mockMvc.perform(get("/user/" + "100"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException))
                .andReturn();
    }
}
