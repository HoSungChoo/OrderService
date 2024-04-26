package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.user.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    ReadUserOutDTO readUser(long userId) throws Exception;
    UpdateUserOutDTO updateUser(UpdateUserInDTO updateUserInDTO) throws Exception;
    void deleteUser(DeleteUserInDTO deleteUserInDTO) throws Exception;

    ReadBasketOutDTO readBasketByBasketId(Long basketId) throws Exception;
    ReadBasketOutDTOs readBasketByUserId(Long userId) throws Exception;
    CreateBasketOutDTO createBasket(CreateBasketInDTO createBasketInDTO) throws Exception;
    void deleteBasketByUserId(Long userId) throws Exception;
    void deleteBasketByBasketId(Long basketId) throws Exception;
}
