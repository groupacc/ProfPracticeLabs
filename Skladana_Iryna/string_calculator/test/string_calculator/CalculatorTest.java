/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string_calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author iryna
 */
public class CalculatorTest {
    
    @Test
    public void shouldReturnZeroOnEmptyString(){
    assertEquals(0,Calculator.add(""));
    }
    
    @Test
    public void shouldReturn_1OnNumber1(){
       assertEquals(1, Calculator.add("1"));
    }
    @Test
    public void shouldReturn_5OnNumber5(){
       assertEquals(5, Calculator.add("5"));
    }
    @Test
    public void shouldReturn_34OnNumber34(){
       assertEquals(34, Calculator.add("34"));
    }
   
    @Test
    public void shouldReturmSumOnTwoNumbersSeparatededByComma(){
        assertEquals(3,Calculator.add("1,2"));
    }
     
    @Test
    public void shouldReturmSumOnMultipleNumbersSeparatedByCommas_3(){
        assertEquals(8, Calculator.add("4,1,3"));
    }
    @Test
    public void shouldReturmSumOnMultipleNumbersSeparatedByCommas_4(){
        assertEquals(18, Calculator.add("6,2,9,1"));
    }
    
    @Test
    public void shouldReturnSumOfNumbersSeparatedNewLineInsteadCommas(){
        assertEquals(7,Calculator.add("4\n3"));
    }
    @Test
    public void shouldAdoptNewLiseAsSeparator(){
            assertEquals(6,Calculator.add("1\n2,3"));
    }
    @Test
    public void shouldAdoptSpecificSyntaxOfSeparators(){ 
        assertEquals(3,Calculator.add("//;\n1;2"));
    }
    @Test
    public void usersSeparatorsCanBeRegExpSpecialCharDot()
    {
        assertEquals(3, Calculator.add("//.\n1.2"));
    }
    @Test
    public void usersSeparatorsCanBeRegExpSpecialCharQuestion()
    {
        assertEquals(7, Calculator.add("//?\n3?4"));
    }
     @Test
    public void usersSeparatorsCanBeRegExpSpecialCharShyft()
    {
        assertEquals(10, Calculator.add("//#\n8#2"));
    }
   @Test
    public void AddWithnegativesNumbersReturnError(){
    { 
        assertEquals(1, Calculator.add("2,-4,8,-5,-6,-1"));
    }
    }
    @Test
    public void negativeNumbersShouldThrowException(){
        try{
            Calculator.add("-9,6");
        } catch (Exception e) {
            assertEquals("-9", e.getMessage());
        }
    }
    
   @Test
    public void negativeMultipleNumbersShouldThrowException(){
        try{
            Calculator.add("-1,2,-5,-4,-1,-3");
        } catch (Exception e){
            assertEquals("-1,-5,-4,-3", e.getMessage());
        }
    }
}
    

    