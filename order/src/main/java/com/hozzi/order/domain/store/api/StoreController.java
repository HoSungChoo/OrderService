package com.hozzi.order.domain.store.api;

import com.hozzi.order.domain.store.dto.*;
import com.hozzi.order.domain.store.service.MenuService;
import com.hozzi.order.domain.store.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "StoreController", description = "지점 API")
@RestController
@RequestMapping(value = "/store")
public class StoreController {
    private final StoreService storeService;
    private final MenuService menuService;

    public StoreController(StoreService storeService, MenuService menuService) {
        this.storeService = storeService;
        this.menuService = menuService;
    }

    @GetMapping("/{userId}")
    @Operation(summary = "점주 지점 조회", description = "사용자(점주)가 보유중인 지점을 조회한다.")
    public ResponseEntity<ReadStoreOutDTOs> readStore(@PathVariable Long userId){
        ReadStoreOutDTOs readStoreOutDTOs = storeService.readStore(userId);

        return ResponseEntity.status(HttpStatus.OK).body(readStoreOutDTOs);
    }
    @PostMapping()
    @Operation(summary = "점주 지점 등록", description = "사용자(점주)는 지점을 등록한다.")
    public ResponseEntity<CreateStoreOutDTO> createStore(@RequestBody CreateStoreInDTO createStoreInDTO){
        CreateStoreOutDTO createStoreOutDTO = storeService.createStore(createStoreInDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createStoreOutDTO);
    }
    @PutMapping()
    @Operation(summary = "점주 지점 변경", description = "사용자(점주)는 지점 이름과 분류, 상태를 변경한다.")
    public ResponseEntity<UpdateStoreOutDTO> updateStore(@RequestBody UpdateStoreInDTO updateStoreInDTO){
        UpdateStoreOutDTO updateStoreOutDTO = storeService.updateStore(updateStoreInDTO);

        return ResponseEntity.status(HttpStatus.OK).body(updateStoreOutDTO);
    }
    @GetMapping("/menu/{storeId}")
    @Operation(summary = "지점 메뉴 조회", description = "지점 메뉴를 조회한다.")
    public ResponseEntity<ReadMenuOutDTOs> readMenu(@PathVariable Long storeId){
        ReadMenuOutDTOs readMenuOutDtos = menuService.readMenu(storeId);

        return ResponseEntity.status(HttpStatus.OK).body(readMenuOutDtos);
    }
    @PostMapping("/menu")
    @Operation(summary = "지점 메뉴 등록", description = "지점 메뉴를 등록한다. 해당 지점의 점주, 관리자만 등록 가능하다.")
    public ResponseEntity<CreateMenuOutDTO> createMenu(@RequestBody CreateMenuInDTO createMenuInDTO){
        CreateMenuOutDTO createMenuOutDTO = menuService.createMenu(createMenuInDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createMenuOutDTO);
    }
    @PutMapping("/menu")
    @Operation(summary = "지점 메뉴 변경", description = "지점 메뉴를 변경한다. 해당 지점의 점주, 관리자만 변경 가능하다.")
    public ResponseEntity<UpdateMenuOutDTO> updateMenu(@RequestBody UpdateMenuInDTO updateMenuInDTO){
        UpdateMenuOutDTO updateMenuOutDTO = menuService.updateMenu(updateMenuInDTO);
        
        return ResponseEntity.status(HttpStatus.OK).body(updateMenuOutDTO);
    }
}
