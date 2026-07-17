package com.example.spring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring02Application {

	public static void main(String[] args) {



//        to call the funcn first way is object bana kar
//        since object apan ne banaya hai toh, manage bhi apan ko hi karna padega,
//        this object is made inside JVM but not inside container
//        dev d=new dev();


        ApplicationContext  contecxt=SpringApplication.run(Spring02Application.class, args);
//        context se bolo ki iss class ka object bana le
        dev d=contecxt.getBean(dev.class);

        d.build();
	}

}
