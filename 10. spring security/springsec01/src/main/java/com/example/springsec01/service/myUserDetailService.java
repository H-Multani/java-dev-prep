package com.example.springsec01.service;

import com.example.springsec01.model.UserPrincipal;
import com.example.springsec01.model.Users;
import com.example.springsec01.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//since ye service hai toh annotate kardo
@Service
public class myUserDetailService implements UserDetailsService {
//     rt click, implement methods

//    repo se connect kardo
    @Autowired
    private userRepo repo;

//    ek hi method hai to override, which is to load user by username, and username bahar se aayega
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        yaha check karne ke liye we again need database connectivity jaise pehle karte the
//        this is service layer, which connects to repo layer which talks to DB for us

//        repo se bolo username se dhund le
        Users user1=repo.findByUsername(username);

//        user hai tph print on console
        if(user1==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }

//        ab userDetails bhej sakte but its interface toh need class,
//        bana do model me ye class, which implements userDetails
//        apni class ka name hai userPrincipal, bana do object bhej do

        return new UserPrincipal(user1);
    }
}
