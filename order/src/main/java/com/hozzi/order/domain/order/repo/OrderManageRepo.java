package com.hozzi.order.domain.order.repo;

import com.hozzi.order.domain.order.entity.OrderManage;
import com.hozzi.order.domain.order.repo.custom.CustomOrderManageRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderManageRepo extends JpaRepository<OrderManage, Long>, CustomOrderManageRepo {

}
