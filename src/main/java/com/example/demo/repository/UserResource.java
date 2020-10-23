package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserResource extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
    Optional<User> findByLoginAndPassword(String login, String password);
}
