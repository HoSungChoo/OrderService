package com.hozzi.order.domain.user.api;

import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.service.UserService;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")//, produces = "application/json; charset=utf-8")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // swagger 입력
    // 소셜 로그인

    // 회원 정보 조회
    @GetMapping("/{userId}")
    public ResponseEntity<ReadUserOutDTO> readUser(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadUserOutDTO());
    }
    @PutMapping()
    public ResponseEntity<UpdateUserOutDTO> updateUser(@RequestBody UpdateUserInDTO updateUserInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new UpdateUserOutDTO());
    }
    @PutMapping("/exit")
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody DeleteUserInDTO deleteUserInDTO){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/pay/{userId}")
    public ResponseEntity<ReadWalletOutDTOs> readWallet(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadWalletOutDTOs());
    }
    @PostMapping("/pay")
    public ResponseEntity<CreateWalletOutDTO> createwallet(@RequestBody CreateWalletInDTO createWalletInDTO){
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
    public ResponseEntity<ReadBasketOutDTOs> readBasketByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(new ReadBasketOutDTOs());
    }
    @PostMapping("/item")
    public ResponseEntity<CreateBasketOutDTO> createBasket(@RequestBody CreateBasketInDTO createBasketInDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new CreateBasketOutDTO());
    }
    @DeleteMapping("/items/{userId}")
    public ResponseEntity<HttpStatus> deleteBasketByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/item/{basketId}")
    public ResponseEntity<HttpStatus> deleteBasketByBasketId(@PathVariable String basketId){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // @RequestParam(value = "userId", required = true)
    // @RequestParam(value = "basketId", required = true)
}
