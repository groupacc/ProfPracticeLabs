package com.yurkiv.munging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bagira on 22.12.2015.
 */
public class DataMunger<T extends Spreadable> {

    private List<T> table;

    public DataMunger(String fileName, Pattern row, Function<Matcher, T> mapper) {
        try {
            table = parse(Files.readAllLines(Paths.get(fileName)), row, mapper);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file: " + e.getMessage());
        }
    }

    public T getWithMinSpread() {
        List<T> temp = new ArrayList<>(table);
        Collections.sort(temp, (s1, s2) -> s1.getSpread() - s2.getSpread());
        return temp.get(0);
    }

    private List<T> parse(List<String> lines, Pattern row, Function<Matcher, T> mapper) {
        List<T> result = new ArrayList<>();
        for (String str : lines) {
            Matcher matcher = row.matcher(str);
            if (matcher.find()) {
                result.add(mapper.apply(matcher));
            }
        }
        return result;
    }

}
