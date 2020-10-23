package com.example.demo.repository;

import com.example.demo.entity.AppKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiKeiResource extends JpaRepository<AppKey,Long> {
    Optional<AppKey> findByApiKey(String apiKey);
}
