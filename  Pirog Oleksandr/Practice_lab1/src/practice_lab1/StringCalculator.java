/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_lab1;

import java.util.LinkedList;

/**
 *
 * @author pirog
 */
public class StringCalculator {
    public int add(String numbers) throws Exception { //"!;!2;5;3"
        if(numbers != null) {
            if(numbers.isEmpty())
                return 0;
            String delimiter = "|,";
            if(numbers.length() > 2)
                if(numbers.startsWith("p"))
                    delimiter += "|" + numbers.charAt(1);
            String[] num = numbers.split("\n"+delimiter);
            int res = 0;
            boolean neg = false;
            LinkedList<Integer> negList = new LinkedList<>();
            if(num.length > 0) {
                for (String num1 : num)
                    if (!num1.isEmpty() && !num1.equals("p")) {
                        int value = Integer.parseInt(num1);
                        if (value < 0) {
                            neg = true;
                            negList.add(value);
                        } else {
                            res += value;
                        }
                    }
            }
            if (neg) {
                String msg = "Negative number occure! ";
                for (Integer i : negList) {
                    msg += i+"; ";
                }
                throw new Exception(msg);
            }
            return res;
        }
        return 0;
    }
}
