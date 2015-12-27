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


public class FootballManager {
	public String manageFile(ArrayList<ArrayList<String>> data) {
        String name = "";
        int min = Integer.MAX_VALUE;
        data.remove(17);
        for(ArrayList<String> list : data) {
            if(!list.isEmpty()) {
                int temp = Math.abs(Integer.parseInt(list.get(8).replaceAll("\\D+", "")) -
                        Integer.parseInt(list.get(6).replaceAll("\\D+", "")));
                if(temp < min) {
                    min = temp;
                    name = list.get(1);
                }
            }
        }

        return name;
    }
}

