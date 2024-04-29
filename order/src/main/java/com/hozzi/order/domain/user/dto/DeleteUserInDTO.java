package com.hozzi.order.domain.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class DeleteUserInDTO {
    private Long userId;
}
