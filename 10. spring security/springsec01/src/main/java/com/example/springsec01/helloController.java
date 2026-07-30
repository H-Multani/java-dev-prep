package com.example.springsec01;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("")
    public String greet(HttpServletRequest request) {
//        to see session id we do
        System.out.println(request.getSession().getId());

        return "helo world";
    }
}
