package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.pay.repo.PayRepo;
import com.hozzi.order.domain.pay.service.impl.PayServiceImpl;
import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import com.hozzi.order.domain.user.service.impl.UserServiceImpl;
import com.hozzi.order.domain.user.service.impl.WalletServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
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
    @DisplayName("readUser_Normal_Success")
    void readUser_Normal_Success() throws Exception {
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
    @DisplayName("readUser_NotExistUserId_Exception")
    void readUser_NotExistUserId_Exception() throws Exception {
        Mockito.when(userRepo.findById(100L))
                .thenThrow(new IllegalArgumentException("Bad Request"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.readUser(100L));
    }

    @Test
    @DisplayName("updateUser_Normal_Success")
    void updateUser_Normal_Success() throws Exception {
        // given
        LocalDateTime createDate = LocalDateTime.now();
        LocalDateTime updateDate = LocalDateTime.now();

        UpdateUserInDTO updateUserInDTO = UpdateUserInDTO.builder()
                .userId(100L)
                .gender(Gender.Male)
                .userName("hozzi")
                .age(20)
                .build();

        Mockito.when(userRepo.findById(updateUserInDTO.getUserId()))
                .thenReturn(Optional.of(User.builder()
                        .userId(100L)
                        .userName("hozzi_origin")
                        .userType(UserType.USER)
                        .age(30)
                        .point(200L)
                        .balance(200L)
                        .gender(Gender.Female)
                        .createAt(createDate)
                        .updateAt(updateDate)
                        .build()));

        // when
        UpdateUserOutDTO updateUserOutDTO = userService.updateUser(updateUserInDTO);

        // then
        Assertions.assertEquals(updateUserOutDTO.getUserId(), 100L);
        Assertions.assertEquals(updateUserOutDTO.getGender(), Gender.Male);
        Assertions.assertEquals(updateUserOutDTO.getUserName(), "hozzi");
        Assertions.assertEquals(updateUserOutDTO.getAge(), 20);
        Assertions.assertEquals(updateUserOutDTO.getUserType(), UserType.USER);
        Assertions.assertEquals(updateUserOutDTO.getBalance(), 200L);
        Assertions.assertEquals(updateUserOutDTO.getPoint(), 200L);
        Assertions.assertEquals(updateUserOutDTO.getCreateAt(), createDate);
        Assertions.assertEquals(updateUserOutDTO.getUpdateAt(), updateDate);

        verify(userRepo, times(1)).findById(100L);
    }

    @Test
    @DisplayName("updateUser_NotExistUserId_Exception")
    void updateUser_NotExistUserId_Exception() {
        UpdateUserInDTO updateUserInDTO = UpdateUserInDTO.builder()
                .userId(100L)
                .gender(Gender.Male)
                .userName("hozzi")
                .age(20)
                .build();

        Mockito.when(userRepo.findById(updateUserInDTO.getUserId()))
                .thenThrow(new IllegalArgumentException("Bad Request"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.updateUser(updateUserInDTO));

        verify(userRepo, times(1)).findById(100L);
    }

    @Test
    @DisplayName("deleteUser_Normal_Success")
    void deleteUser_Normal_Success() throws Exception {
        // given
        LocalDateTime createDate = LocalDateTime.now();
        LocalDateTime updateDate = LocalDateTime.now();

        DeleteUserInDTO deleteUserInDTO = DeleteUserInDTO.builder()
                .userId(100L)
                .build();

        Mockito.when(userRepo.findById(deleteUserInDTO.getUserId()))
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
        DeleteUserOutDTO deleteUserOutDTO = userService.deleteUser(deleteUserInDTO);

        // then
        Assertions.assertEquals(deleteUserOutDTO.getUserId(), 100L);
        Assertions.assertEquals(deleteUserOutDTO.getUserName(), "hozzi");
        Assertions.assertEquals(deleteUserOutDTO.getUserType(), UserType.QUIT);
        Assertions.assertEquals(deleteUserOutDTO.getAge(), 20);
        Assertions.assertEquals(deleteUserOutDTO.getPoint(), 0L);
        Assertions.assertEquals(deleteUserOutDTO.getBalance(), 0L);
        Assertions.assertEquals(deleteUserOutDTO.getGender(), Gender.Male);
        Assertions.assertEquals(deleteUserOutDTO.getCreateAt(), createDate);
        Assertions.assertEquals(deleteUserOutDTO.getUpdateAt(), updateDate);

        verify(userRepo).findById(100L);
    }

    @Test
    @DisplayName("deleteUser_NotExistUserId_Exception")
    void deleteUser_NotExistUserId_Exception() {
        DeleteUserInDTO deleteUserInDTO = DeleteUserInDTO.builder()
                .userId(100L)
                .build();

        Mockito.when(userRepo.findById(deleteUserInDTO.getUserId()))
                .thenThrow(new IllegalArgumentException("Bad Request"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.deleteUser(deleteUserInDTO));

        verify(userRepo, times(1)).findById(100L);
    }
}