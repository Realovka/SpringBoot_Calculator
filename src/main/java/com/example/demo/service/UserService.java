package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserResource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserResource userResource;

    public UserService(UserResource userResource) {
        this.userResource = userResource;
    }

    public boolean createUser(User user){
        if (getByLogin(user.getLogin()).isEmpty()) {
            userResource.save(user);
            return true;
        }
        else return false;
    }

    public Optional<User> getByLogin(String login){
       return userResource.findByLogin(login);
    }

    public boolean authUser(User user){
        if(getByLoginAndPassword(user.getLogin(),user.getPassword()).isPresent()) {
            return true;
        }
        else return false;
    }

    public Optional<User> getByLoginAndPassword(String login, String password){
        return userResource.findByLoginAndPassword(login,password);
    }


}
