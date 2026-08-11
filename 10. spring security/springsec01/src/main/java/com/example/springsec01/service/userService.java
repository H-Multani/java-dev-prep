package com.example.springsec01.service;

import com.example.springsec01.model.Users;
import com.example.springsec01.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class userService {

    @Autowired
    private userRepo repo;

//    bcrypt ka object bana lo, yaha autowire use nai karenge constructor wala use karenge
//    yehi strength and version bhej sakte, here lets say we need 10 strength, likh do
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);

//    funcn bana do yaha par jo controller se input lega
    public Users register(Users curr){
//    user repo hi use kar lenge ez

//        yaha repo me bhejne se pehle password change karenge,
//        ie yaha apan encrypt kar denge for that we will use bcrypt library

//        setpassword() bula denge, uske andar
//        encoder se bolenge ki abhi wale password ko encode kardo
        curr.setPassword(encoder.encode(curr.getPassword()));
        return repo.save(curr);
    }
}
