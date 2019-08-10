import com.info6205.Core.Layer;
import junit.framework.TestCase;

public class LayerTest extends TestCase {

    public void testInitWeights() {

        Layer layer = new Layer(4,2);
        for(int i =0 ;i< layer.getWeights().length;i++){
            assertNotNull(layer.getWeights()[i]);
        }
    }

    public void testRun1() {
        Layer layer = new Layer(4,2);
        Layer layer_1 = new Layer(10,5);
        double[] arraay = {1,0,1,0};
        double[] array_1 = {0,0,0,1,0,1,0,1,0,1};

        assertEquals(2,layer.run(arraay).length);
        assertEquals(5,layer_1.run(array_1).length);
    }

    public void testTrain() {
    }
}