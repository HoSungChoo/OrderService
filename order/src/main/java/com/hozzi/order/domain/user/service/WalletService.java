package com.hozzi.order.domain.user.service;

import com.hozzi.order.domain.user.dto.CreateWalletInDTO;
import com.hozzi.order.domain.user.dto.CreateWalletOutDTO;
import com.hozzi.order.domain.user.dto.DeleteWalletInDTO;
import com.hozzi.order.domain.user.dto.ReadWalletOutDTOs;

public interface WalletService {
    ReadWalletOutDTOs readWallet(Long userId) throws Exception;
    CreateWalletOutDTO createWallet(CreateWalletInDTO createWalletInDTO) throws Exception;
    void deleteWallet(DeleteWalletInDTO deleteWalletInDTO) throws Exception;
}
