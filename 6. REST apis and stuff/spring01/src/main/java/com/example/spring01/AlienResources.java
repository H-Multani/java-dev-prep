package com.example.spring01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//instead of @Path we use @RestController
@RestController
public class AlienResources {

//    yaha object bana lo interface ka AlienRepo
//        iss annotation se object apne aap ban jayega , no need to manually make
    @Autowired
    AlienRepo repo;

//    waha @Path wala kaam jo hota tha will be done by
    @GetMapping("/alien")
    public List<Alien> getAliens() {

//        data khud se nai daalna, bolna repo se laane ko
        List<Alien> aliens = (List<Alien>) repo.findAll();

//        Alien a1 = new Alien();
//        a1.setName("e");
//        a1.setId(1);
//        a1.setPoints(12);
//
//        Alien a2 = new Alien();
//        a2.setName("dvt");
//        a2.setId(34);
//        a2.setPoints(76);
//
//        aliens.add(a1);
//        aliens.add(a2);

        return aliens;
    }


}