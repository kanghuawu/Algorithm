package org.khwu._310_minimum_height_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LE310FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for (int[] pair : edges) {
            int v = pair[0];
            int w = pair[1];
            graph[v].add(w);
            graph[w].add(v);
            degree[v]++;
            degree[w]++;
        }

        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.addLast(i);
        }
        boolean[] visited = new boolean[n];
        int remain = n;
        while (remain > 2) {
            remain -= q.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int v : q) {
                visited[v] = true;
                for (int w : graph[v]) {
                    if (!visited[w]) {
                        degree[w]--;
                        if (degree[w] == 1) tmp.addLast(w);
                    }
                }
            }
            q = tmp;
        }

        return q;
    }
}
