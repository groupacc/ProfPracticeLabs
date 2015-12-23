import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by franky_str on 22.12.15.
 */
public class Common {

    public static List<List<String>> readFile(String fileName) {

        List<List<String>> result = new LinkedList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            while (line != null) {

                List<String> list = new LinkedList<>();

                for (String tmp: line.split(" ")){
                    if(!tmp.equals("")) {
                        list.add(tmp);
                    }
                }

                result.add(list);
                line = reader.readLine();

            }

            result.remove(0);

        } catch (IOException ioe) {
            System.err.println(ioe.getCause());
            System.out.println(ioe.getMessage());
        }

        return result;
    }

    public static String minDifference(List<List<String>> allList, int variant) {

        int col_1;
        int col_2;

        int minDif = 1000;
        int curDif;

        int t1 = 0;
        int t2 = 0;

        String symbols;
        String result = "";
        List<String> list;

        Iterator iterator = allList.iterator();

        while (iterator.hasNext()) {
            list = (LinkedList<String>) iterator.next();
            if (list.size() != 0) {
                String s1 = "";
                String s2 = "";
                switch(variant) {
                    case 0:
                        col_1 = 1;
                        col_2 = 2;
                        symbols = "*";
                        s1 = list.get(col_1).replace(symbols, "");
                        s2 = list.get(col_2).replace(symbols, "");
                        break;
                    case 1:
                        col_1 = 6;
                        col_2 = 8;
                        if (list.size() > 6) {
                            s1 = list.get(col_1);
                            s2 = list.get(col_2);
                        }
                        break;
                }
                if (!s1.equals("")) {
                    t1 = Integer.parseInt(s1);
                    t2 = Integer.parseInt(s2);
                }
                curDif = Math.abs(t1 - t2);
                if (curDif < minDif) {
                    minDif = curDif;
                    result = list.get(variant);
                }
            }
        }
        return result;
    }
}
