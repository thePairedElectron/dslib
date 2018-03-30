package cskit.graph.p2psp.general;

import cskit.graph.DirectedGraphNode;

public class ChebyshevMetric<W extends Comparable<? super W>> extends HeuristicFunction {

    private double[] p;

    public ChebyshevMetric(CoordinateMap map, DirectedGraphNode target) {
        super(map, target);
        this.p = map.get(target);
    }

    @Override
    public void setTarget(DirectedGraphNode u) {
        this.target = u;
        this.p = map.get(u);
    }

    @Override
    public double get(DirectedGraphNode u) {
        double[] q = map.get(u);
        double max = Double.MIN_VALUE;

        for (int i = 0; i < q.length; ++i) {
            double tmp = Math.abs(p[i] - q[i]);

            if (max < tmp) {
                max = tmp;
            }
        }

        return max;
    }

    @Override
    public double get(double[] p, double[] q) {
        double max = Double.MIN_VALUE;

        for (int i = 0; i < q.length; ++i) {
            double tmp = Math.abs(p[i] - q[i]);

            if (max < tmp) {
                max = tmp;
            }
        }

        return max;
    }
}
