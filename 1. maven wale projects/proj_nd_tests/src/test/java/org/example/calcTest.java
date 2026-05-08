package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calcTest {
    @Test
    void testcalc()
    {
//           org.example.calc ka object bnao
        calc c=new calc();
        int actualresult=c.add(5,3);
        int expextedresult=8;

        assertEquals(expextedresult,actualresult);


    }
}
