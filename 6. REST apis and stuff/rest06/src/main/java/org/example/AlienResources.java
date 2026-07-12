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


    @POST
    @Path("sendata")
//    agar we want ki sirf xml aaye input me, this is used , now it wont accept json data
    @Consumes(MediaType.APPLICATION_XML)
    public Alien createAlien(Alien a1){
        System.out.println(a1.toString());
        repo.create(a1);

        return a1;
    }


    @GET
    @Path("/send1data/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien getAlien(@PathParam("id") int alienid){

        return repo.getAlien(alienid);
    }

//    kisi ka data update karne ke liye funcn bana do, PUT use karenge yaha
    @PUT
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien updateAlien(Alien a){
//        pehle check karo banda exist karta ki nai
        if(repo.getAlien(a.getId()).getId()==0){
//            we call the getAlien(), it returns an object, uss object ka id agar 0 hai means kuch update nai hua hai, in this case


            // we here means dekha ki alien exist karta ki nai, if this is 0 means empty object aaya hai, ie it doesnt exist,
            // in which case we will create the thing
            repo.create(a);
        }
        else{
            repo.update(a);
        }

        return a;
    }


//    kisi ka data delete karne ke liye, funcn bana do, for that we use DELETE
    @DELETE
    @Path("/delete/{id}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien killAlien(@PathParam("id") int id){

//        bande ko delete kardo
//        pehle alien nikal lo
        Alien a= repo.getAlien(id);


//        agar alien exist nai karta toh kyu karna delete
        if(a.getId()!=0){
            // means id exist karti hai, in which case, delete kardo
            System.out.println("alien exists ");
            repo.delete(id);
        }

        return a;
    }



}