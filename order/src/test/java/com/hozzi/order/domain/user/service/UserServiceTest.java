package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.pay.repo.PayRepo;
import com.hozzi.order.domain.pay.service.impl.PayServiceImpl;
import com.hozzi.order.domain.user.dto.ReadUserOutDTO;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import com.hozzi.order.domain.user.service.impl.UserServiceImpl;
import com.hozzi.order.domain.user.service.impl.WalletServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserRepo userRepo = Mockito.mock(UserRepo.class);
    private WalletRepo walletRepo = Mockito.mock(WalletRepo.class);
    private PayRepo payRepo = Mockito.mock(PayRepo.class);
    private UserServiceImpl userService;

    @BeforeEach
    public void setUpTest() {
        userService = new UserServiceImpl(userRepo, walletRepo, payRepo);
    }

    @Test
    void readUser() throws Exception {
        // given
        LocalDateTime createDate = LocalDateTime.now();
        LocalDateTime updateDate = LocalDateTime.now();

        Mockito.when(userRepo.findById(100L))
                .thenReturn(Optional.of(User.builder()
                        .userId(100L)
                        .userName("hozzi")
                        .userType(UserType.USER)
                        .age(20)
                        .point(100L)
                        .balance(100L)
                        .gender(Gender.Male)
                        .createAt(createDate)
                        .updateAt(updateDate)
                        .build()));

        // when
        ReadUserOutDTO readUserOutDTO = userService.readUser(100L);

        // then
        Assertions.assertEquals(readUserOutDTO.getUserId(), 100L);
        Assertions.assertEquals(readUserOutDTO.getUserName(), "hozzi");
        Assertions.assertEquals(readUserOutDTO.getUserType(), UserType.USER);
        Assertions.assertEquals(readUserOutDTO.getAge(), 20);
        Assertions.assertEquals(readUserOutDTO.getPoint(), 100L);
        Assertions.assertEquals(readUserOutDTO.getBalance(), 100L);
        Assertions.assertEquals(readUserOutDTO.getGender(), Gender.Male);
        Assertions.assertEquals(readUserOutDTO.getCreateAt(), createDate);
        Assertions.assertEquals(readUserOutDTO.getUpdateAt(), updateDate);

        verify(userRepo).findById(100L);
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}