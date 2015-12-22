/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string_calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author iryna
 */
public class Calculator {
    
    private static int toInt(String text) throws NumberFormatException{
    int num =Integer.parseInt(text);
    if(num<0)throw new RuntimeException("negative not allowed"+ num);
    return num;
    }
    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;  
        }else if(numbers.startsWith("//"))  {
          Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
          matcher.matches();  
          String separators = matcher.group(1);
          String numb = matcher.group(2);
          String[] symbols = numb.split(Pattern.quote(separators));
          int sum=0;
          for(String symbol:symbols){
            sum+=toInt(symbol); 
        }return sum;
        }else if(numbers.contains(",")){
            String[] symbols = numbers.split(",|\n");
            int size = symbols.length;
            int sum = 0;
            String negative = "";
            for (int i = 0; i < size; i++){
                if(symbols[i].matches("-(\\d)*")){
                    negative += symbols[i];
                } else {
                    sum += toInt(symbols[i]);
                }
            }
            if(negative.length() > 0){
                System.out.println("Negative not allowed: " + negative); 
                return 1;
            }           
            return sum;
        }else if(numbers.contains("\n")){
        String[] symbols = numbers.split("\n");
        int sum=0;
        for(String symbol:symbols){
            sum+=toInt(symbol);  
        }return sum;
        }else {
            return Integer.parseInt(numbers);
        } 
        
    }
  
}

