import org.junit.Test;
import static junit.framework.Assert.assertEquals;


public class StringCalculatorTest {
    int tryAdd(String string) {
        try {
            return new StringCalculator().add(string);
        }
        catch (NegativeNotAllowedException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Test
    public void addTestEmptyString() {
        assertEquals(0, tryAdd(""));
    }

    @Test
    public void addTestNumbers() {
        assertEquals(1, tryAdd("1"));
        assertEquals(3, tryAdd("1,2"));
        assertEquals(30, tryAdd("6,7,8,9"));
    }

    @Test
    public void addTestDelimiters() {
        assertEquals(1005, tryAdd("//[,,]\n1000,,2,,3"));
        assertEquals(9, tryAdd("//[_]\n2_3_4"));
    }

    @Test
    public void addTestNewLines() {
        assertEquals(15, tryAdd("1,2\n3\n4,5"));
    }

    // it can pass this test becasue tryAdd() handles it already.
    @Test(expected = NegativeNotAllowedException.class)
    public void addTestNegatives() {
        tryAdd("10,20,100,20,40,-50");
    }


}