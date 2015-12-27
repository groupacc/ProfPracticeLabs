package com.pavelsikun.tdd.lab2.football;

import com.pavelsikun.tdd.lab2.DataStore;

import java.util.List;

/**
 * Created by mrbimc on 23.12.15.
 */
public class FootballStore extends DataStore<FootballModel> {

    @Override
    public String getFileName() {
        return "football.dat";
    }

    @Override
    public String getRowPattern() {
        return "[^\\.]+\\. (\\w+) +(?:\\d+) +(?:\\d+) +(?:\\d+) +(?:\\d+) +(\\d+) +- +(\\d+)";
    }

    @Override
    public FootballModel getRowMapper(List<String> row) {
        return new FootballModel(
                row.get(0),
                Integer.parseInt(row.get(1)),
                Integer.parseInt(row.get(2)));
    }

}
