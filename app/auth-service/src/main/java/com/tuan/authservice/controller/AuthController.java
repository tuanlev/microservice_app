package com.tuan.authservice.controller;
import com.tuan.authservice.response.ResponseSuccess;
import com.tuan.authservice.service.JwtService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.Token;
import org.springframework.web.bind.annotation.*;
import com.tuan.authservice.Model.User;
import com.tuan.authservice.dtos.LoginDTO;
import com.tuan.authservice.dtos.RegisterDTO;
import com.tuan.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    JwtService jwtService;
    @Autowired
    private UserService userService;

    // ===== REGISTER =====
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO registerDTO) {
        Optional<User> created = userService.CreateUser(registerDTO);
        return ResponseEntity.ok(created);
    }

    // ===== LOGIN =====
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {
        Optional<User> user = userService.login(loginDTO);
        if (user.isPresent()) {
            log.info(user.get().toString());
            String token = jwtService.generateAccessToken(user.get());
            return ResponseEntity.ok().body(List.of(token,user.get(),jwtService.verifyAccessToken(token)));
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

    // ===== GET ALL ====
}
