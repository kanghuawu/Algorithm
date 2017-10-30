package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LE322CountComponents {
    // Graph + DFS
//    public int countComponents(int n, int[][] edges) {
//        Map<Integer, List<Integer>> graph = new HashMap();
//
//        for (int i = 0; i < edges.length; i++) {
//            for (int j = 0; j < 2; j++) {
//                int k = edges[i][j];
//                int v = edges[i][(j+1)%2];
//                List<Integer> l = graph.get(k);
//                if (l == null) {
//                    graph.put(k, new ArrayList());
//                    l = graph.get(k);
//                }
//                l.add(v);
//            }
//        }
//        //System.out.println(graph);
//        int[] id = new int[n];
//        int count = 1;
//        for (int key = 0; key < id.length; key++) {
//            if (id[key] == 0) {
//                count = dfs(graph, id, count, key);
//            }
//        }
//
//        return count - 1;
//    }
//
//    private int dfs(Map<Integer, List<Integer>> graph, int[] id, int count, int key) {
//        if (id[key] == 0 && graph.get(key) != null) {
//            id[key] = count;
//            for (int nxtKey : graph.get(key)) {
//                dfs(graph, id, count, nxtKey);
//            }
//        }
//        return count + 1;
//    }

    // Union find
    // ref: https://discuss.leetcode.com/topic/32752/easiest-2ms-java-solution
    public int countComponents(int n, int[][] edges) {
        int[] id = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }

        int count = n;
        for (int i = 0; i < edges.length; i++) {
            int node1 = root(edges[i][0], id);
            int node2 = root(edges[i][1], id);
            if (node1 == node2) {
                continue;
            } else {
                if (size[node1] < size[node2]) {
                    id[node1] = node2;
                    size[node2] += size[node1];
                } else {
                    id[node2] = node1;
                    size[node1] += size[node2];
                }
                count--;
            }
            //System.out.println(Arrays.toString(id));
            //System.out.println(Arrays.toString(size));
        }
        // System.out.println(Arrays.toString(id));
        // System.out.println(Arrays.toString(size));
        return count;
    }

    private int root(int i, int[] id) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}
