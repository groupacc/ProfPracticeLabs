/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pirog
 */
public class StringCalculatorTest {
    
    public StringCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class StringCalculator.
     */
    @Test
    public void testAdd0() {
        System.out.println("test of method 'add' (pass null)");
        String numbers = null;
        StringCalculator instance = new StringCalculator();
        int expResult = 0;
        try {
            int result = instance.add(numbers);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testAdd1() {
        System.out.println("test of method 'add' (empty string)");
        String numbers = "";
        StringCalculator instance = new StringCalculator();
        int expResult = 0;
        try {
            int result = instance.add(numbers);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testAdd2() {
        System.out.println("test of method 'add' (one number)");
        String numbers = "3";
        StringCalculator instance = new StringCalculator();
        int expResult = 3;
        try {
            int result = instance.add(numbers);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testAdd3() {
        System.out.println("test of method 'add' (two numbers)");
        String numbers = "2,5";
        StringCalculator instance = new StringCalculator();
        int expResult = 7;
        try {
            int result = instance.add(numbers);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testAdd4() {
        System.out.println("test of method 'add' (many numbers)");
        String numbers = "2,5,3,10,30";
        StringCalculator instance = new StringCalculator();
        int expResult = 50;
        try {
            int result = instance.add(numbers);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testAdd5() {
        System.out.println("test of method 'add' (numbers seperated by ',' or next line)");
        String numbers = "2,5\n3";
        StringCalculator instance = new StringCalculator();
        int expResult = 10;
        try {
            int result = instance.add(numbers);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testAdd6() {
        System.out.println("test of method 'add' (numbers seperated custom delimiter)");
        String numbers = "p;2;5;3";
        StringCalculator instance = new StringCalculator();
        int expResult = 10;
        try {
            int result = instance.add(numbers);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testAdd7() {
        System.out.println("test of method 'add' (negative number)");
        String numbers = "-1,3";
        StringCalculator instance = new StringCalculator();
        int expResult = 2;
        try {
            int result = instance.add(numbers);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testAdd8() {
        System.out.println("test of method 'add' (multiple negative numbers)");
        String numbers = "-1,3,5,-4,-3";
        StringCalculator instance = new StringCalculator();
        int expResult = 0;
        try {
            int result = instance.add(numbers);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
