package com.hozzi.order.domain.order.entity;

import com.hozzi.order.domain.store.entity.Store;
import com.hozzi.order.domain.user.entity.Wallet;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "root", name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    @Column(nullable = false)
    private Long balance;
    @Column(nullable = false)
    private Long reward;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createAt;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
    // relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
