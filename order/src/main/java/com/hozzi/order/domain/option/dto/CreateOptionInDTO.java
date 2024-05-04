package com.hozzi.order.domain.option.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOptionInDTO {
    private String optionName;
    private String detail;
    private float value;
}
