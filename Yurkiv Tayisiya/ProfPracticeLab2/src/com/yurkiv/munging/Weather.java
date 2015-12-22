package com.yurkiv.munging;

/**
 * Created by Bagira on 22.12.2015.
 */
public class Weather implements Spreadable {

    private int day;
    private int max;
    private int min;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public int getSpread() {
        return max - min;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "day=" + day +
                ", max=" + max +
                ", min=" + min +
                '}';
    }
}
