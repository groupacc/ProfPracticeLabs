package Football;

import Common.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SeasonLoader implements GroupLoader {
    public int load(Group group) throws IOException {
        int amount = 0;

        BufferedReader reader = new BufferedReader(new FileReader("src//football.dat"));
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

            group.add(new FootballClub(
                    params[1], // Team column
                    Integer.parseInt(params[6]), // F column
                    Integer.parseInt(params[7]) // A column
            ));
            amount++;
        }
        return amount;
    }
}