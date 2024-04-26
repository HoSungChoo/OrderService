package com.hozzi.order.domain.order.dto;

import com.hozzi.order.domain.order.enumerate.OmType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReadOrderManageOutDTO {
    private Long omId;
    private OmType omType;
    private Long orderId;
    private Long userId;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
