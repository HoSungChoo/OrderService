package com.hozzi.order.entity;

import com.hozzi.order.enumerate.Gender;
import com.hozzi.order.enumerate.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private UserType userType;
    @Column(nullable = false)
    private Long balance;
    @Column(nullable = false)
    private Long point;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
