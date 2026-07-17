package com.example.spring02;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//we do this @component so that spring boot ko pata ho ki iska object banana hai internally,
// ye nai hota toh aage @autowired kaam nai karega
@Component
@Primary
public class laptop implements computer {
    public void compile(){
        System.out.println("compiling with bugsss");
    }
}
