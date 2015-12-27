package major;

import weather.Weather;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataPointComparatorTest {

    @Test
    public void testSameSpreadGivesComparisonOfZero() {
        final WeatherPoint firstPoint = new WeatherPoint(0, 5, 10);
        final WeatherPoint secondPoint = new WeatherPoint(0, 105, 110);
        Assert.assertEquals(0, new DataPointComparator().compare(firstPoint, secondPoint));
    }

    @Test
    public void testLesserSpreadGivesComparisonOfLessThanZero() {
        final WeatherPoint firstPoint = new WeatherPoint(0, 5, 10); // spread of 5
        final WeatherPoint secondPoint = new WeatherPoint(0, 5, 11); // spread of 6
        assertEquals(-1, new DataPointComparator().compare(firstPoint, secondPoint));
    }

    @Test
    public void testGreaterSpreadGivesComparisonOfMoreThanZero() {
        final WeatherPoint firstPoint = new WeatherPoint(0, 5, 11); // spread of 6
        final WeatherPoint secondPoint = new WeatherPoint(0, 5, 10); // spread of 5
        assertEquals(1, new DataPointComparator().compare(firstPoint, secondPoint));
    }


}
