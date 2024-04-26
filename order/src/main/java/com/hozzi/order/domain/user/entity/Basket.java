package com.hozzi.order.domain.user.entity;

import com.hozzi.order.domain.store.entity.Menu;
import com.hozzi.order.domain.store.entity.Store;
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
@Table(schema = "root", name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long basketId;
    @Column(nullable = false)
    private Long amount;
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
    @JoinColumn(name = "store_id")
    private Store store;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
