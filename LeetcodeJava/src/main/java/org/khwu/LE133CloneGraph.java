package org.khwu;

import org.khwu.utility.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Stack;

public class LE133CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        Stack<UndirectedGraphNode> s = new Stack();
        s.add(node);
        while (!s.isEmpty()) {
            UndirectedGraphNode ori = s.pop();

            if (!map.containsKey(ori)) {
                map.put(ori, new UndirectedGraphNode(ori.label));
            }
            UndirectedGraphNode copy = map.get(ori);
            for (UndirectedGraphNode nb : ori.neighbors) {
                if (!map.containsKey(nb)) {
                    map.put(nb, new UndirectedGraphNode(nb.label));
                    s.add(nb);
                }
                copy.neighbors.add(map.get(nb));
            }
        }
        return map.get(node);
    }
}
