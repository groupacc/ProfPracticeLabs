package com.pavelsikun.tdd.lab2.weather;

import com.pavelsikun.tdd.lab2.Spreadable;

/**
 * Created by mrbimc on 23.12.15.
 */
public class WeatherModel implements Spreadable {

    private int min, max, day;

    public WeatherModel(int day, int max, int min) {
        this.day = day;
        this.max = max;
        this.min = min;
    }

    @Override
    public int getSpread() {
        return max - min;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "min=" + min +
                ", max=" + max +
                ", day=" + day +
                '}';
    }
}
