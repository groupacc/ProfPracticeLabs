package lab2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.valueOf;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.compile;


public class Forecast implements Reader{
	 private ArrayList<Weather> forecast = new ArrayList<>();
	    
	    @Override
	    public void Read(File file) throws IOException {

		try {
	            BufferedReader buffReader = new BufferedReader(new FileReader( file.getAbsoluteFile()));
	            
	            String line;
	            boolean inData = false;
	            while ((line = buffReader.readLine()) != null) {
	                if (inData == true && line.startsWith("  mo")) {
	                    inData = false;
			} else if (inData == false && line.startsWith("   ")) {
	                    inData = true;
			}
	                if (inData) {
	                    Pattern p = compile("\\d");
	                    Matcher m = p.matcher(line);
	                    m.find();
	                    int dayStartIndex = m.start();
	                    p = compile("\\d ");
	                    m = p.matcher(line);
	                    m.find();
	                    int dayEndIndex = m.start() + 1;
	                    int day = valueOf(line.substring(dayStartIndex, dayEndIndex));
	                    
	                    p = compile("\\d  ");
	                    m = p.matcher(line);
	                    m.find();
	                    int maxStartIndex = m.end();
	                    p = compile("\\d  \\d+");
	                    m = p.matcher(line);
	                    m.find();
	                    int maxEndIndex = m.end();
	                    int maxTemp = valueOf(line.substring(maxStartIndex, maxEndIndex));

	                    p = compile("    \\d");
	                    m = p.matcher(line);
	                    m.find();
	                    int minStartIndex = m.end() - 1;
	                    p = compile("    [\\d]+");
	                    m = p.matcher(line);
	                    m.find();
	                    int minEndIndex = m.end();
	                    int minTemp = valueOf(line.substring(minStartIndex, minEndIndex));

	                    getForecast().add(new Weather(day, maxTemp, minTemp));
	                }
	            }
	            
	            Weather smallestTemperatureSpead = calcTheSmallest(getForecast());
	            
	            out.println("\n\033[31mDay " + smallestTemperatureSpead.getDay() +
	                               " has the smallest spead of temperature \033[31m" + smallestTemperatureSpead.getTemperatureSpread());
	        
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private Weather calcTheSmallest(ArrayList<Weather> forecast) {
	        Weather smallestTemperatureSpead = forecast.get(0);
	        for (Weather weather : forecast) {
	            out.println(weather.toString());
	            int temperatureSpread = weather.getTemperatureSpread();
	            if (temperatureSpread < smallestTemperatureSpead.getTemperatureSpread()) {
	                smallestTemperatureSpead = weather;
	            }
	        }
	        return smallestTemperatureSpead;
	    }

	    public ArrayList<Weather> getForecast() {
	        return forecast;
	    }

	    public void setForecast(ArrayList<Weather> forecast) {
	        this.forecast = forecast;
	    }
}
