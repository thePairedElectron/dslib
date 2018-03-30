package cskit.graph.p2psp.general;

import cskit.graph.DirectedGraphNode;


public class ManhattanMetric extends HeuristicFunction {

    private double[] p;

    public ManhattanMetric(CoordinateMap map, DirectedGraphNode target) {
        super(map, target);
        this.p = map.get(target);
    }

    @Override
    public double get(DirectedGraphNode u) {
        double[] q = map.get(u);
        double sum = 0.0;

        for (int i = 0; i < q.length; ++i) {
            sum += Math.abs(p[i] - q[i]);
        }

        return sum;
    }

    @Override
    public void setTarget(DirectedGraphNode u) {
        this.p = map.get(u);
        this.target = u;
    }

    @Override
    public double get(double[] p, double[] q) {
        double sum = 0.0;

        for (int i = 0; i < q.length; ++i) {
            sum += Math.abs(p[i] - q[i]);
        }

        return sum;
    }
}
