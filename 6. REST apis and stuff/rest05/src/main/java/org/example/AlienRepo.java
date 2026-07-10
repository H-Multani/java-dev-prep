package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienRepo {
    List<Alien> aliens;

    public AlienRepo(){
        aliens=new ArrayList<Alien>();

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

    public List<Alien> getAliens(){
        return aliens;
    }

    public Alien getAlien(int id){

        Alien a1=null;

        for(Alien i:aliens){
            if(i.getId()==id) return i;
        }
        return new Alien();
    }
    public void create(Alien a){
        aliens.add(a);

    }

//    if we want to update an alien data, uska bhi funcn yaha aayega
//    if we want to delete an alien data, uska bhi funcn yaha aayega

}
