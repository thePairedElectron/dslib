package cskit.graph.p2psp.general;

import java.util.HashMap;
import java.util.Map;
import cskit.graph.DirectedGraphNode;


public class CoordinateMap {

    private Map<DirectedGraphNode, double[]> map;
    private final int dimensions;

    public CoordinateMap(int dimensions, int initialCapacity) {
        this.dimensions = dimensions;
        map = new HashMap<DirectedGraphNode, double[]>(initialCapacity, 1.05f);
    }

    public CoordinateMap(int dimensions) {
        this.dimensions = dimensions;
        map = new HashMap<DirectedGraphNode, double[]>();
    }

    public void put(DirectedGraphNode node, double[] vector) {
        checkDimensions(vector);
        map.put(node, vector);
    }

    public double[] get(DirectedGraphNode node) {
        return map.get(node);
    }

    private void checkDimensions(double[] vector) {
        if (vector.length != dimensions) {
            throw new IllegalArgumentException("Wrong amount of dimensions: " +
                    "required " + dimensions + ", recieved " + vector.length);
        }
    }
}
