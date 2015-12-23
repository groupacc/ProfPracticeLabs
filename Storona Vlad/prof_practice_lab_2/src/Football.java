/**
 * Created by franky_str on 22.12.15.
 */
public class Football {

    private static final String FOOTBALL_FILE = "/home/franky_str/prof_practice_lab_2/football.dat";

    public static String minGoalsDifference() {
        return Common.minDifference(Common.readFile(FOOTBALL_FILE), 1);
    }
}
