package org.example;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//path daalenge aliens, meaning agar kisi ko ye resource use karna hai toh aliens naam se aana padega
@Path("aliens")
public class AlienResources {

    //    isse 404 error nai aayega lekin 500 aayega which is fixed by the one annotaion below this
    @GET
//    batana padega kiss type ka data return karre hai, lets say ki apan XML
//    return krre hai hence we write APPLICATION_XML,

//    now keeping this in mind go to Alien.java file waha define karo
    @Produces(MediaType.APPLICATION_XML)
    public Alien getAlien(){
//        ye funcn bas alien ka object banayega and return kar dega
        System.out.println("getALien called ");
        Alien a1=new Alien();
        a1.setName("harsh");
        a1.setPoints(70);

        return a1;
    }
}
