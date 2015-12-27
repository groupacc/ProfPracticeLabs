package com.pavelsikun.tdd.lab2.football;

import com.pavelsikun.tdd.lab2.Spreadable;

import java.util.List;

/**
 * Created by mrbimc on 23.12.15.
 */
public class FootballModel implements Spreadable {

    private int scored, passed;
    private String teamName;

    public FootballModel(String teamName, int scored, int passed) {
        this.scored = scored;
        this.passed = passed;
        this.teamName = teamName;
    }

    @Override
    public int getSpread() {
        return Math.abs(scored - passed);
    }


    @Override
    public String toString() {
        return "FootballModel{" +
                "scored=" + scored +
                ", passed=" + passed +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
