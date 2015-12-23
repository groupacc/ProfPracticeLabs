/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

/**
 *
 * @author pirog
 */
public class WeatherReader {
    private LinkedList<String> lineList;
    public WeatherReader() {
        lineList = new LinkedList<>();
    }
    public void read(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File (filePath)));
            String line;
            while ((line = reader.readLine()) != null) {
                lineList.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        lineList.removeLast();
    }
    public void show() {
        if (!lineList.isEmpty()) {
            int indexMax = lineList.getFirst().indexOf("xT");
            int indexMin = lineList.getFirst().indexOf("nT");
            int best = 0;
            String day = "";
            for (String s : lineList) {
                int max = 0, min = 0;
                if (!s.equals(lineList.getFirst()) && !s.equals(lineList.get(1))) {
                    min = Integer.parseInt(s.substring(indexMin, indexMin+2));
                    max = Integer.parseInt(s.substring(indexMax, indexMax+2));
                }
                if ((max - min) > best) {
                    best = max - min;
                    day = s;
                }
            }
            System.out.println("Best day with dofference: "+best);
            System.out.println(lineList.getFirst());
            System.out.println(day);
        }
    }
    public void showAll() {
        if (!lineList.isEmpty()) {
            for (String s : lineList) {
                System.out.println(s);
            }
        }
    }
}
