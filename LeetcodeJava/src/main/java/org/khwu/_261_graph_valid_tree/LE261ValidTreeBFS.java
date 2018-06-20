package org.khwu._261_graph_valid_tree;

import java.util.*;

public class LE261ValidTreeBFS {
    public boolean validTree(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new HashSet<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> q = new LinkedList<>();
        q.addLast(0);
        while (!q.isEmpty()) {
            int from = q.removeFirst();
            if (visited[from]) return false;
            visited[from] = true;
            for (int to : graph.get(from)) {
                q.addLast(to);
                graph.get(to).remove(from);
            }
        }

        for (int i = 0; i < n; i++)
            if (!visited[i]) return false;

        return true;
    }
}
