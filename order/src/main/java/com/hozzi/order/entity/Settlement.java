package com.hozzi.order.entity;

import com.hozzi.order.enumerate.SettlementType;
import com.hozzi.order.enumerate.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "root", name = "settlements")
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long settlementId;
    @Column(nullable = false)
    private Long balance;
    @Column(nullable = false)
    private SettlementType settlementType;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private LocalDateTime updateAt;
    // relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
