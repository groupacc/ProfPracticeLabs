import static org.junit.Assert.assertEquals;

public class Testing {
    public void bigValues() {
        Calculate c = new Calculate();
        assertEquals(1000, c.calc("[[[[\\]]]]1;#$%1001;**;\n0;999"));
    }

    public void splitLines() {
        Calculate c = new Calculate();
        assertEquals(26, c.calc("1;\\***;*****;*\n22;**********;3"));
    }

    public void zeroTest() {
        Calculate c = new Calculate();
        assertEquals(0, c.calc(" "));
    }

    public void oneNumber() {
        Calculate c = new Calculate();
        assertEquals(3, c.calc("3"));
    }

    public void twoNumbers() {
        Calculate c = new Calculate();
        assertEquals(3, c.calc("1,2"));
    }

    public void threeNumbers() {
        Calculate c = new Calculate();
        assertEquals(8, c.calc("1,4,3"));
    }
}