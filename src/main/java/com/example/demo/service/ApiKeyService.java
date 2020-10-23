package com.example.demo.service;

import com.example.demo.entity.AppKey;
import com.example.demo.entity.User;
import com.example.demo.repository.ApiKeiResource;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApiKeyService {

    public ApiKeiResource apiKeiResource;

    public ApiKeyService(ApiKeiResource apiKeiResource) {
        this.apiKeiResource = apiKeiResource;
    }

    public String createApiKey(User user) {
        AppKey appKey = new AppKey(user.getLogin(),UUID.randomUUID().toString());
        apiKeiResource.save(appKey);
        return appKey.getApiKey();
    }

    public boolean containApiKey(String apiKey) {
        if (apiKeiResource.findByApiKey(apiKey).isPresent()) {
            return true;
        } else return false;
    }
}