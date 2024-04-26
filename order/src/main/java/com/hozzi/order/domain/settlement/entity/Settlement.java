package com.hozzi.order.domain.settlement.entity;

import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.settlement.enumerate.SettlementType;
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
    @CreatedDate
    private LocalDateTime createAt;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
    // relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
