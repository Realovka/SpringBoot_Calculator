package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double num1;
    private double num2;
    private String operationType;
    private double result;

//    public Operation(double num1, double num2, String operationType) {
//        this.num1 = num1;
//        this.num2 = num2;
//        this.operationType = operationType;
//    }
//
    public Operation(String operationType) {
        this.operationType = operationType;
    }
}
