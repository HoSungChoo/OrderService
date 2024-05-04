package com.hozzi.order.domain.order.repo;

import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.order.repo.custom.CustomOrderRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>, CustomOrderRepo {
}
