package org.example;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Path("aliens")
public class AlienResources {
    AlienRepo repo=new AlienRepo();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAliens(){

        System.out.println("getALien called ");

        return repo.getAliens();
    }

//    suppose we want to add data to a dbms bana do funcn
//    ab apan ko data BHEJNA hai yaha se, toh POST use karenge
    @POST
//    ab we want ki aliens/sendata par jaaye url me toh ye chale toh uske liye path ka use karenge
    @Path("sendata")
    public Alien createAlien(Alien a1){
        System.out.println(a1.toString());
        repo.create(a1);

        return a1;
    }

//    now suppose we want to get data of specific is using the url, like ../sendata?id=2
//    ki id se nikalna hai data , and alag se nai bhejra seedha link me bhejra data
//    first of all we know ki GET req me hi data travels through the link toh yaha ek GET req banani padegi itna pata

//    ab normal GET likhenge toh dikkat hogi since we now have 2 methods with GET
    @GET
    @Path("/send1data/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien getAlien(@PathParam("id") int alienid){


        return repo.getAlien(alienid);
    }



}