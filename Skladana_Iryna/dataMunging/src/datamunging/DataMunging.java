/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamunging;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
/**
 *
 * @author iryna
 */
public class DataMunging {

    private static int DAY = 1;
    private static int MAX_TEMP = 2;
    private static int MIN_TEMP = 3;

    private static int TEAM = 2;
    private static int FOR = 7;
    private static int AGAINST = 9;

    private File file;
    
    public DataMunging(final File file) {
        this.file = file;
    }
    public File getFile() {
        return this.file;
    }
    
    public void setFile(final File file) {
        this.file = file;
    }

    private Map<String, Integer> tempSpreadOfDay = new HashMap<String, Integer>();
    private Map<String, Integer> goalSpreadOfTeam = new HashMap<String, Integer>();

    
    public String smallestTemperatureSpreadDay() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(this.file));
        String lineRead = null;
        String day = "";
        String minTemperature = "";
        String maxTemperature = "";
        while ((lineRead = reader.readLine()) != null) {
            final String[] items = divideLine(lineRead);
            day = findValue(items, DAY);
            maxTemperature = findValue(items, MAX_TEMP);
            minTemperature = findValue(items, MIN_TEMP);
            daySpreedRecord(day, toInt(minTemperature), toInt(maxTemperature));
            //System.out.println("Day: " + day + ", min temperature: " + minTemp + ", max temperature: " + maxTemp);
        }
        return smallestSpread();
    }

    private String smallestSpread() {
        String day = "";
        int spread = 0;
        for (final Entry<String, Integer> map : this.tempSpreadOfDay.entrySet()) {
            if (spread == 0 || map.getValue() < spread && toNumber(map.getKey()) && notNegavtiveValue(map.getValue())) {
                day = map.getKey();
                spread = map.getValue();
            }
        }
        System.out.println("Day with the smallest spreed:"
                + "\nDay: " + day + ", Spread: " + spread);
        return day;
    }

    public String smallestGoalDifferenceTeam() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(this.file));
        String lineRead = null;
        String team = "";
        String forGoals = "";
        String againstGoals = "";
        while ((lineRead = reader.readLine()) != null) {
            final String[] items = divideLine(lineRead);
            team = findValue(items, TEAM);
            forGoals = findValue(items, FOR);
            againstGoals = findValue(items, AGAINST);
            goalSpreadRecord(team, toInt(forGoals), toInt(againstGoals));
            // System.out.println("Team: " + team + ", For: " + forGoals + ", Against: " + againstGoals);
        }
        return smallestGoalSpread();
    }

    private String smallestGoalSpread() {
        final List<Integer> values = new ArrayList<Integer>();
        final List<String> teams = new ArrayList<String>();

        for (final Entry<String, Integer> teamEntry : this.goalSpreadOfTeam.entrySet()) {
            values.add(Math.abs(teamEntry.getValue()));
            teams.add(teamEntry.getKey());
        }

        int lastVal = 0;
        int currentVal = 0;
        int matchPos = 0;
        for (int i = 0; i < values.size(); i++) {
            currentVal = values.get(i);
            if (i != 0) {
                lastVal = values.get(i - 1);
            }
            if (lastVal != 0 && currentVal < values.get(matchPos)) {
                matchPos = i;
            }
        }
        System.out.println("The team with the smallest difference in ‘for’ and ‘against’ goals:"
                + "\nTeam: " + teams.get(matchPos) + lastVal);
        return teams.get(matchPos);
    }

    private int toInt(final String temp) {
        try {
            return Integer.parseInt(temp);
        } catch (final NumberFormatException exception) {
            // Do nothing
        }
        return -1;
    }

    private boolean notNegavtiveValue(final Integer value) {
        return value > 0;
    }

    private boolean toNumber(final String key) {
        return -1 != toInt(key);
    }

    private void goalSpreadRecord(final String team, final int forGoals, final int againstGoals) {
        if (forGoals != -1 || againstGoals != -1) {
            this.goalSpreadOfTeam.put(team, (forGoals - againstGoals));
        }
    }

    private void daySpreedRecord(final String day, final int minTemp, final int maxTemp) {
        if (minTemp != -1 || maxTemp != -1) {
            this.tempSpreadOfDay.put(day, maxTemp - minTemp);
        }
    }

    private String[] divideLine(final String lineRead) {
        final Pattern p = Pattern.compile("\\s+");
        final String[] items = p.split(lineRead);
        return items;
    }

    private String findValue(final String[] items, final int columnIndex) {
        for (int i = 0; i < items.length; i++) {
            if (i == columnIndex) {
                return items[i];
            }
        }
        return "";
    }
}
