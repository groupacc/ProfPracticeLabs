import java.util.LinkedList;

public class FootballFileProcessor {

    public String processFile(LinkedList<LinkedList<String>> elements) {
        String str = "";
        int min = Integer.MAX_VALUE;
        elements.remove(17);
        for(LinkedList<String> list : elements) {
            if(list.size() != 0) {
                int temp = Math.abs(Integer.parseInt(list.get(8).replaceAll("\\D+", "")) -
                        Integer.parseInt(list.get(6).replaceAll("\\D+", "")));
                if(temp < min) {
                    min = temp;
                    //correct answer
                    str = list.get(1);
                }
            }
        }

        return str;
    }
}
