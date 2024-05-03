package com.hozzi.order.domain.user.api;

import com.hozzi.order.domain.user.dto.*;
import com.hozzi.order.domain.user.service.BasketService;
import com.hozzi.order.domain.user.service.UserService;
import com.hozzi.order.domain.user.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "UserController", description = "유저 API")
@RestController
@RequestMapping(value = "/user", produces = "application/json; charset=utf-8")
public class UserController {
    private final UserService userService;
    private final WalletService walletService;
    private final BasketService basketService;
    public UserController(UserService userService, WalletService walletService, BasketService basketService) {
        this.userService = userService;
        this.walletService = walletService;
        this.basketService = basketService;
    }

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
    @Operation(summary = "회원 탈퇴", description = "사용자는 회원 탈퇴한다.")
    public ResponseEntity<DeleteUserOutDTO> deleteUser(@RequestBody DeleteUserInDTO deleteUserInDTO) throws Exception {
        DeleteUserOutDTO deleteUserOutDTO = userService.deleteUser(deleteUserInDTO);

        return ResponseEntity.status(HttpStatus.OK).body(deleteUserOutDTO);
    }
    @GetMapping("/pay/{userId}")
    @Operation(summary = "고객 결제수단 전체 조회", description = "사용자(고객)는 결제수단을 조회한다.")
    public ResponseEntity<ReadWalletOutDTOs> readWallet(@PathVariable Long userId) throws Exception {
        ReadWalletOutDTOs readWalletOutDTOs = walletService.readWallet(userId);

        return ResponseEntity.status(HttpStatus.OK).body(readWalletOutDTOs);
    }
    @PostMapping("/pay")
    @Operation(summary = "고객 결제수단 등록", description = "사용자(고객)는 결제수단을 등록한다.")
    public ResponseEntity<CreateWalletOutDTO> createWallet(@RequestBody CreateWalletInDTO createWalletInDTO) throws Exception {
        CreateWalletOutDTO createWalletOutDTO = walletService.createWallet(createWalletInDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createWalletOutDTO);
    }
    @PutMapping("/pay")
    @Operation(summary = "고객 결제수단 해지", description = "사용자(고객)는 결제수단을 해지한다.")
    public ResponseEntity<HttpStatus> deleteWallet(@RequestBody DeleteWalletInDTO deleteWalletInDTO) throws Exception {
        walletService.deleteWallet(deleteWalletInDTO);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/item/{basketId}")
    @Operation(summary = "장바구니 특정 조회", description = "장바구니 ID를 기준으로 조회한다.")
    public ResponseEntity<ReadBasketOutDTO> readBasketByBasketId(@PathVariable Long basketId) throws Exception {
        ReadBasketOutDTO readBasketOutDTO = basketService.readBasketByBasketId(basketId);

        return ResponseEntity.status(HttpStatus.OK).body(readBasketOutDTO);
    }
    @GetMapping("/items/{userId}")
    @Operation(summary = "장바구니 조회", description = "특정 사용자(고객)의 장바구니를 조회한다. 다수가 조회될 수 있다.")
    public ResponseEntity<ReadBasketOutDTOs> readBasketByUserId(@PathVariable Long userId) throws Exception {
        ReadBasketOutDTOs readBasketOutDTOs = basketService.readBasketByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(readBasketOutDTOs);
    }
    @PostMapping("/item")
    @Operation(summary = "장바구니 추가", description = "사용자(고객)는 특정 가게 메뉴와 수량을 장바구니에 추가한다.")
    public ResponseEntity<CreateBasketOutDTO> createBasket(@RequestBody CreateBasketInDTO createBasketInDTO) throws Exception {
        CreateBasketOutDTO createBasketOutDTO = basketService.createBasket(createBasketInDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createBasketOutDTO);
    }
    @DeleteMapping("/items/{userId}")
    @Operation(summary = "장바구니 전체 삭제", description = "사용자(고객)의 장바구니 내역을 전체 삭제한다.")
    public ResponseEntity<HttpStatus> deleteBasketByUserId(@PathVariable Long userId) throws Exception {
        basketService.deleteBasketByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/item/{basketId}")
    @Operation(summary = "장바구니 부분 삭제", description = "사용자(고객)는 장바구니 내역을 부분 삭제한다.")
    public ResponseEntity<HttpStatus> deleteBasketByBasketId(@PathVariable Long basketId) throws Exception {
        basketService.deleteBasketByBasketId(basketId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
