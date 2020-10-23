package com.example.demo.service;

import com.example.demo.entity.Operation;
import com.example.demo.repository.TestResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcService {


    private TestResource testResource;


    public CalcService(TestResource testResource) {
        this.testResource = testResource;
    }

    public Operation calc(Operation operation) {
        switch (operation.getOperationType()) {
            case "SUM":
                operation.setResult(operation.getNum1() + operation.getNum2());
                break;
            case "SUB":
                operation.setResult(operation.getNum1() - operation.getNum2());
                break;
            case "MULT":
                operation.setResult(operation.getNum1() * operation.getNum2());
                break;
            case "DIV":
                operation.setResult(operation.getNum1() / operation.getNum2());

        }
        testResource.save(operation);
        return operation;
    }

    public List<Operation> getHistory() {
        return testResource.findAll();
    }


    public List<Operation> getFiltration(String operationType) {
        List<Operation> allOperations = testResource.findAll();
        List<Operation> filtrationOperations = new ArrayList<>();
        for (Operation item : allOperations) {
            if (item.getOperationType().equals(operationType)) {
                filtrationOperations.add(item);
            }
        }
        return filtrationOperations;
    }

}
