package com.hozzi.order.domain.user.service.impl;

import com.hozzi.order.domain.pay.repo.PayRepo;
import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.user.entity.Wallet;
import com.hozzi.order.domain.user.enumerate.UserType;
import com.hozzi.order.domain.user.mapper.UserMapper;
import com.hozzi.order.domain.user.mapper.WalletMapper;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import com.hozzi.order.domain.user.service.UserService;
import com.hozzi.order.global.enumerate.State;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final WalletRepo walletRepo;
    private final PayRepo payRepo;

    public UserServiceImpl(UserRepo userRepo, WalletRepo walletRepo, PayRepo payRepo) {
        this.userRepo = userRepo;
        this.walletRepo = walletRepo;
        this.payRepo = payRepo;
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
        User user = userRepo.findById(deleteUserInDTO.getUserId()).orElseThrow(Exception::new);
        user.setUserType(UserType.QUIT);

        userRepo.flush();
    }
}
