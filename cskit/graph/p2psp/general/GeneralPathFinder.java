package cskit.graph.p2psp.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import cskit.ds.pq.PriorityQueue;
import cskit.graph.DirectedGraphNode;
import cskit.graph.DirectedGraphWeightFunction;


public abstract class GeneralPathFinder {

    protected PriorityQueue<DirectedGraphNode, Double> OPEN;
    protected Set<DirectedGraphNode> CLOSED;
    protected Map<DirectedGraphNode, Double> GSCORE_MAP;
    protected Map<DirectedGraphNode, DirectedGraphNode> PARENT_MAP;
    protected DirectedGraphNode source;
    protected DirectedGraphNode target;

    public GeneralPathFinder(PriorityQueue<DirectedGraphNode, Double> OPEN) {
        this.OPEN = OPEN;
        this.CLOSED = new HashSet<DirectedGraphNode>();
        this.GSCORE_MAP = new HashMap<DirectedGraphNode, Double>();
        this.PARENT_MAP = new HashMap<DirectedGraphNode, DirectedGraphNode>();
    }

    public abstract List<DirectedGraphNode> find(DirectedGraphNode source,
                                                 DirectedGraphNode target,
                                                 DirectedGraphWeightFunction w);
}
