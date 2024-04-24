package com.hozzi.order.domain.settlement.repo;

import com.hozzi.order.domain.settlement.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepo extends JpaRepository<Settlement, Long> {
}
