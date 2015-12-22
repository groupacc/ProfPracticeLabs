package Weather;

import Common.*;
import Football.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MonthLoader implements GroupLoader {
    public int load(Group group) throws IOException {
        int amount = 0;

        BufferedReader reader = new BufferedReader(new FileReader("src//weather.dat"));
        RowReader loader = new RowReader();

        boolean firstLine = true;
        String line;
        String[] params;
        while((line = reader.readLine()) != null) {
            if(firstLine) {
                firstLine = false;
                continue;
            }

            if((params = loader.getParameters(line)) == null) {
                continue;
            }

            if(params[0].equals("mo")) {
                continue;
            }

            group.add(new WeatherInfo(
                    Integer.parseInt(params[0]),
                    Double.parseDouble(params[1]),
                    Double.parseDouble(params[2])
            ));
            amount++;
        }
        return amount;
    }
}
