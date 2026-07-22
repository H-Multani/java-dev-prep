package com.example.spring05.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this is controller which will handle login requests
@RestController
public class loginController {

//    funcn bana do handle karne ke liye
    @RequestMapping("/login")
    public String login(){
        return "login kar lo";
    }
}
