package com.pavelsikun.tdd.lab2.weather;

import com.pavelsikun.tdd.lab2.DataStore;
import com.pavelsikun.tdd.lab2.Spreadable;

import java.util.List;

/**
 * Created by mrbimc on 23.12.15.
 */
public class WeatherStore extends DataStore<WeatherModel> {

    @Override
    public String getFileName() {
        return "weather.dat";
    }

    @Override
    public String getRowPattern() {
        return " +(\\d+) +(\\d+)\\*? +(\\d+)\\*?";
    }

    @Override
    public WeatherModel getRowMapper(List<String> row) {
        return new WeatherModel(
                Integer.parseInt(row.get(0)),
                Integer.parseInt(row.get(1)),
                Integer.parseInt(row.get(2)));
    }
}
