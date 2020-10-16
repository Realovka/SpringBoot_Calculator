package com.example.demo.dao;

import com.example.demo.entity.Operation;

import java.util.List;

public interface HistoryDao {
    List<Operation> createHistory();
    void addOperation(Operation operation);
}
