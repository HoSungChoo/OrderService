package com.hozzi.order.domain.user.service.impl;

import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public ReadUserOutDTO readUser(long userId) throws Exception {
        return null;
    }

    @Override
    public UpdateUserOutDTO updateUser(UpdateUserInDTO updateUserInDTO) throws Exception {
        return null;
    }

    @Override
    public void deleteUser(DeleteUserInDTO deleteUserInDTO) throws Exception {

    }

    @Override
    public ReadWalletOutDTOs readWallet(Long userId) throws Exception {
        return null;
    }

    @Override
    public CreateWalletOutDTO createWallet(CreateWalletInDTO createWalletInDTO) throws Exception {
        return null;
    }

    @Override
    public void deleteWallet(DeleteWalletInDTO deleteWalletInDTO) throws Exception {

    }

    @Override
    public ReadBasketOutDTO readBasketByBasketId(Long basketId) throws Exception {
        return null;
    }

    @Override
    public ReadBasketOutDTOs readBasketByUserId(Long userId) throws Exception {
        return null;
    }

    @Override
    public CreateBasketOutDTO createBasket(CreateBasketInDTO createBasketInDTO) throws Exception {
        return null;
    }

    @Override
    public void deleteBasketByUserId(Long userId) throws Exception {

    }

    @Override
    public void deleteBasketByBasketId(Long basketId) throws Exception {

    }
}
