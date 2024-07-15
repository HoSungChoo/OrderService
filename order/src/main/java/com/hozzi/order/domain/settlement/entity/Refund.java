package com.hozzi.order.domain.settlement.entity;

import com.hozzi.order.domain.order.entity.Order;
import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.settlement.enumerate.RefundType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "root", name = "refund")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refundId;
    @Column(nullable = false)
    private Long customBalance;
    @Column(nullable = false)
    private Long ownerBalance;
    @Column(nullable = false)
    private RefundType refundType;
    @Column(nullable = false)
    private String refundReason;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createAt;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
    // relation
    @ManyToOne(optional = false)
    @JoinColumn(name = "custom_id")
    private User custom;
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private User owner;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
