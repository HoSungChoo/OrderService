package com.hozzi.order.domain.user.dto;

import com.hozzi.order.domain.user.enumerate.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateUserInDTO {
    private Long userId;
    private Gender gender;
    private String userName;
    private Integer age;
}
