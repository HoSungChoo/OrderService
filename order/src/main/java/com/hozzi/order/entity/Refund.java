package com.hozzi.order.entity;

import com.hozzi.order.enumerate.RefundType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "root", name = "refund")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    private LocalDateTime createAt;
    @Column(nullable = false)
    private LocalDateTime updateAt;
    // relation
    @ManyToOne(optional = false)
    @JoinColumn(name = "custom_id")
    private User custom;
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private User owner;
}
