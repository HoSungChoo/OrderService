package com.hozzi.order.entity;

import com.hozzi.order.enumerate.SettlementType;
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
}
