package com.hozzi.order.domain.user.api;

import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.service.UserService;
import com.sun.net.httpserver.HttpsServer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "UserController", description = "유저 API")
@RestController
@RequestMapping(value = "/user")//, produces = "application/json; charset=utf-8")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // swagger 입력
    // @Operation(summary = "", description = "")
    // 소셜 로그인

    // 회원 정보 조회
    @GetMapping("/{userId}")
    @Operation(summary = "회원 정보 조회", description = "사용자(고객 본인, 관리자)는 회원 정보를 조회한다.")
    public ResponseEntity<ReadUserOutDTO> readUser(@PathVariable Long userId) throws Exception {
        ReadUserOutDTO readUserOutDTO = userService.readUser(userId);

        return ResponseEntity.status(HttpStatus.OK).body(readUserOutDTO);
    }
    @PutMapping()
    @Operation(summary = "회원 정보 변경", description = "사용자(고객 본인, 관리자)는 회원 정보를 변경한다.")
    public ResponseEntity<UpdateUserOutDTO> updateUser(@RequestBody UpdateUserInDTO updateUserInDTO) throws Exception {
        UpdateUserOutDTO updateUserOutDTO = userService.updateUser(updateUserInDTO);

        return ResponseEntity.status(HttpStatus.OK).body(updateUserOutDTO);
    }
    @PutMapping("/exit")
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody DeleteUserInDTO deleteUserInDTO){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/pay/{userId}")
    public ResponseEntity<ReadWalletOutDTOs> readWallet(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadWalletOutDTOs());
    }
    @PostMapping("/pay")
    public ResponseEntity<CreateWalletOutDTO> createWallet(@RequestBody CreateWalletInDTO createWalletInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateWalletOutDTO());
    }
    @PutMapping("/pay")
    public ResponseEntity<HttpStatus> deleteWallet(@RequestBody DeleteWalletInDTO deleteWalletInDTO){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/item/{basketId}")
    public ResponseEntity<ReadBasketOutDTO> readBasketByBasketId(@PathVariable Long basketId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadBasketOutDTO());
    }
    @GetMapping("/items/{userId}")
    public ResponseEntity<ReadBasketOutDTOs> readBasketByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadBasketOutDTOs());
    }
    @PostMapping("/item")
    public ResponseEntity<CreateBasketOutDTO> createBasket(@RequestBody CreateBasketInDTO createBasketInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateBasketOutDTO());
    }
    @DeleteMapping("/items/{userId}")
    public ResponseEntity<HttpStatus> deleteBasketByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/item/{basketId}")
    public ResponseEntity<HttpStatus> deleteBasketByBasketId(@PathVariable Long basketId){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // @RequestParam(value = "userId", required = true)
    // @RequestParam(value = "basketId", required = true)
}
