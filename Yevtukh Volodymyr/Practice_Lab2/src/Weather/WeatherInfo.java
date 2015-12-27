package Weather;

import Common.*;

public class WeatherInfo implements DataUnit, Comparable<WeatherInfo> {
    protected int dayNumber;
    double minTemperature;
    double maxTemperature;


    public WeatherInfo(int dayNumber, double min, double max) {
        this.dayNumber = dayNumber;
        this.minTemperature = min;
        this.maxTemperature = max;
    }

    public int getSpread() {
        return (int)Math.abs(this.maxTemperature - this.minTemperature);
    }

    public void setDayNumber(int n) {
        this.dayNumber = n;
    }

    public int getDayNumber() {
        return this.dayNumber;
    }

    public void setMinTemperature(double min) {
        this.minTemperature = min;
    }

    public double getMinTemperature() {
        return this.minTemperature;
    }

    public void setMaxTemperature(double man) {
        this.minTemperature = man;
    }

    public double getMaxTemperature() {
        return this.maxTemperature;
    }

    @Override
    public int compareTo(WeatherInfo o) {
        return Integer.compare(this.dayNumber, o.dayNumber);
    }

    @Override
    public String toString() {
        return "Day " + dayNumber +
                ": minTemperature = " + minTemperature +
                "; maxTemperature = " + maxTemperature +
                "; spread = " + getSpread();
    }
}
