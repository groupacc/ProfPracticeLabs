package com.pavelsikun.tdd.lab1;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mrbimc on 23.12.15.
 */
public class StringCalculatorTests {
    
    Calculator calc = new Calculator();

    @Test
    public void addTestEmptyString() {
        int result = tryAdd("");
        assertEquals(0, result);
    }

    @Test
    public void addTestNumbers() {
        assertEquals(1, tryAdd("1"));
        assertEquals(3, tryAdd("1,2"));
        assertEquals(30, tryAdd("6,7,8,9"));
    }

    @Test
    public void addTestDelimiters() {
        assertEquals(0, tryAdd("//adf\n"));
        assertEquals(0, tryAdd("//,,\n"));
        assertEquals(66, tryAdd("//,,\n11,,22,,33"));
        assertEquals(99, tryAdd("//_\n22_33_44"));
    }

    @Test
    public void addTestNewLines() {
        assertEquals(15, tryAdd("1,2\n3\n4,5"));
        assertEquals(110, tryAdd("//,,\n11,,22\n33,,44"));
    }

    @Test(expected = NegativeNumberException.class)
    public void addTestNegatives() throws NegativeNumberException {
        calc.add("-10,20,100,-20,40,50");
    }

    int tryAdd(String string) {
        try {
            return calc.add(string);
        }
        catch (NegativeNumberException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
