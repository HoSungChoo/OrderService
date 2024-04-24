package com.hozzi.order.domain.store.dto;

import com.hozzi.order.global.enumerate.State;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadMenuOutDTO {
    private Long menuId;
    private String menuName;
    private Long menuPrice;
    private State state;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime cancelAt;
}
