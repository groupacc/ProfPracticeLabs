/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profpractice1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew
 */
public class StringCalculatorTest {
    
    public StringCalculatorTest() {
    }
    /**
     * Test of add method, of class StringCalculator.
     */
    @Test
    public void testAddEmpty() {
        System.out.println("addEmpty");
        StringCalculator strCalc = new StringCalculator();
        assertEquals(0, strCalc.add(""));
    }
    
    @Test
    public void testAddNumbers() {
        System.out.println("addNumbers");
        StringCalculator strCalc = new StringCalculator();;
        assertEquals(5, strCalc.add("5"));
        assertEquals(10, strCalc.add("8,2"));
        assertEquals(15, strCalc.add("10,3,2"));
    }
    
    @Test
    public void testAddWithNewLine() {
        System.out.println("addWithNewLine");
        StringCalculator strCalc = new StringCalculator();;
        assertEquals(12, strCalc.add("8,4"));
        assertEquals(15, strCalc.add("10\n3\n2"));
    }
    
    @Test
    public void testAddWithNewDelimiter() {
        System.out.println("addWithNewDelimiter");
        StringCalculator strCalc = new StringCalculator();;
        assertEquals(5, strCalc.add("//;\n3;2"));
        assertEquals(10, strCalc.add("//;\n6;4"));
    }
    
    @Test
    public void testAddThrowNegativeException() {
        System.out.println("addThrowNegativeException");
        try {
            StringCalculator strCalc = new StringCalculator();
            strCalc.add("12,-5");
            fail("Exception had to be thrown!");
        } catch (NegativeNumberException ex) {
            
        }
    }
    
    @Test
    public void testAddLessThenThousand() {
        System.out.println("addLessThenThousand");
        StringCalculator strCalc = new StringCalculator();;
        assertEquals(5, strCalc.add("//;\n3;2;1001"));
        assertEquals(10, strCalc.add("6,4,2500"));
    }
    
    @Test
    public void testAddMultiDelimiters() {
        System.out.println("addMultiDelimiters");
        StringCalculator strCalc = new StringCalculator();;
        assertEquals(5, strCalc.add("//[%][;]\n3;2%1001"));
    }
    
}
