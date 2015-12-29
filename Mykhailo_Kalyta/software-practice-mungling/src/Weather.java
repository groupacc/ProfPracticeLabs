/**
 * Created by ppk on 27-Dec-15.
 */
public class Weather {
    public static String getMinDifference() {
        return Common.rowIdWithSmallestDifference(
                Common.parse("weather.dat", 3), 0, 1, 2);
    }
}
