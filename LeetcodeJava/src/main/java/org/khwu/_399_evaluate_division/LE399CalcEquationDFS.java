package org.khwu._399_evaluate_division;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LE399CalcEquationDFS {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int n = equations.length;
        for (int i = 0; i < n; i++) {
            String s = equations[i][0];
            String e = equations[i][1];
            double v = values[i];
            Map<String, Double> map1 = graph.getOrDefault(s, new HashMap<>());
            map1.put(e, v);
            graph.put(s, map1);
            Map<String, Double> map2 = graph.getOrDefault(e, new HashMap<>());
            map2.put(s, 1.0 / v);
            graph.put(e, map2);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            find(queries[i], i, res, graph);
        }
        return res;
    }

    private void find(String[] query, int idx, double[] res, Map<String, Map<String, Double>> graph) {
        String s = query[0];
        String e = query[1];
        if (!graph.containsKey(s) || !graph.containsKey(e)) {
            res[idx] = -1.0;
            return;
        }
        if (s.equals(e)) {
            res[idx] = 1.0;
            return;
        }
        Set<String> visited = new HashSet<>();
        double num = dfs(s, e, 1.0, graph, visited);
        res[idx] = num != 0.0 ? num : -1.0;
    }

    private double dfs(String s, String e, double num, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (s.equals(e)) return num;
        visited.add(s);
        for (Map.Entry<String, Double> nb : graph.getOrDefault(s, new HashMap<>()).entrySet()) {
            String nxt = nb.getKey();
            if (visited.contains(nxt)) continue;
            double tmp = dfs(nxt, e, nb.getValue(), graph, visited);
            if (tmp != 0.0) return tmp * num;
        }
        visited.remove(s);
        return 0.0;
    }
}
