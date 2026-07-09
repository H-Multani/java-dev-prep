package org.example;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

//path daalenge aliens, meaning agar kisi ko ye resource use karna hai toh aliens naam se aana padega
@Path("aliens")
public class AlienResources {

    //    isse 404 error nai aayega lekin 500 aayega which is fixed by the one annotaion below this
    @GET
//    batana padega kiss type ka data return karre hai, lets say ki apan XML
//    return krre hai hence we write APPLICATION_XML,

//    now keeping this in mind go to Alien.java file waha define karo
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAlien(){
//        ye funcn bas alien ka object banayega and return kar dega
        System.out.println("getALien called ");
        Alien a1=new Alien();
        a1.setName("harsh");
        a1.setPoints(70);

        Alien a2=new Alien();
        a2.setName("wao");
        a2.setPoints(87);

//        ek object hai toh bana kar bhej do, multiple hai toh make array of objects, LIST banara mai yaha

        List<Alien> ls= Arrays.asList(a1,a2);

        return ls;
    }
}
