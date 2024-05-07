package com.hozzi.order.domain.settlement.repo;

import com.hozzi.order.domain.settlement.entity.Refund;
import com.hozzi.order.domain.settlement.repo.custom.CustomRefundRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepo extends JpaRepository<Refund, Long>, CustomRefundRepo {
}
