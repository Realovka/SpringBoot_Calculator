package com.example.demo.service;

import com.example.demo.dao.HistoryDaoImpl;
import com.example.demo.entity.Operation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcService {
    private HistoryDaoImpl historyDaoImpl;

    public CalcService(HistoryDaoImpl historyDaoImpl) {
        this.historyDaoImpl = historyDaoImpl;
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
        historyDaoImpl.addOperation(operation);
        return operation;
    }

    public List<Operation> getHistory() {
        return historyDaoImpl.createHistory();
    }


    public List<Operation> getFiltration(Operation operation) {
        List<Operation> allOperations = historyDaoImpl.createHistory();
        List<Operation> filtrationOperations = new ArrayList<>();
        for (Operation item : allOperations) {
            if (item.getOperationType().equals(operation.getOperationType())) {
                filtrationOperations.add(item);
            }
        }
        return filtrationOperations;
    }

}
