package com.pavelsikun.tdd.lab2;

import com.pavelsikun.tdd.lab2.football.FootballModel;
import com.pavelsikun.tdd.lab2.football.FootballStore;
import com.pavelsikun.tdd.lab2.weather.WeatherModel;
import com.pavelsikun.tdd.lab2.weather.WeatherStore;

/**
 * Created by mrbimc on 23.12.15.
 */
public class Main {

    public static void main(String[] args) {
        WeatherModel minimalSpreadWeather = new WeatherStore().getTable().stream().sorted().findFirst().get();
        System.out.println(minimalSpreadWeather);

        FootballModel minimalSpreadFootball = new FootballStore().getTable().stream().sorted().findFirst().get();
        System.out.println(minimalSpreadFootball);
    }
}
