/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_lab2;

/**
 *
 * @author pirog
 */
public class Practice_lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        difClasses();
        sameClass();
    }
    public static void difClasses() {
        System.out.println("*************************************************");
        FootballReader FR = new FootballReader();
        FR.read("/Users/pirog/Downloads/football.dat");
        FR.show();
        System.out.println("*************************************************");
        WeatherReader WR = new WeatherReader();
        WR.read("/Users/pirog/Downloads/weather.dat");
        WR.show();
        System.out.println("*************************************************");
    }
    public static void sameClass() {
        System.out.println("*************************************************");
        MyReader FR = new MyReader(MyReader.FileType.FOOTBALL);
        FR.read("/Users/pirog/Downloads/football.dat");
        FR.show();
        System.out.println("*************************************************");
        MyReader WR = new MyReader(MyReader.FileType.WEATHER);
        WR.read("/Users/pirog/Downloads/weather.dat");
        WR.show();
        System.out.println("*************************************************");
    }
}
