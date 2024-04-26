package com.hozzi.order.domain.user.repo;

import com.hozzi.order.domain.user.dto.ReadWalletOutDTO;
import com.hozzi.order.domain.user.entity.Wallet;
import com.hozzi.order.domain.user.repo.custom.CustomWalletRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Long>, CustomWalletRepo {
}
