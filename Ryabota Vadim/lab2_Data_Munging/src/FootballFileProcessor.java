import java.util.LinkedList;

public class FootballFileProcessor {

    public String processFile(LinkedList<LinkedList<String>> data) {
        String name = "";
        int min = Integer.MAX_VALUE;
        data.remove(17);
        //parsing file
        for(LinkedList<String> list : data) {
            if(list.size() != 0) {
                int temp = Math.abs(Integer.parseInt(list.get(8).replaceAll("\\D+", "")) -
                        Integer.parseInt(list.get(6).replaceAll("\\D+", "")));
                if(temp < min) {
                    min = temp;
                    //correct answer
                    name = list.get(1);
                }
            }
        }

        return name;
    }
}
