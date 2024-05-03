package com.hozzi.order.domain.store.repo;

import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.repo.custom.CustomMenuRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<Menu, Long>, CustomMenuRepo {
}
