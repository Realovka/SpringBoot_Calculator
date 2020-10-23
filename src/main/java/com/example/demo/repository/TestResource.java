package com.example.demo.repository;

import com.example.demo.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResource extends JpaRepository<Operation, Long> {
}
