package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");

//        suppose id nai dena, seedha class deni hai, class doge toh no need for typecasting
        dev obj= context.getBean(dev.class);
        obj.build();


    }
}