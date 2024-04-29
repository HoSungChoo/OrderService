package com.hozzi.order.domain.user.dto;

import com.hozzi.order.domain.user.enumerate.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class UpdateUserInDTO {
    private Long userId;
    private Gender gender;
    private String userName;
    private Integer age;
}
