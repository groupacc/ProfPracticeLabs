import org.junit.Assert;
import org.junit.Test;

/**
 * Created by franky_str on 22.12.15.
 */
public class TestCalculator {


    @Test
    public void testSumEmptyString() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(0, calculator.sum(""));
    }

    @Test
    public void testSumOneParameter() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(769, calculator.sum("769"));
    }

    @Test
    public void testSumTwoParameters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(809, calculator.sum("445,364"));
    }

    @Test
    public void testAddNegative() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(7, calculator.sum("-48;7;-785"));
    }

    @Test
    public void testSumTwoParametersWithDelimiters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(795, calculator.sum("784[11"));
    }

    @Test
    public void testSumMoreThanThousand() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(3, calculator.sum("3;1005"));
    }

    @Test
    public void testSumAnyLengthOfDelimiters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(60, calculator.sum("15;******[][]]];/;;45\n[][][]]]*////*\n"));
    }

    @Test
    public void testMultipleDelimiters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(10, calculator.sum("2,;7\n;,1"));
    }

    @Test
    public void testLongMultipleDelimiters() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(14, calculator.sum("4,////2,,,;7\n\n;;;;1"));
    }
}
