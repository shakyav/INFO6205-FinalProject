import com.info6205.Constants.Function_Transfer;
import junit.framework.TestCase;

public class FunctionTransferTest extends TestCase {

    public void testSigmoid() {
        float x = 100;
        Function_Transfer func = new Function_Transfer();

        assertEquals(1.0,func.function_sigmoid(x));
    }

    public void testDSigmoid() {
        float x = 100;
        Function_Transfer func = new Function_Transfer();

        assertEquals(-9900.0,func.dSigmoid(x));

    }
}