package com.hozzi.order.domain.user.repo;

import com.hozzi.order.domain.user.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Long> {
}
