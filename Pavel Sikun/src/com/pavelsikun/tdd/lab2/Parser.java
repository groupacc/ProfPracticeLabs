package com.pavelsikun.tdd.lab2;

import javafx.util.Pair;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mrbimc on 23.12.15.
 */
public class Parser {

    Pattern pattern;

    public Parser(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public List<List<String>> parse(List<String> str) {
        return str.stream()
                .map(s -> new Pair<>(s, pattern.matcher(s)))
                .filter(p -> p.getValue().find())
                .map(this::mapper)
                .collect(Collectors.toList());
    }

    List<String> mapper(Pair<String, Matcher> p) {
        Matcher m = p.getValue();
        return IntStream.rangeClosed(1, m.groupCount())
                .mapToObj(m::group)
                .collect(Collectors.toList());
    }
}
