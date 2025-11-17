package com.tuan.authservice.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDTO {
    @NotNull(message = "username required")
    private String username;
    @NotNull(message = "username required")
    private String password;
}
