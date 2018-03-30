package cskit.graph.p2psp.uniform;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cskit.Utilities.tracebackPath;

import cskit.graph.DirectedGraphNode;

public class BreadthFirstSearchFinder implements UniformCostPathFinder {

    private final Map<DirectedGraphNode, DirectedGraphNode> parentMap =
          new HashMap<DirectedGraphNode, DirectedGraphNode>();

    @Override
    public List<DirectedGraphNode> find(DirectedGraphNode source,
                                        DirectedGraphNode target) {
        parentMap.clear();
        
        Deque<DirectedGraphNode> Q = new LinkedList<DirectedGraphNode>();

        Q.addLast(source);
        parentMap.put(source, null);

        while (Q.isEmpty() == false) {
            DirectedGraphNode current = Q.removeFirst();

            if (current.equals(target)) {
                return tracebackPath(target, parentMap);
            }

            for (DirectedGraphNode child : current) {
                if (parentMap.containsKey(child) == false) {
                    Q.addLast(child);
                    parentMap.put(child, current);
                }
            }
        }

        // No path found.
        return java.util.Collections.<DirectedGraphNode>emptyList();
    }

}
