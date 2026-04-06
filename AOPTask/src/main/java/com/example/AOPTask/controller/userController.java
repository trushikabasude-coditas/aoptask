package com.example.AOPTask.controller;

import com.example.AOPTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class userController {
    @Autowired
    private UserService userService;
    public String login(String username,String password){
        return  userService.login(username,password);
    }

}
