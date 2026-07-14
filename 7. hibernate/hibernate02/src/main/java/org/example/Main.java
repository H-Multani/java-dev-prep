package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;

public class Main {
    static void main() {
        Alien a=new Alien();
        a.setId(3);
        a.setName("helo");
        a.setTech("pnq");


//        these 3 lines ka kaam can be done directly when making SessionFactory like
//        Configuration config= new Configuration();
//        config.addAnnotatedClass(org.example.Alien.class);
//        config.configure("hibernate.cfg.xml");


        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .configure()
                .buildSessionFactory();

        Session s=sf.openSession();

//        yaha fetching karre hai toh transaction object not reqd



//        for fetching data from table to here, for that we use get(),
//        version 7 hibernate me get deprecate kar diya gaya hai,
//        since aage JPA ke hisab se banana hai, now we use find()

//        takes 2 things (classname, primary key)
//        here we take out row jiska id=3, and uska object bana kar store kar rahe
//        Alien a=s.get(Alien.class,3); //eager fetching

//        can also use find
//        Alien a=s.find(Alien.class,3);
//        this is also eager fetching

//        can also do
//        Alien a=s.byId(Alien.class).getReference(3); // lazy fetching
//        this is deprecated but it works


//        print kara do object ko
//        System.out.println(a.toString());


//        to update data we first need transaction wala object
        Transaction t=s.beginTransaction();

//        to update data we have merge()
//        s.merge(a);
//        this does 2 things,
//        if object present, it will update
//        if object not present, it will create

//        to remove data we need object jisko remove karna hai, toh fetch it first
//        Alien a=s.find(Alien.class,3);
//        id-3 wala fetch kar liya usko remove karna hai
//        s.remove(a);
        s.persist(a);


//        transaction commit kardo
        t.commit();



//        close resources
        s.close();
        sf.close();
    }
}