package com.example.springsec01.controller;


import com.example.springsec01.model.Users;
import com.example.springsec01.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @Autowired
    private userService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users curr){

        return service.register(curr);
    }

//    login wala mapping bana do, post mapping banana since we are accepting data
    @PostMapping("/login")
    public String login(@RequestBody Users user){
//        System.out.println(users.toString());

//        service layer ko bolo verify kare
        return service.verify(user);

    }
}
