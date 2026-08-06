package com.example.springsec01;


import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.LifecycleState;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class studentController {
//    abhi ke liye hardcode kardo values ko
    private List<Student> stud=new ArrayList<>(List.of(
            new Student(1,"harsh",60),
            new Student(2,"harsh1",61),
            new Student(3,"harsh2",62)

));

//    make funcn that returns list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return stud;
    }

//    add karne ke liye method bana do
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student s){
        stud.add(s);
        return s;
    }


//    token bana kar dene ke liye func likh do
//    HttpServeltRequest banaya tha apan ne, wahi se token aur session id nikal sakte
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }
}
