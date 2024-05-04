package com.hozzi.order.domain.option.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOptionOutDTO {
    private Long optionId;
    private String optionName;
    private String detail;
    private float value;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
