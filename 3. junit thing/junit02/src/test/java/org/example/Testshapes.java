package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Testshapes {

//    NOTE-> run karte time, left pane me failed/passed wale testcase par double click karoge toh itll take you to the code where testcase written

    @Test
//    function can be public, default , test method private nai bana sakte apan
     void test_computeSquareArea(){
//        since non static method ko  check krna hai toh object banana padega
        shapes s=new shapes();

//        assertEquals(expected,actual);
        assertEquals(576,s.compute_Sq_area(24));
    }

    @Test
    void test_computeCircleArea(){
//        since non static method ko check krna hai toh object banana padega
        shapes s=new shapes();

//        assertEquals(expected,actual,messgae incase testcase fails);



//        message gets evaluated regardless of testcase fails or pass
        assertEquals(907.46,s.compute_circle_area(17),"Area of circle calulated wrong ");
    }

    @Test
    void test_computeCircleArea_SupplierMethod(){
//        since non static method ko check krna hai toh object banana padega
        shapes s=new shapes();

//        assertEquals(expected,actual,messgae incase testcase fails);

//        ()-> lambda funcn evalueated only of testcase fails
        assertEquals(907.46,s.compute_circle_area(17),()->"Area of circle calulated wrong ");
    }


    @Test
    void test_compute_circle_assertnotequal(){
//        since non static method ko check krna hai toh object banana padega
        shapes s=new shapes();

//        return true if expected!=actual
        assertNotEquals(907.46,s.compute_circle_area(19),()->"Area of circle calulated wrong ");
    }

//    more assert methods
    @Test
    void test_diff_assertmethods(){
        shapes s=new shapes();

        assertTrue(true);
//        assertTrue(boolean_value);
//        if condition inside is true, then passes testcase otherwise fails

        assertFalse(false);
//        assertFalse(boolean_value);
//        if condition inside is false, then passes testcase, otherwise fail
//        bilkul opposite kaam of assertTrue()

//        dono me string message bhej sakte hai, if testcase fails then message executed
//        assertTrue(false,"really failed huh ");
//        NOTE-> message processed even if testcase passes

//        yaha apan supplier function interface bhi laga sakte, lambda expression wala
//        fayeda??-> the message is processed only when test fails, if test passes then the message isnt even processed
//        assertTrue(false,()->"really failed huh ");

    }

    @Test
    void test_array(){
        int exp[]={1,2,3};
        int actual[]={1,2,3};
        assertArrayEquals(exp,actual,"fail ho gaya");
    }

//    testing with exceptions
    @Test
    void test_with_exception(){
//        object bana lo shapes ka
//        try{
//
//        shapes s=new shapes();
//
////        ab s.sortarray() can give exceptions, agar empty array bheja toh null pointer return karega
//        int sorted[]=s.sortarray(unsorted);
//
////        unsorrted array empty hai exception will be generated
//
////            toh jab exception bane tab test pass hona chahiye'
//
////            catch block chalega toh yaha exception aaya uske neeche ka koi code nai chalega, hence yaha apan deliberately fail karate hai
//            fail("exception not generated");
//
////            we do this since incase sab sahi chal gaya and exception nai aaya jaha apan ko exception chahiye tha, uss case me
//        }
//        catch(NullPointerException e){
//            System.out.println("exception generated");
//        }


//        ya ye upar wala kaam karlo ya use assertThrows()

//        ab s.sortarray() can give exceptions, agar empty array bheja toh null pointer return karega
        shapes s=new shapes();
//        int unsorted[]= {1,2,3};
        int unsorted[]= null;

//        agar exception aaya toh test pass otherwise test fail
        assertThrows(NullPointerException.class,()->s.sortarray(unsorted));



    }

}
