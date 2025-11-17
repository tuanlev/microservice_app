package com.tuan.commonservice.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterDTO {
    @NotNull(message = "username required")
    private String username;
    @NotNull(message = "password required")
    private String password;
}
