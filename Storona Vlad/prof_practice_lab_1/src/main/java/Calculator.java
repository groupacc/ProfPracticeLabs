/**
 * Created by franky_str on 22.12.15.
 */
public class Calculator {

    public int sum(String input) {

        int sum = 0;

        for(String s : input.split("[\n|;|,|/|*|\\[|\\]|\\*]+")) {
            try {
                int number = Integer.parseInt(s);
                if (number < 0) {
                    throw new Exception("Negatives not allowed !! " + number);
                } else if (number > 1000) {
                    number = 0;
                }
                sum += number;

                if (sum > 1000) {
                    sum = number;
                }
            }
            catch (Exception exc) {
                System.out.println("Warning!" + exc.getMessage());
            }
        }
        System.out.println(sum);
        return sum;
    }
}
