/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profpractice2;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */


public class WeatherManager {
	public String manageFile(ArrayList<ArrayList<String>> data) {
        String dayNumber = "";
        double minimum = Double.MAX_VALUE;
        for(ArrayList<String> list : data) {
            if(list.size() != 0){
                double temp = Math.abs(Double.parseDouble(list.get(2).replaceAll("\\D+", "")) -
                        Double.parseDouble(list.get(1).replaceAll("\\D+", "")));
                if(temp < minimum) {
                    minimum = temp;
                    dayNumber = list.get(0);
                }
            }
        }
        return dayNumber;
    }
}

