package com.hozzi.order.domain.store.entity;

import com.hozzi.order.domain.user.entity.User;
import com.hozzi.order.global.enumerate.State;
import com.hozzi.order.domain.store.enumerate.StoreType;
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
@Table(schema = "root", name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    @Column(nullable = false)
    private String storeName;
    @Column(nullable = false)
    private StoreType storeType;
    @Column(nullable = false)
    private State state;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createAt;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
    @Column(nullable = false)
    private LocalDateTime cancelAt;
    // relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
