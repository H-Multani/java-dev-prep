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
//        build() use karne ke liye we need to make object of dev class

//        we want ki ye object banaye automatically using spring(not spring boot),
//        @Container kaam nai karega since dependency nai hai, we have to work directly with container

//        to get continer we use ApplicationContext, for this we need to add dependency
//        lekin this by itself is interface, toh object banne se raha,
//        toh we make object of class which implements ApplicationContext
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");

//        container ready,

//        to get object frm this container we use getBean(kiska bean chahiye)
        dev obj= (dev) context.getBean("dev");
        obj.build();
//        System.out.println(obj.getAge());
    }
}
