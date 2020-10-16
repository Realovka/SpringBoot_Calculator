package com.example.demo.dao;

import com.example.demo.entity.Operation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HistoryDaoImpl implements HistoryDao{
    private List<Operation> operations = new ArrayList<>();

    @Override
    public List<Operation> createHistory(){
        return operations;
    }

    @Override
    public void addOperation(Operation operation){
        operations.add(operation);
    }
}
