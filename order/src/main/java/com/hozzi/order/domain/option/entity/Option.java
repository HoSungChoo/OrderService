package com.hozzi.order.domain.option.entity;

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
@Table(schema = "root", name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long optionId;
    @Column(nullable = false, unique = true)
    private String optionName;
    @Column(nullable = false)
    private String detail;
    @Column(nullable = false)
    private float value;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createAt;
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updateAt;
}
