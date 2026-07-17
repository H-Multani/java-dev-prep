package com.example.spring02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

//this tells spring ki ye class ka objects tumko bana kar rakhna hai
@Component
public class dev {


//    isse controller ke andar jo already made object hoga laptop class ka vo utha kar layega
//    NOTE-> new object nai banta, jo controller banaya hai vahi waha aata hai, har class ka ek
//    @Autowired
//    laptop laptop;
//    this is called a field injection

//    now real me company promises us computer not laptop, but laptop is a type of computer(ie laptop is subclass of computer),
//    toh if we try to make object of computer, which is an interface like
    @Autowired
    @Qualifier("laptop")
    computer c;


//    this is constructor injection, no autowired needed, yehi se automatically laa kar de dega object
//    yaha autowired laga sakte optional hai, lagaoge toh fatega nai
//    public dev(laptop laptop){
//        this.laptop=laptop;
//    }

//    alag se funcn bhi bana sakte setter injection, isko normally chalaoge toh fatega, autowired lagana padega
//    @Autowired
//    public void setLaptop(laptop laptop){
//        this.laptop=laptop;
//    }


    public void build(){

//    now suppose iss class ko laptop class ka need ho
        c.compile();


        System.out.println("building smth swag");
    }
}
