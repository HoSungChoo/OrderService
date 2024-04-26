package com.hozzi.order.domain.store.entity;

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
@Table(schema = "root", name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long menuId;
    @Column(nullable = false)
    private String menuName;
    @Column(nullable = false)
    private Long menuPrice;
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
    @JoinColumn(name = "store_id")
    private Store store;
}
