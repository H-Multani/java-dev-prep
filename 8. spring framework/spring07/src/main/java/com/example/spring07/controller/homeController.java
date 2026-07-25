package com.example.spring07.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {



    @RequestMapping("/")
//    to tell ki bas data chahiye apan ko we do
//    @ResponseBody
    public String greet(){
        return "welcome harsh";
    }


    @RequestMapping("/about")
    public String about(){
        return "about page righthere";
    }
}
