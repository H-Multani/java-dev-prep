package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

//        object bana do
        Alien a=new Alien();
        a.setId(3);
        a.setName("jhg");
        a.setTech("eijrv");

//        hibernate ko bolo save karle a object ko

//        hibernate ko use karne ke liye we need configuration, btana padega ki ye db hai, ye url, id,pass etc

//        confiuration bana lo object
        Configuration config= new Configuration();
//        conifuration me ab batana padega ki hibernate ko konsi class ko handle karna hai for that we dp
        config.addAnnotatedClass(org.example.Alien.class);

//        one more thing, hibernate.cfg.xml wali file ka name kuch bhi rakh sakte, lekin yehi rakhoge
//        toh dikkat nai hogi, otherwise need to mention like

//        load kardo configuration ko
        config.configure("hibernate.cfg.xml");
//        Could not locate cfg.xml resource [hibernate.cfg.xml], bana do ye file in resources folder, usme details bhar dena
//        otherwise config.configure() will also work since apna file toh sahi hai



//        to connect java app with db we need session(connection), and this is an interface toh object nai bana sakte

//        session kon dega, session factory dega, ye bhi interface hai object kaise banega baad me dekhte hai
        SessionFactory sf=config.buildSessionFactory();

//        ab session bana do, tell sessionFactory sf to create new factory for current session
        Session s=sf.openSession();

//        all changes are part of transaction hence need to make transaction first,
//        and since ye interface hai toh object nai bana sakte, but session se transaction start
//        karva sakte hai
        Transaction t=s.beginTransaction();
//        yaha se transactions karre hai apan start, upar nai chalega

//        ab session se bolo to save the object
//        s.save(a); ye funcn hibernate 6 tak tha 7 me nai hai
        s.persist(a);


//        saare transactions hone ke baad commit kardena
        t.commit();
//        jaisehi commit chalega turant data chala jayega to dbms


//        kaam khatam ke baad close kar sakte if wanted, not mandatory
        s.close();
        sf.close();
    }
}
