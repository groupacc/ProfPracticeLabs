import java.util.LinkedList;

public class WeatherFileProcessor {

    public String processFile(LinkedList<LinkedList<String>> data) {
        String dayNumber = "";
        double minimum = Double.MAX_VALUE;
        //parsing file
        for(LinkedList<String> list : data) {
            if(list.size() != 0){
                double temp = Math.abs(Double.parseDouble(list.get(2).replaceAll("\\D+", "")) -
                        Double.parseDouble(list.get(1).replaceAll("\\D+", "")));
                if(temp < minimum) {
                    minimum = temp;
                    //correct day
                    dayNumber = list.get(0);
                }
            }
        }
        return dayNumber;
    }
}
