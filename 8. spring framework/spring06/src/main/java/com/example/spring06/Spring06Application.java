package com.example.spring06;


import com.example.spring06.model.alien;
import com.example.spring06.repository.alienrepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring06Application {

	public static void main(String[] args) {

//        appliation context bana lo, which is object wala container
        ApplicationContext context= SpringApplication.run(Spring06Application.class, args);

//        alien ka package import karke object bana lo,
//        since we want this object to be made by spring framework,
//        context se bolo banane ko object
        alien a1=context.getBean(alien.class);
//        values daldo
        a1.setId(0);
        a1.setName("helo");
        a1.setTech("HTML");

//        save this data in database

//        repo se object bana lo, conetext use karke
        alienrepo repo=context.getBean(alienrepo.class);

//        to save object call the funcn
        repo.save(a1);

//        to display all objects frm table
        System.out.println(repo.findall());



	}

}
