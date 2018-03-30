package cskit.graph.mst;

import java.util.List;
import cskit.Utilities.Pair;
import cskit.graph.UndirectedGraphEdge;
import cskit.graph.UndirectedGraphNode;
import cskit.graph.DirectedGraphWeightFunction;
import cskit.graph.UndirectedGraphWeightFunction;

public abstract class MinimumSpanningTreeFinder {

    public abstract Pair<List<UndirectedGraphEdge>, Double>
            find(List<UndirectedGraphNode> graph,
                 UndirectedGraphWeightFunction w);
}
