package com.hozzi.order.entity;

import com.hozzi.order.enumerate.StoreType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "root", name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long storeId;
    @Column(nullable = false)
    private StoreType storeType;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private LocalDateTime updateAt;
    // relation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
