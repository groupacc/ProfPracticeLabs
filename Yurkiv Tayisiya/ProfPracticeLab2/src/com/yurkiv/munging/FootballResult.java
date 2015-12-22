package com.yurkiv.munging;

/**
 * Created by Bagira on 22.12.2015.
 */
public class FootballResult implements Spreadable {

    private String name;
    private int scored;
    private int lost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScored() {
        return scored;
    }

    public void setScored(int scored) {
        this.scored = scored;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    @Override
    public int getSpread() {
        return Math.abs(scored - lost);
    }

    @Override
    public String toString() {
        return "FootballResult{" +
                "lost=" + lost +
                ", scored=" + scored +
                ", name='" + name + '\'' +
                '}';
    }
}
