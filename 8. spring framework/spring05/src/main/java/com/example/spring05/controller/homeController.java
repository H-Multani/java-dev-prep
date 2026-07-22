package com.example.spring05.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {



    //    welcome karne ke liye home page par greet() bana do
    //    we want ki "/" wali request par ye funcn chale toh
    @RequestMapping("/")
//    to tell ki bas data chahiye apan ko we do
//    @ResponseBody
    public String greet(){
        return "welcome harsh";
    }


//    if we want ki /about , kare toh about page ka info aaye toh uska bhi funcn bana do
    @RequestMapping("/about")
    public String about(){
        return "about page righthere";
    }
}
