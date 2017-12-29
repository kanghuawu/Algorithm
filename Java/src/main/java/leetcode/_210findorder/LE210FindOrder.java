package leetcode._210findorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LE210FindOrder {
    private int counter;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        counter = numCourses - 1;
        int[] stack = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int cls = prerequisites[i][1];
            int nxt = prerequisites[i][0];
            List<Integer> nb = graph.get(cls);
            if (nb == null) {
                nb = new ArrayList<>();
                graph.put(cls, nb);
            }
            nb.add(nxt);
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean[] onStack = new boolean[numCourses];
            if (!visited[i]) {
                if (!dfs(i, visited, onStack, graph, stack)) {
                    return new int[0];
                }
            }
        }
        return stack;
    }

    private boolean dfs(int currIdx, boolean[] visited, boolean[] onStack, Map<Integer, List<Integer>> graph, int[] stack) {
        visited[currIdx] = true;
        onStack[currIdx] = true;

        List<Integer> nb = graph.get(currIdx);
        if (nb != null) {
            for (int nxt : nb) {
                if (onStack[nxt]) {
                    return false;
                }
                if (!visited[nxt]) {
                    if (!dfs(nxt, visited, onStack, graph, stack)) {
                        return false;
                    }
                }
            }
        }

        stack[counter--] = currIdx;
        onStack[currIdx] = false;
        return true;
    }
}
