package org.khwu._261_graph_valid_tree;

import java.util.ArrayList;
import java.util.List;

public class LE261ValidTreeDFS {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        boolean[] visited = new boolean[n];
        boolean[] onStack = new boolean[n];

        if (hasCycle(-1, 0, graph, visited, onStack)) return false;

        for (int i = 0; i < n; i++) if (!visited[i]) return false;
        return true;
    }

    private boolean hasCycle(int prev, int nxt, List[] graph, boolean[] visited, boolean[] onStack) {
        onStack[nxt] = true;
        visited[nxt] = true;

        List<Integer> li = graph[nxt];
        for (int nb : li) {
            if (nb == prev) continue;
            if (onStack[nb]) return true;
            if (visited[nb]) continue;

            if (hasCycle(nxt, nb, graph, visited, onStack)) return true;
        }

        onStack[nxt] = false;
        return false;
    }
}
