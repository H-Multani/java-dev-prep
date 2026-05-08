package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class sortingarray {
    public int[] sortarr(int[] arr){
        for(int i=0;i<1000000;i++){
            Arrays.sort(arr);
        }

        return arr;
    }
}
