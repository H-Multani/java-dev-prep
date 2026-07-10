package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienRepo {
//    yaha ek list banao which will store aliens
    List<Alien> aliens;

//    constructor bana lo
    public AlienRepo(){
        aliens=new ArrayList<Alien>();

//        yehi par banao alien, AlienResources me nai
        Alien a1=new Alien();
        a1.setId(1);
        a1.setName(" harsh ");
        a1.setPoints(70);

        Alien a2=new Alien();
        a2.setId(2);
        a2.setName(" wao ");
        a2.setPoints(87);
        List<Alien> ls= Arrays.asList(a1,a2);

        aliens.add(a1);
        aliens.add(a2);

    }

//    now we make a funcn which will return us list of aliens
    public List<Alien> getAliens(){
        return aliens;
    }

//    now suppose we want only 1 specific alien
    public Alien getAlien(int id){
        // alien ki id ke hisab se bhej denge

        Alien a1=null;

//        loop chala kar bhej do

        for(Alien i:aliens){
            if(i.getId()==id) return i;
        }

//        kuch nai hai toh new alien bana kar bhej do nai th null bhejoge toh handle karna padega
        return new Alien();
    }

//    if we want to add an alien data, uska bhi funcn yaha aayega
    public void create(Alien a){
        aliens.add(a);

    }

//    if we want to update an alien data, uska bhi funcn yaha aayega
//    if we want to delete an alien data, uska bhi funcn yaha aayega

}
