package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserResource;
import com.example.demo.service.ApiKeyService;
import com.example.demo.service.UserService;
import com.example.demo.service.exception.UserCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserResourceController {
    @Autowired
    private UserResource userResource;

    private UserService userService;
    private ApiKeyService apiKeyService;

    public UserResourceController( UserService userService, ApiKeyService apiKeyService) {
        this.userService = userService;
        this.apiKeyService = apiKeyService;
    }

    @PostMapping(path = "/reg")
    public User registration(@RequestBody User user){
       if (userService.createUser(user)){
           return user;
       }
       throw new  UserCreateException();
    }

    @PostMapping(path = "/auth")
    public String authorization(@RequestBody User user){
        String apiKey = null;
        if(userService.authUser(user)) {
         apiKey = apiKeyService.createApiKey(user);
        }
       return  apiKey;
    }
}
