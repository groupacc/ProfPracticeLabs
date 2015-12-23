/**
 * Created by Nostalex on 22.12.2015.
 */
import Football.*;
import Common.*;
import Weather.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Old code execution:");
        Old();
        System.out.println("\n\n New Code execution:");
        New();
    }

    public static void New() {
        GroupLoader monthLoader = new MonthLoader();
        GroupLoader seasonFCLoader = new SeasonLoader();

        Group month = new Group();
        Group season = new Group();

        try {
            // Temperature
            monthLoader.load(month);

            System.out.println("Smallest temperature spread:");
            GroupPrinter groupPrinter = new SmallerGroup();
            groupPrinter.print(month);

            // Football clubs
            seasonFCLoader.load(season);

            System.out.println("Smallest scores spread:");
            groupPrinter.print(season);
        }
        catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void Old() {
        MonthLoader monthLoader = new MonthLoader();
        SeasonLoader seasonFCLoader = new SeasonLoader();

        MonthWeather month = new MonthWeather();
        SeasonInfo season = new SeasonInfo();

        try {
            // Temperature
            monthLoader.load(month);

            System.out.println("Smallest temperature spread:");
            SmallMonth monthPrinter = new SmallMonth();
            monthPrinter.print(month);

            // Football clubs
            seasonFCLoader.load(season);

            System.out.println("\nSmallest scores spread:");
            SmallSeason clubPrinter = new SmallSeason();
            clubPrinter.print(season);
        }
        catch(IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Exception caught " + e.getMessage());
        }
    }
}
