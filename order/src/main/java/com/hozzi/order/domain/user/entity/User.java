package com.hozzi.order.domain.user.entity;

import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
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
@Table(schema = "root", name = "users")
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
    @CreatedDate
    private LocalDateTime createAt;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
}
