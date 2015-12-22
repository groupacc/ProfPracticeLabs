package lab1;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTests {

	 @Test
	    public void shouldReturnZeroOnEmptyString(){
	        assertEquals(0, StringCalculator.Add(""));
	    }
	    
	    @Test
	    public void shouldReturnNumber_1(){
	        assertEquals(3, StringCalculator.Add("3"));
	    }
	    
	    @Test
	    public void shouldReturnNumber_2(){
	        assertEquals(8, StringCalculator.Add("8"));
	    }
	    
	    @Test
	    public void shouldReturnSumOfNumbers_1(){
	        assertEquals(9, StringCalculator.Add("4,5"));
	    }
	    
	    @Test
	    public void shouldReturnSumOfNumbers_2(){
	        assertEquals(8, StringCalculator.Add("5,2,1"));
	    }
	    
	    @Test
	    public void shouldReturnSumOfNumbers_3(){
	        assertEquals(21, StringCalculator.Add("3,7,5,6"));
	    }
	    
	    @Test
	    public void shouldReturnSumOfNumbersWithNewLine(){
	        assertEquals(7, StringCalculator.Add("3\n4"));
	    }
	    
	    @Test 
	    public void shouldAcceptNewLineAsValidDelimeter(){
	        assertEquals(4, StringCalculator.Add("1,2\n1"));
	    }
	    
	    @Test
	    public void shouldAcceptCustomDelimiterSyntax(){
	        assertEquals(6, StringCalculator.Add("//;\n4;2"));
	    }
	    
	    @Test
	    public void shouldReturmErrorForNegative_1(){
	        try {
	            StringCalculator.Add("-1");
	            //fail();
	        } catch (Exception e) {
	            assertEquals("-1", e.getMessage());
	        }
	    }
	    
	    @Test
	    public void shouldReturmErrorForNegative_2(){
	        try {
	            StringCalculator.Add("-1,2,-2");
	        } catch (Exception e){
	            assertEquals("-1,-2", e.getMessage());
	        }
	    }
	    
	    @Test
	    public void shouldReturmErrorForNegative_3(){
	        try {
	            StringCalculator.Add("-7,2\n-3");
	        } catch (Exception e){
	            assertEquals("-7,-3", e.getMessage());
	        }
	    }

}
