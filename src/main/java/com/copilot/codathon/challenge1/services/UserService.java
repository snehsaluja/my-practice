package com.copilot.codathon.challenge1.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private static final String USER_API_URL = "https://jsonplaceholder.typicode.com/users";

    public String fetchUsers() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(USER_API_URL, String.class);
    }
}