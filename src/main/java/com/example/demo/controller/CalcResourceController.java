package com.example.demo.controller;

import com.example.demo.entity.Operation;
import com.example.demo.service.CalcService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/test")
public class CalcResourceController {
    private CalcService calcService;

    public CalcResourceController(CalcService calcService) {
        this.calcService = calcService;
    }

    @PostMapping(path = "/calc")
    public Operation getAnswer(@RequestBody Operation operation){
        return  calcService.calc(operation);
    }

    @GetMapping(path = "/history")
    public List<Operation> getHistory(){
        return calcService.getHistory();
    }

    @PostMapping(path = "/filter")
    public List<Operation> getFiltration(@RequestBody Operation operation){
        return calcService.getFiltration(operation);
    }
}
