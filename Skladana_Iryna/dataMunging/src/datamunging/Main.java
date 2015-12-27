/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamunging;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author iryna
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // Part One: Weather Data
        File file1 = new File
            ("D:\\Projects\\Java\\University\\dataMunging\\Weather.dat");
        
        File file2 = new File
            ("D:\\Projects\\Java\\University\\dataMunging\\Football.dat");
       
        DataMunging dm1 = new DataMunging(file1);
        dm1.smallestTemperatureSpreadDay();
        DataMunging dm2 = new DataMunging(file2);
        dm2.smallestGoalDifferenceTeam();
    }
}
