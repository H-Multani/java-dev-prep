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

//    service se baat karne wala object
    @Autowired
    private userService service;

//    register karne ke liye bana do funcn
//    since submitting data to client hence go post mapping
    @PostMapping("/register")
//    since user se data aayega hence RequestBody
    public Users register(@RequestBody Users curr){

        return service.register(curr);

    }
}
