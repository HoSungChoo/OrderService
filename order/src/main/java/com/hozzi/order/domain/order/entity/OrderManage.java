package com.hozzi.order.domain.order.entity;

import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.domain.order.enumerate.OmType;
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
@Table(schema = "root", name = "order_manage")
public class OrderManage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderManageId;
    @Column(nullable = false)
    private OmType omType;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createAt;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
    // relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
