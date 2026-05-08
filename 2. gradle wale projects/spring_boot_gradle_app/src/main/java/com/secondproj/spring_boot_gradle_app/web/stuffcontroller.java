package com.secondproj.spring_boot_gradle_app.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class stuffcontroller {

    @GetMapping("/")
    public String getinfo(){
        return "really bro???";
    }
}
