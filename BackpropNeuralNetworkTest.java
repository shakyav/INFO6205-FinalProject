import com.info6205.Core.BackpropNeuralNetwork;
import junit.framework.TestCase;
import com.info6205.Core.Layer;
public class BackpropNeuralNetworkTest extends TestCase {

    public void testGetLayer() {
        BackpropNeuralNetwork bpnn = new BackpropNeuralNetwork(10,5,5,2);

        assertEquals(10,bpnn.getLayer(0).getInput().length-1);
        assertEquals(5,bpnn.getLayer(0).getOutput().length);
        assertEquals(5,bpnn.getLayer(1).getInput().length-1);
        assertEquals(5,bpnn.getLayer(1).getOutput().length);
        assertEquals(5,bpnn.getLayer(2).getInput().length-1);
        assertEquals(2,bpnn.getLayer(2).getOutput().length);
    }

    public void testRun1() {

        BackpropNeuralNetwork bpnn = new BackpropNeuralNetwork(10,5,5,2);
        double[] array_1 = {0,0,0,1,0,1,0,1,0,1};

        assertEquals(2,bpnn.run(array_1).length);
    }

    public void testTrain() {


    }
}