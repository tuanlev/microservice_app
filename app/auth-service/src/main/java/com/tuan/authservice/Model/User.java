package com.tuan.authservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(columnNames = {"username"})
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
