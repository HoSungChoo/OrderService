package com.hozzi.order.entity;

import com.hozzi.order.enumerate.OmType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "root", name = "order_manage")
public class OrderManage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderManageId;
    @Column(nullable = false)
    private OmType omType;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private LocalDateTime updateAt;
    // relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
