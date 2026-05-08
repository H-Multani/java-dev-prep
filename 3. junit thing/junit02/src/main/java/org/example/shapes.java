package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class shapes {

//    isme funcn bana do lekin logic nai likhna abhi
    public double compute_Sq_area(double length){
//        initially empty

//        test fail ho gaya iss failed test ko dekh kar karo coding
        return length*length;
    }

//    isme funcn bana do lekin logic nai likhna abhi
    public double compute_circle_area(double length){
//        initially empty

//        test fail ho gaya iss failed test ko dekh kar karo coding
        return 3.14*length*length;
    }


//    testing ke liye function likha hai which can send problems
    public int[] sortarray(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
}
