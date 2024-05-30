package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.user.dto.*;

public interface WalletService {
    ReadWalletOutDTOs readWallet(Long userId) throws Exception;
    CreateWalletOutDTO createWallet(CreateWalletInDTO createWalletInDTO) throws Exception;
    DeleteWalletOutDTO deleteWallet(DeleteWalletInDTO deleteWalletInDTO) throws Exception;
}
