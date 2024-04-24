package com.hozzi.order.domain.pay.repo;

import com.hozzi.order.domain.pay.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepo extends JpaRepository<Payment, Long> {

}
