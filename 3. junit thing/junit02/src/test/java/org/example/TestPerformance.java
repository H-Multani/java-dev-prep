package org.example;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;


//ab har test ke liye common class lagega bass, ye nai likhoge/PER_METHOD likhoge toh har test ke liye separate object made internally
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestPerformance {

    TestPerformance(){
        System.out.println("test object created before test method is run ");
    }


    @BeforeAll
    static void smth_bfore_all_Tests(){
        System.out.println("before all tests ");
    }


    sortingarray s;

    @BeforeEach
    void init(){

        s= new sortingarray();
        System.out.println("before tests ");
    }

    @Test
    void test_sorting_method(){

        System.out.println("actual tests here1 ");
        int unsorted[]={2,5,1};

        assertTimeout(Duration.ofMillis(500),()->s.sortarr(unsorted));

    }

    @Test
    void test2(){
        assertTrue(true);
        System.out.println("actual test2 here ");
    }

    @AfterEach
    void destroy(){
        System.out.println("destrpy the object after test");
    }



    @AfterAll
    static void smth_after_all_Tests(){
        System.out.println("After all tests ");
    }
}
