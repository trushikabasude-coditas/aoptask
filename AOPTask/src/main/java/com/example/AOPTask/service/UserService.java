package com.example.AOPTask.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String login(String username, String password) {
        if (!username.equals("admin") && !password.equals("123456")) {
            throw new RuntimeException("username or password is incorrect");
        }

        return "Login Successful!!";
    }
}
