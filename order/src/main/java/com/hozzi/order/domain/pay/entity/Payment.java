package com.hozzi.order.domain.pay.entity;

import com.hozzi.order.global.enumerate.State;
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
@Table(schema = "root", name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long paymentId;
    @Column(nullable = false)
    private String paymentName;
    @Column(nullable = false)
    private State state;
    @Column(nullable = false)
    private float discountRate;
    @Column(nullable = false)
    private float rewardRate;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createAt;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
    @Column(nullable = false)
    private LocalDateTime cancelAt;
}
