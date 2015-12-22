package com.yurkivt.test;
import static org.junit.Assert.*;

import com.yurkivt.Calculator;
import com.yurkivt.NegativesNotAllowedException;
import org.junit.Test;

/**
 * Created by Bagira on 22-Dec-15.
 */
public class CalculatorTest {
    @Test
        public void testEmptyString() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.add(""));
    }

    @Test
    public void testAddNumbers() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.add("1"));
        assertEquals(3, calc.add("1,2"));
        assertEquals(6, calc.add("1,2,3"));
    }

    @Test
    public void testNewLine() {
        Calculator calc = new Calculator();
        assertEquals(14, calc.add("5\n2\n6,1"));
    }

    @Test
    public void testDelimiters() {
        Calculator calc = new Calculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void testNegatives() {
        Calculator calc = new Calculator();
        calc.add("-1,-2,3");
    }

    @Test
    public void testMoreThenThousandIgnore(){
        Calculator calc = new Calculator();
        assertEquals(3, calc.add("1002,3"));
    }

    @Test
    public void testAnyLengthDelimiters() {
        Calculator calc = new Calculator();
        assertEquals(8, calc.add("//[**]\n1**3**4"));
    }

    @Test
    public void testMultipleDelimiters() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add("//[;][%]\n1;2%3"));
        assertEquals(11, calc.add("//[;;][%%]\n2;;2%%7"));
        assertEquals(7, calc.add("//[;%][#@]\n1;%4#@2"));
    }


}
