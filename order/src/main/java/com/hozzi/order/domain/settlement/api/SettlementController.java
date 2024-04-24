package com.hozzi.order.domain.settlement.api;

import com.hozzi.order.domain.store.dto.CreateStoreInDTO;
import com.hozzi.order.domain.store.dto.CreateStoreOutDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/settlement")
public class SettlementController {
    @PostMapping("/reward")
    private ResponseEntity<CreateRewardOutDTO> createReward(@RequestBody CreateStoreInDTO createStoreInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateStoreOutDTO());
    }
}
