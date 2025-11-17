package com.tuan.authservice.service;

import com.tuan.authservice.Model.Role;
import com.tuan.authservice.Model.User;
import com.tuan.authservice.dtos.LoginDTO;
import com.tuan.authservice.dtos.RegisterDTO;
import com.tuan.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<User> CreateUser ( RegisterDTO registerDTO) {
        User user = User.builder()
                .username(registerDTO.getUsername())
                .password(registerDTO.getPassword())
                .role((Role) ((registerDTO.getRole()!=null)?Role.valueOf(registerDTO.getRole()):Role.user))
                .build();
        return Optional.of(userRepository.save(user));
    }
    public Optional<User> login(LoginDTO loginDTO) {
        return userRepository.findDistinctByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
    }
    public List<User> findAll() {
        Page<User> page = userRepository.findAll(PageRequest.of(0, 10));
        return page.getContent();
    }

}
