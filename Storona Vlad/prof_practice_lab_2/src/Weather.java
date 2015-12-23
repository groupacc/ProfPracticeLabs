import java.util.LinkedList;
import java.util.List;

/**
 * Created by franky_str on 22.12.15.
 */
public class Weather {

    private static final String WEATHER_FILE = "/home/franky_str/prof_practice_lab_2/weather.dat";

    public static String minTemperatureDifference() {
        List<List<String>> temperatureList = Common.readFile(WEATHER_FILE);
        temperatureList.remove(temperatureList.size()-1);
        return Common.minDifference((LinkedList)temperatureList, 0);
    }
}
