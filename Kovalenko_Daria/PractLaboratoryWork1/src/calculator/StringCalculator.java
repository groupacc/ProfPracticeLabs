package calculator;

import java.util.regex.*;


public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        StringBuilder numbersNeg = new StringBuilder();
        int solution = 0;

        if(numbers.startsWith("//")) {
            numbers = numbers.substring(2);
            String delimiter = "";
            String allNumbers = "";

            if(numbers.startsWith("[")) {

                Pattern pat = Pattern.compile("(\\[)(.+)(\\])");
                Matcher match = pat.matcher(numbers);
                while (match.find()) {
                    delimiter += match.group(2);
                    delimiter += "\n";
                }

                for (String s : numbers.split("(\\[)(.+)(\\])")) {
                    allNumbers += s;
                }
            } else {
                //one delimiter
                delimiter += numbers.charAt(0);
                allNumbers = numbers.substring(1);
            }

            if(!allNumbers.startsWith("\n")) {
                throw new IllegalArgumentException("symbol \n is required");
            }

            Pattern p = Pattern.compile("([-]?[\\d]+)(\\D*)");
            Matcher m = p.matcher(allNumbers);

            while (m.find()) {

                int number = Integer.parseInt(m.group(1));
                String s = m.group(2);

                if(!delimiter.contains(m.group(2))) {
                    throw new IllegalArgumentException();
                }
                if (number < 0) {
                    numbersNeg.append(number);
                }
                if (number <= 1000) {
                    solution += number;
                }
            }
        } else {

            Pattern p = Pattern.compile("([-]?[\\d]+)(\\,|\\\n)*");
            Matcher m = p.matcher(numbers);
            while (m.find()) {
                int number = Integer.parseInt(m.group(1));


                if (number < 0) {
                    numbersNeg.append(number);
                }
                if (number <= 1000) {
                    solution += number;
                }
            }
        }
        if (numbersNeg.length() != 0) {
            throw new IllegalArgumentException("negatives not allowed: " + numbersNeg.toString());
        }
        return solution;
    }


}
