package com.yurkiv.munging;

import java.util.regex.Pattern;

/**
 * Created by Bagira on 22.12.2015.
 */
public class Main {

    public static void main(String[] args) {
        DataMunger<Weather> weatherMunger = new DataMunger<>("weather.dat",
                Pattern.compile(" +(\\d+) +(\\d+)\\*? +(\\d+)\\*?"),
                matcher -> {
                    Weather weather = new Weather();
                    weather.setDay(Integer.parseInt(matcher.group(1)));
                    weather.setMax(Integer.parseInt(matcher.group(2)));
                    weather.setMin(Integer.parseInt(matcher.group(3)));
                    return weather;
                });
        System.out.println(weatherMunger.getWithMinSpread());

        DataMunger<FootballResult> footballMunger = new DataMunger<>("football.dat",
                Pattern.compile("[^\\.]+\\. (\\w+) +(?:\\d+) +(?:\\d+) +(?:\\d+) +(?:\\d+) +(\\d+) +- +(\\d+)"),
                matcher -> {
                    FootballResult result = new FootballResult();
                    result.setName(matcher.group(1));
                    result.setScored(Integer.parseInt(matcher.group(2)));
                    result.setLost(Integer.parseInt(matcher.group(3)));
                    return result;
                });
        System.out.println(footballMunger.getWithMinSpread());
    }
}
