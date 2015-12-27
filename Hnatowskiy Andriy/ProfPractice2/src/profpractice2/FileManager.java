/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profpractice2;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Andrew
 */
public class FileManager {
    public ArrayList<ArrayList<String>> readFromFile(String fileName) {

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
            	ArrayList<String> array = new ArrayList<>();

                for (String retval: line.split(" ")){
                    if(!retval.equals("")) {
                        array.add(retval);
                    }
                }

                result.add(array);
                line = br.readLine();
            }
            result.remove(0);

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

        return result;
    }
}
