package com.example.springsec01.service;

import com.example.springsec01.model.Users;
import com.example.springsec01.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class userService {

    @Autowired
    private userRepo repo;

//    authentication manager ka object nikal lo
    @Autowired
    AuthenticationManager authmanager;

//    JWT service ka object bana lo for token generation
    @Autowired
    private JWTservice jwTservice;



    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);

    public Users register(Users curr){
        curr.setPassword(encoder.encode(curr.getPassword()));
        return repo.save(curr);
    }

    public String verify(Users user) {

//        apan input me unauthenticated bhej rahe hai and return me apan ko authenticated object milega
        Authentication auth=authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
//        isme object bana denge, constructor need username and password

//        ab ye authentication object lene ke baad(auth)

//        verify if this user is real
        if(auth.isAuthenticated())
//            success bhejne ke jagah, we need token aaye, toh JWT service class ke object se lelo vo funcn
//            username bhej dena
            return jwTservice.generateToken(user.getUsername());
        return "fail";
    }
}
