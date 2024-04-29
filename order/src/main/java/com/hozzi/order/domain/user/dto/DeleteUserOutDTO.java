package com.hozzi.order.domain.user.dto;

import com.hozzi.order.domain.user.enumerate.Gender;
import com.hozzi.order.domain.user.enumerate.UserType;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteUserOutDTO {
    private Long userId;
    private Gender gender;
    private String userName;
    private Integer age;
    private UserType userType;
    private Long balance;
    private Long point;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
