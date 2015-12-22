
public class Calculate {
    public int calc(String numbers) {
        int result = 0;
        StringBuffer negativeVals = new StringBuffer();

        int limit = -1;
        for (String s : numbers.split("\\D")) {
            if (limit != -1 && limit-- < 1) break;

            try {
                int number = Integer.parseInt(s);

                if(number < 0) {
                    negativeVals.append(number);
                    negativeVals.append(" ");
                    continue;
                }
                if(number > 1000) {
                    continue;
                }

                result += number;
            } catch(Exception e) {
            }
        }

        try {
            if (negativeVals.length() != 0) {
                throw new Exception("Negative values are not allowed " + negativeVals);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
