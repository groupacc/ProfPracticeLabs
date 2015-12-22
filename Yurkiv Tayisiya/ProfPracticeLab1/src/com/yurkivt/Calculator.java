package com.yurkivt;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bagira on 22-Dec-15.
 */
public class Calculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiters =  "\n|,";
        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, numbers.indexOf("\n"));
            if(delimiter.contains("[") && delimiter.contains("]")) {
                Pattern manyDelimiters = Pattern.compile("\\[([^\\]]+)\\]");
                Matcher matcher = manyDelimiters.matcher(delimiter);
                while (matcher.find()) {
                    delimiters += "|" + Pattern.quote(matcher.group(1));
                }
            } else {
                delimiters += "|" + delimiter;
            }
            numbers = numbers.substring(numbers.indexOf("\n")+1);

        }

        String[] numbersSplit = numbers.split(delimiters);
        ArrayList<String> negativeNums = new ArrayList<String>();

        if(numbersSplit.length == 1) {
            return Integer.valueOf(numbersSplit[0]);
        }
        int result = 0;
        for (String s : numbersSplit) {
            int intNum = Integer.parseInt(s);
            if (intNum < 0) {
                negativeNums.add(s);
            }else if (intNum <= 1000) {
                result+= intNum;
            }
        }
        if (!negativeNums.isEmpty()) {
            throw new NegativesNotAllowedException("Negative values are not allowed " + negativeNums);
        }

        return result;
    }
}
