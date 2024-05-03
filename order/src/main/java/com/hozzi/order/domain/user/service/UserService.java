package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.user.dto.*;

public interface UserService {
    ReadUserOutDTO readUser(Long userId) throws Exception;
    UpdateUserOutDTO updateUser(UpdateUserInDTO updateUserInDTO) throws Exception;
    DeleteUserOutDTO deleteUser(DeleteUserInDTO deleteUserInDTO) throws Exception;
}
