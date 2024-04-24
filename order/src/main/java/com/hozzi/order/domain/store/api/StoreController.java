package com.hozzi.order.domain.store.api;

import com.hozzi.order.domain.store.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/store")
public class StoreController {
    @GetMapping("/{userId}")
    private ResponseEntity<ReadStoreOutDTOs> readStore(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadStoreOutDTOs());
    }
    @PostMapping()
    private ResponseEntity<CreateStoreOutDTO> createStore(@RequestBody CreateStoreInDTO createStoreInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateStoreOutDTO());
    }
    @PutMapping()
    private ResponseEntity<UpdateStoreOutDTO> updateStore(@RequestBody UpdateStoreInDTO updateStoreInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new UpdateStoreOutDTO());
    }
    @GetMapping("/menu/{storeId}")
    private ResponseEntity<ReadMenuOutDTOs> readMenu(@PathVariable Long storeId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadMenuOutDTOs());
    }
    @PostMapping("/menu")
    private ResponseEntity<CreateMenuOutDTO> createMenu(@RequestBody CreateMenuInDTO createMenuInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateMenuOutDTO());
    }
    @PutMapping("/menu")
    private ResponseEntity<UpdateMenuOutDTO> updateMenu(@RequestBody UpdateMenuInDTO updateMenuInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new UpdateMenuOutDTO());
    }
}
