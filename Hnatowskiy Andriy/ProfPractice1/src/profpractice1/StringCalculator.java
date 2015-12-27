/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profpractice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author Andrew
 */
public class StringCalculator {
    
    public StringCalculator() {
        
    }
    
    public int add(String str) {
        if(str.isEmpty()) {
            return 0;
        }
        
        String[] distinctNumbers = toStringsArray(str);
        int[] numbers = stringsToInts(distinctNumbers);
        checkForNegative(numbers);
        return sum(numbers); 
    }
    
    private static int[] stringsToInts(String[] numbers) {
        int[] converted = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            converted[i] = Integer.parseInt(numbers[i]);
        }
        
        return converted;
    }
    
    private static String[] toStringsArray(String str) {
        
        List<String> delimiters = new ArrayList<>();
        delimiters.addAll(Arrays.asList(",", "\n"));
        String justNums;
        
        if(str.startsWith("//")) {
            String dels = str.substring(2, str.indexOf("\n"));
            if(dels.contains("[") && dels.contains("]")) {
                Pattern multiCharDelimiter = Pattern.compile("\\[([^\\]]+)\\]");
                Matcher matcher = multiCharDelimiter.matcher(dels);
                while (matcher.find()) {
                    delimiters.add(matcher.group(1));
                }
            } else {
                delimiters.add(dels);
            }
            justNums = str.substring(str.indexOf("\n") + 1);
            /*Pattern p = Pattern.compile("//(.)\n(.*)");
            Matcher m = p.matcher(str);
            m.matches();
            String newDelimiter = m.group(1);
            
            return m.group(2).split("\\" + newDelimiter);*/
        } else {
            justNums = str;
        }
        StringJoiner joiner = new StringJoiner("|");
        for(String s : delimiters) {
            joiner.add(s);
        }
        String delRegex = joiner.toString();
        
        return justNums.split(delRegex);
    }
    
    private static int sum(int[] nums) {
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 1000) {
                sum += nums[i];
            }
        }
        
        return sum;
    }
    
    private static void checkForNegative(int[] nums){ 
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                throw new NegativeNumberException(i + "-th number is negative");
            }
        }
    }
}
