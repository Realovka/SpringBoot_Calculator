package com.example.demo.controller;

import com.example.demo.entity.Operation;
import com.example.demo.repository.TestResource;
import com.example.demo.service.ApiKeyService;
import com.example.demo.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/test")
public class CalcResourceController {
    @Autowired
    private TestResource testResource;

    private CalcService calcService;
    private ApiKeyService apiKeyService;

    public CalcResourceController(CalcService calcService, ApiKeyService apiKeyService) {
        this.calcService = calcService;
        this.apiKeyService = apiKeyService;
    }

    @PostMapping(path = "/calc")
    public Operation getAnswer(@RequestBody Operation operation, @RequestHeader("api_key") String apiKey){
        if(apiKeyService.containApiKey(apiKey)) {
            return calcService.calc(operation);
        }
        else return new Operation();
    }

    @GetMapping(path = "/history")
    public List<Operation> getHistory(@RequestHeader("api_key") String apiKey){
        if(apiKeyService.containApiKey(apiKey)) {
            return calcService.getHistory();
        }
        else return new ArrayList<Operation>();
    }

    @GetMapping (path = "/test")
    public List<Operation> getFiltration(@RequestBody Operation operation, @RequestHeader("api_key") String apiKey){
        if(apiKeyService.containApiKey(apiKey)) {
            return calcService.getFiltration(operation.getOperationType());
        }     else return new ArrayList<Operation>();
    }
}
