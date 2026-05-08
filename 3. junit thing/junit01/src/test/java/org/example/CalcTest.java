package org.example;

//ye junit 4 ka kaa kaam hai ye
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;

//junit 5 ka package import kro
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalcTest {

//    test method can be public
    @Test
    public void test1(){
//        System.out.println("first test ");
        Calc c=new Calc();

//        2 test check here, dono me se ek bhi fata toh overall failed

//        first check-> alag variables bana kar check karo
        int actual=c.dosmth(4,5);
        int expected=9;
        assertEquals(expected,actual);
//        second check

//        wahi inline check karlo
        assertEquals(78,c.dosmth(79,-1));
    }
//    test method can be default
    @Test
    void test_really_different_name(){
//        System.out.println("first test ");
        Calc c=new Calc();

//        2 test check here, dono me se ek bhi fata toh overall failed

//        first check-> alag variables bana kar check karo
        int actual=c.dosmth(8,5);
        int expected=13;
        assertEquals(expected,actual);
//        second check

//        wahi inline check karlo
        assertEquals(78,c.dosmth(79,-1));
    }
}
