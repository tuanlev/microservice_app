package com.tuan.authservice.controller;
import com.tuan.authservice.response.ResponseSuccess;
import com.tuan.authservice.service.JwtService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import com.tuan.authservice.Model.User;
import com.tuan.authservice.dtos.LoginDTO;
import com.tuan.authservice.dtos.RegisterDTO;
import com.tuan.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    JwtService jwtService;
    @Autowired
    private AuthService userService;

    // ===== REGISTER =====
    @PostMapping("/register")
    public ResponseEntity<ResponseSuccess> register(@Valid @RequestBody RegisterDTO registerDTO) {
        Optional<User> created = userService.CreateUser(registerDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(ResponseSuccess.builder()
                        .message("User registered successfully!")
                        .data(Map.of("User",created.get()))
                    .build());
    }

    // ===== LOGIN =====
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {
        Optional<User> user = userService.login(loginDTO);
        if (user.isPresent()) {
            log.info(user.get().toString());
            String token = jwtService.generateAccessToken(user.get());
            String refToken = jwtService.generateRefreshToken(user.get());
            return ResponseEntity.ok().body(
                    Map.of("access-token", token,"refresh-token", refToken,"user",user.get())
            );
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }


}
