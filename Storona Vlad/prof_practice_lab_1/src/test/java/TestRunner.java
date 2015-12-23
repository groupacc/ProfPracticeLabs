import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by franky_str on 22.12.15.
 */
public class TestRunner {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(TestCalculator.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}