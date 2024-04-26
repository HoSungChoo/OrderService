package com.hozzi.order.domain.user.service.impl;

import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.mapper.UserMapper;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.service.UserService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public ReadUserOutDTO readUser(long userId) throws Exception {
        User user = userRepo.findById(userId).orElseThrow(Exception::new);

        return UserMapper.userMapper.toReadUserOutDTO(user);
    }

    @Override
    // Repo 단에서 FlushMode 변경
    public UpdateUserOutDTO updateUser(UpdateUserInDTO updateUserInDTO) throws Exception {
        User user = userRepo.findById(updateUserInDTO.getUserId()).orElseThrow(Exception::new);

        user.setGender(updateUserInDTO.getGender());
        user.setUserName(updateUserInDTO.getUserName());
        user.setAge(updateUserInDTO.getAge());

        userRepo.flush();

        return UserMapper.userMapper.toUpdateUserOutDTO(user);
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
