package com.hozzi.order.domain.user.service.impl;

import com.hozzi.order.domain.pay.repo.PayRepo;
import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.entity.Wallet;
import com.hozzi.order.domain.user.mapper.WalletMapper;
import com.hozzi.order.domain.user.repo.UserRepo;
import com.hozzi.order.domain.user.repo.WalletRepo;
import com.hozzi.order.domain.user.service.WalletService;
import com.hozzi.order.global.enumerate.State;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    private final UserRepo userRepo;
    private final WalletRepo walletRepo;
    private final PayRepo payRepo;

    public WalletServiceImpl(UserRepo userRepo, WalletRepo walletRepo, PayRepo payRepo) {
        this.userRepo = userRepo;
        this.walletRepo = walletRepo;
        this.payRepo = payRepo;
    }

    @Override
    public ReadWalletOutDTOs readWallet(Long userId) throws Exception {
        List<ReadWalletOutDTO> readWalletOutDTO = walletRepo.findByUserId(userId).orElseThrow(Exception::new);

        return ReadWalletOutDTOs.builder().pay(readWalletOutDTO).build();
    }

    @Override
    public CreateWalletOutDTO createWallet(CreateWalletInDTO createWalletInDTO) throws Exception {
        Wallet wallet = Wallet.builder()
                .state(State.ENROLL)
                .user(userRepo.findById(createWalletInDTO.getUserId()).orElseThrow(Exception::new))
                .payment(payRepo.findById(createWalletInDTO.getPaymentId()).orElseThrow(Exception::new))
                .build();

        walletRepo.save(wallet);
        return WalletMapper.walletMapper.toCreateWalletOutDTO(wallet);
    }

    @Override
    public void deleteWallet(DeleteWalletInDTO deleteWalletInDTO) throws Exception {
        Wallet wallet = walletRepo.findBy(deleteWalletInDTO).orElseThrow(Exception::new);
        wallet.setState(State.CANCEL);

        walletRepo.flush();
    }
}
