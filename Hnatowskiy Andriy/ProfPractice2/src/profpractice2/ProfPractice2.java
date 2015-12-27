/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profpractice2;

/**
 *
 * @author Andrew
 */
public class ProfPractice2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileManager fileManager = new FileManager();

        WeatherManager weather = new WeatherManager();
        FootballManager football = new FootballManager();

        System.out.println(weather.manageFile(fileManager.readFromFile("weather.dat")));
        System.out.println(football.manageFile(fileManager.readFromFile("football.dat")));
    }
    
}
