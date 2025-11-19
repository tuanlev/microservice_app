package com.tuan.authservice.service;

import com.tuan.authservice.Model.Role;
import com.tuan.authservice.Model.User;
import com.tuan.authservice.dtos.LoginDTO;
import com.tuan.authservice.dtos.RegisterDTO;
import com.tuan.authservice.repository.UserRepository;
import com.tuan.authservice.response.ResponseSuccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JwtService jwtService;
    public ResponseSuccess CreateUser ( RegisterDTO registerDTO) {
        User user = User.builder()
                .username(registerDTO.getUsername())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role((Role) ((registerDTO.getRole()!=null)?Role.valueOf(registerDTO.getRole()):Role.user))
                .build();
        user = userRepository.save(user);
        return ResponseSuccess.builder()
                .status(201)
                .data(Map.of("user",user))
                .message("Registered Successfully!")
                .build();
    }
    public ResponseSuccess login(LoginDTO loginDTO) {
        Optional<User> user =  userRepository.findDistinctByUsername(loginDTO.getUsername());
        if(user.isPresent()) {
            if (passwordEncoder.matches(
                  loginDTO.getPassword(),user.get().getPassword())) {
                String token = jwtService.generateAccessToken(user.get());
                String refToken = jwtService.generateRefreshToken(user.get());
                return ResponseSuccess.builder()
                        .status(200)
                                .message("Login Success")
                                .data(Map.of("access-token", token,
                                        "refresh-token", refToken,
                                        "user", user.get()))
                        .build();

            }else
            throw new BadCredentialsException("Password Incorrect");
        }else
        throw new UsernameNotFoundException(loginDTO.getUsername());
    }

    public List<User> findAll() {
        Page<User> page = userRepository.findAll(PageRequest.of(0, 10));
        return page.getContent();
    }

}
