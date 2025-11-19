package com.tuan.authservice.repository;

import com.tuan.authservice.Model.Role;
import com.tuan.authservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByRole(Role role);
    Optional<User> findDistinctByUsername(String username);

}
