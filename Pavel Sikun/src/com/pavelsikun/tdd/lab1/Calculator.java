package com.pavelsikun.tdd.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mrbimc on 23.12.15.
 */
public class Calculator {

    ArrayList<String> delimiters = new ArrayList<>();

    ArrayList<Integer> negatives = new ArrayList<>();

    String parseDelimeters(String line) {
        delimiters = new ArrayList<>();

        if(!line.startsWith("//")) {
            delimiters.add(",");
            delimiters.add(", ");
            return line;
        }

        line = line.substring(2);

        if(!line.contains("]")) {
            delimiters.add(line.split("\n")[0]);
            return line.substring(delimiters.get(0).length());
        }

        String delims = line.substring(0, line.indexOf("\n"));
        line = line.substring(delims.length());
        if (delims.contains("[") && delims.contains("]")) {
            Pattern multiDelim = Pattern.compile("\\[([^\\]]+)\\]");
            Matcher matcher = multiDelim.matcher(delims);
            while (matcher.find())
                delimiters.add(matcher.group(1));
        }

        return line;
    }

    int add(String line) throws NegativeNumberException {
        final String l = parseDelimeters(line);

        List<Integer> nums = Stream.of(l.split(delimiters.get(0)))
                .map(s -> s.split("\n")).flatMap(Stream::of)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .filter(it -> it < 1000)
                .collect(Collectors.toList());

        nums.stream().filter(it -> it < 0).forEach(negatives::add);
        if(!negatives.isEmpty()) throw new NegativeNumberException("negative numbers! ->" + getListOfNegatives());
        return nums.stream().reduce((a, b) -> a + b).orElse(0);
    }

    String getListOfNegatives() {
        StringBuilder sb = new StringBuilder();
        negatives.forEach(it -> sb.append(" " + it));
        negatives.clear();
        return sb.append(";").toString();
    }

    public static void main(String[] args) {
        try{
            int res = new Calculator().add("//[__][<<]\n11__23__45>>98");
            System.out.println(res);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(":(");
        }
    }

}
