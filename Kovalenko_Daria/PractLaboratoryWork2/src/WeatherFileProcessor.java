import java.util.LinkedList;

public class WeatherFileProcessor {
    public String processFile(LinkedList<LinkedList<String>> elements) {
        double minimum = Double.MAX_VALUE;
        String day = "";
        for(LinkedList<String> list : elements) {
            if(list.size() != 0){
                double temp = Math.abs(Double.parseDouble(list.get(2).replaceAll("\\D+", ""))-Double.parseDouble(list.get(1).replaceAll("\\D+", "")));
                if(temp < minimum) {
                    minimum = temp;
                    //correct day
                    day = list.get(0);
                }
            }
        }
        return day;
    }
}
