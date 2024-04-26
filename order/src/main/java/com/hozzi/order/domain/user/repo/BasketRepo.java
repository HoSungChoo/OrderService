package com.hozzi.order.domain.user.repo;

import com.hozzi.order.domain.user.dto.ReadBasketOutDTO;
import com.hozzi.order.domain.user.entity.Basket;
import com.hozzi.order.domain.user.repo.custom.CustomBasketRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Long>, CustomBasketRepo {

}
