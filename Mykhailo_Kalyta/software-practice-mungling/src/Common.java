import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by ppk on 26-Dec-15.
 */
public class Common {
    public static Map<Integer, List<String>> parse(String filename, int totalColumNum) {
        Map<Integer, List<String>> result = new LinkedHashMap<>();

        if (totalColumNum < 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < totalColumNum; i++) {
            result.put(i, new ArrayList<>());
        }

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if ("".equals(line)) {
                    continue;
                }
                Scanner lineScanner = new Scanner(line);

                for (int i = 0; i < totalColumNum; i++) {
                    String str = lineScanner.next();

                    if (i == 0 && !(str.matches("(\\d)+(.?)"))) {
                        break;
                    }
                    if (i != 0 && str.matches("(\\d)+(.?)")) {
                        str = str.substring(0, str.length() - 1 );
                    }

                    if (result.containsKey(i)) {
                        result.get(i).add(str);
                    }
                }

            }
        } catch (FileNotFoundException fnfe) {
            throw new Error();
        }

        return result;
    }

    public static String rowIdWithSmallestDifference(Map<Integer, List<String>> data,
                                                     int columnWithRowId,
                                                   int columnToDif1, int columnToDif2) {
        int minDiff = Integer.MAX_VALUE;
        int minId = -1;
        for (int i = 0; i < data.get(columnToDif1).size(); i++) {
            int dif = Math.abs(Integer.parseInt(data.get(columnToDif1).get(i))
                    - Integer.parseInt(data.get(columnToDif2).get(i)));

            if (minDiff > dif) {
                minDiff = dif;
                minId = i;
            }
        }

        return data.get(columnWithRowId).get(minId);
    }

}
