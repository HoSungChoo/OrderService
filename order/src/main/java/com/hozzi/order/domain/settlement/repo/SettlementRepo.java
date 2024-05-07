package com.hozzi.order.domain.settlement.repo;

import com.hozzi.order.domain.settlement.entity.Settlement;
import com.hozzi.order.domain.settlement.repo.custom.CustomSettlementRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepo extends JpaRepository<Settlement, Long>, CustomSettlementRepo {
}
