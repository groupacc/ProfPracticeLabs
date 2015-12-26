import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ppk on 26-Dec-15.
 */
public class StringCalculator {
    HashSet<String> delimiters;

    private String parseDelimitersAndReturnStringToHandle(String line) {
        delimiters = new HashSet<>();

        if (line.startsWith("//")) {
            // case with user defined delimiters

            // making line is block with delimiters declaration
            int newLinePos = line.indexOf('\n');
            if (newLinePos == -1) {
                throw new IllegalArgumentException();
            }
            String tempLine = line.substring(2, newLinePos);

            Pattern delimPattern = Pattern.compile("(\\[)(\\D+)(\\])");
            Matcher delimMather = delimPattern.matcher(line);


            while (delimMather.find()) {
                tempLine = delimMather.group();

            }

            tempLine = tempLine.replace('[', '-');
            tempLine = tempLine.replace(']', '-');

            String[] delims = tempLine.split("-");

            for (String d : delims) {
                delimiters.add(d);
            }

            return line.substring(line.indexOf('\n') + 1);
        }
        else {
            // default delimiters
            delimiters.add("\n");
            delimiters.add(",");

            return line;
        }
    }

    public int add(String numbers) throws NegativeNotAllowedException {
        if (numbers.isEmpty()) {
            return 0;
        }

        int sum = 0;

        numbers = parseDelimitersAndReturnStringToHandle(numbers);

        if (!Character.isDigit(numbers.charAt(numbers.length() -1 ))) {
            throw new IllegalArgumentException();
        }

        StringBuilder regex = new StringBuilder();
        regex.append("[");
        for (String d : delimiters) {
            regex.append(d);
        }
        regex.append("]");

        String[] nums = numbers.split(regex.toString());

        int num = 0;
        for (String n : nums) {
            if (!"".equals(n)) {
                num = Integer.parseInt(n);
                if (num < 1001 && num >= 0) {
                    sum += num;
                }
                else if (num < 0){
                    throw new NegativeNotAllowedException();
                }
            }
        }

        return sum;
    }
}
