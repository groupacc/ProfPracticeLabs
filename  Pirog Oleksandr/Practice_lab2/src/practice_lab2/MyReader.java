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
public class MyReader {
    private LinkedList<String> lineList;
    private FileType type;
    public MyReader(FileType fileType) {
        lineList = new LinkedList<>();
        type = fileType;
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
            int indexMax = indexOfMax();
            int indexMin = indexOfMin();
            int best = 0;
            String res = "";
            for (String s : lineList) {
                int min = 0, max = 0;
                if (isCorrect(s)) {
                    min = Integer.parseInt(s.substring(indexMin, indexMin+2));
                    max = Integer.parseInt(s.substring(indexMax, indexMax+2));
                }
                if ((max - min) > best) {
                    best = max - min;
                    res = s;
                }
            }
            System.out.println("Result with best difference: "+best);
            System.out.println(lineList.getFirst());
            System.out.println(res);
        }
    }
    private int indexOfMax() {
        if (type == FileType.FOOTBALL) {
            return lineList.getFirst().indexOf("F");
        } else if (type == FileType.WEATHER) {
            return lineList.getFirst().indexOf("xT");
        } else {
            return 0;
        }
    }
    private int indexOfMin() {
        if (type == FileType.FOOTBALL) {
            return lineList.getFirst().indexOf("A");
        } else if (type == FileType.WEATHER) {
            return lineList.getFirst().indexOf("nT");
        } else {
            return 0;
        }
    }
    private boolean isCorrect(String line) {
        if (type == FileType.FOOTBALL) {
            return (!line.equals(lineList.getFirst()) && !line.contains("---"));
        } else if (type == FileType.WEATHER) {
            return (!line.equals(lineList.getFirst()) && !line.equals(lineList.get(1)));
        } else {
            return false;
        }
    }
    public void showAll() {
        if (!lineList.isEmpty()) {
            for (String s : lineList) {
                System.out.println(s);
            }
        }
    }
    public enum FileType {
        FOOTBALL, WEATHER;
    }
}
