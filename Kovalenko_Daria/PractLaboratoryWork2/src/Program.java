public class Program {

    public static void main(String[]args) {

        FileProcessor fP = new FileProcessor();
        WeatherFileProcessor w = new WeatherFileProcessor();
        FootballFileProcessor f = new FootballFileProcessor();

        System.out.println(f.processFile(fP.readFromFile("football.dat")));
        System.out.println(w.processFile(fP.readFromFile("weather.dat")));
    }



}
