package org.example;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Path("aliens")
public class AlienResources {

//    yaha ek AlienRepo ka object bana do, which we will fill later
    AlienRepo repo=new AlienRepo();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAliens(){

//        ok toh ye data abhi yehi banaye hai which isnt good for large systems(ik bummer!!)

//        toh yaha we will join sql and unn sab cheez se handle karne ke liye we will handle that in
//        another class altogether, lets call that class AlienRepo, which will get us data from the repo(dbms)
//        include jdbcUtil file we had already made and use it here


        System.out.println("getALien called ");

//        return the data from the repo
        return repo.getAliens();
    }

//    suppose we want to add data to a dbms bana do funcn
//    ab apan ko data BHEJNA hai yaha se, toh POST use karenge
    @POST

//    ab we want ki aliens/sendata par jaaye url me toh ye chale toh uske liye path ka use karenge
    @Path("sendata")
    public Alien createAlien(Alien a1){
        // a1 ka data daal do dbms me
        System.out.println(a1.toString());

//        repo me funcn bana hai call karlo which will take data and update object
        repo.create(a1);

        return a1;
    }


}