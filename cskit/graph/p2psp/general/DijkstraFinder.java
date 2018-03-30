package cskit.graph.p2psp.general;

import java.util.List;
import static cskit.Utilities.tracebackPath;
import cskit.ds.pq.PriorityQueue;
import cskit.graph.DirectedGraphNode;
import cskit.graph.DirectedGraphWeightFunction;


public class DijkstraFinder extends GeneralPathFinder {

    public DijkstraFinder(PriorityQueue<DirectedGraphNode, Double> OPEN) {
        super(OPEN);
    }

    @Override
    public List<DirectedGraphNode> find(DirectedGraphNode source,
                                        DirectedGraphNode target,
                                        DirectedGraphWeightFunction w) {
        OPEN.clear();
        CLOSED.clear();
        GSCORE_MAP.clear();
        PARENT_MAP.clear();

        OPEN.insert(source, 0.0);
        PARENT_MAP.put(source, null);
        GSCORE_MAP.put(source, 0.0);

        while (OPEN.isEmpty() == false) {
            DirectedGraphNode current = OPEN.extractMinimum();

            if (current.equals(target)) {
                return tracebackPath(current, PARENT_MAP);
            }

            CLOSED.add(current);

            for (DirectedGraphNode child : current) {
                if (CLOSED.contains(child)) {
                    continue;
                }

                double tmpg = GSCORE_MAP.get(current) + w.get(current, child);

                if (PARENT_MAP.containsKey(child) == false) {
                    OPEN.insert(child, tmpg);
                    PARENT_MAP.put(child, current);
                    GSCORE_MAP.put(child, tmpg);
                } else if (tmpg < GSCORE_MAP.get(child)) {
                    OPEN.decreasePriority(child, tmpg);
                    PARENT_MAP.put(child, current);
                    GSCORE_MAP.put(child, tmpg);
                }
            }
        }

        return java.util.Collections.<DirectedGraphNode>emptyList();
    }
}
