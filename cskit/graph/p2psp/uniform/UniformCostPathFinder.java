package cskit.graph.p2psp.uniform;

import java.util.List;
import cskit.graph.DirectedGraphNode;

public interface UniformCostPathFinder {
    public List<DirectedGraphNode> find(DirectedGraphNode source,
                                        DirectedGraphNode target);
}
