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
public class FootballReader {
    private LinkedList<String> lineList;
    public FootballReader() {
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
            int indexF = lineList.getFirst().indexOf("F"); //43
            int indexA = lineList.getFirst().indexOf("A"); //50
            int best = 0;
            String team = "";
            for (String s : lineList) {
                int F = 0, A = 0;
                if (!s.equals(lineList.getFirst()) && !s.contains("---")) {
                    F = Integer.parseInt(s.substring(indexF, indexF+2));
                    A = Integer.parseInt(s.substring(indexA, indexA+2));
                }
                if ((F - A) > best) {
                    best = F - A;
                    team = s;
                }
            }
            System.out.println("Best team with difference: "+best);
            System.out.println(lineList.getFirst());
            System.out.println(team);
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
