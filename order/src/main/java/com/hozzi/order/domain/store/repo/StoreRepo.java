package com.hozzi.order.domain.store.repo;

import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.store.repo.custom.CustomStoreRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long>, CustomStoreRepo {
}
