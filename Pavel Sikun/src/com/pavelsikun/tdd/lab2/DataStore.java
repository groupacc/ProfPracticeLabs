package com.pavelsikun.tdd.lab2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mrbimc on 23.12.15.
 */
public abstract class DataStore<T extends Spreadable> {

    private List<String> getFileLines() {
        Path path = Paths.get(getFileName());
        try { return Files.readAllLines(path); }
        catch (IOException e) { return new ArrayList<>(); }
    }

    public List<T> getTable() {
        return new Parser(getRowPattern())
                .parse(getFileLines())
                .stream()
                .map(this::getRowMapper)
                .collect(Collectors.toList());
    }

    abstract public String getFileName();

    abstract public String getRowPattern();

    abstract public T getRowMapper(List<String> row);
}

