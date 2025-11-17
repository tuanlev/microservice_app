package com.tuan.authservice.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String role;
}