/**
 * Created by ppk on 27-Dec-15.
 */
public class Football {
    public static String getMinDifference() {
        return Common.rowIdWithSmallestDifference(
                Common.parse("football.dat", 9), 1, 6, 8);
    }
}
