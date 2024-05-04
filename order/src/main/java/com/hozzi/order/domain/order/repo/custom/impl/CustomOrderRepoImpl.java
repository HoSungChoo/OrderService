package com.hozzi.order.domain.order.repo.custom.impl;

import com.hozzi.order.domain.order.dto.ReadOrderManageOutDTO;
import com.hozzi.order.domain.order.entity.QOrder;
import com.hozzi.order.domain.order.entity.QOrderManage;
import com.hozzi.order.domain.order.repo.custom.CustomOrderRepo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class CustomOrderRepoImpl implements CustomOrderRepo {
    @PersistenceContext
    EntityManager em;
    private final QOrder qOrder = QOrder.order;
    private final QOrderManage qOrderManage = QOrderManage.orderManage;

}
