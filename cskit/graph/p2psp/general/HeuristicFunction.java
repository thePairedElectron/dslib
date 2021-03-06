package cskit.graph.p2psp.general;

import cskit.graph.DirectedGraphNode;

public abstract class HeuristicFunction {

    protected CoordinateMap map;
    protected DirectedGraphNode target;

    public HeuristicFunction(CoordinateMap map, DirectedGraphNode target) {
        this.map = map;
        this.target = target;
    }

    public void setTarget(DirectedGraphNode target) {
        this.target = target;
    }

    public CoordinateMap getCoordinateMap() {
        return map;
    }

    public void setCoordinateMap(CoordinateMap map) {
        this.map = map;
    }

    /**
     * Gets an (optimistic) estimate for the distance from <code>u</code> to
     * pre-specified target node.
     *
     * @param u the node to estimate.
     */
    public abstract double get(DirectedGraphNode u);

    /**
     * Gets an estimate from <code>from</code> to <code>to</code>.
     *
     * @param from the start node.
     * @param to the goal node.
     * @return an estimate between the two nodes.
     */
    public abstract double get(double[] p, double[] q);
}
