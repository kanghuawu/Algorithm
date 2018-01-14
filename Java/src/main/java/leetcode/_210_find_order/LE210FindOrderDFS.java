package leetcode._210_find_order;

import java.util.*;

public class LE210FindOrderDFS {

    // MY 2017-1-12
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] course : prerequisites) {
            int pre = course[1];
            int ready = course[0];
            List<Integer> li = graph.get(pre);
            if (li == null) {
                li =  new ArrayList<>();
                graph.put(pre, li);
            }
            li.add(ready);
        }
        for (int pre = 0; pre < numCourses; pre++) {
            if (!visited[pre]) {
                if (hasCycle(pre, visited, onStack, stack, graph)) return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean hasCycle(int pre, boolean[] visited, boolean[] onStack, Stack<Integer> stack, Map<Integer, List<Integer>> graph) {
        visited[pre] = true;
        onStack[pre] = true;

        List<Integer> nbs = graph.get(pre);
        if (nbs != null) {
            for (int nb : nbs) {
                if (onStack[nb]) return true;
                if (visited[nb]) continue;
                if (hasCycle(nb, visited, onStack, stack, graph)) return true;
            }
        }

        stack.push(pre);
        onStack[pre] = false;
        return false;
    }

//    private int counter;
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        counter = numCourses - 1;
//        int[] stack = new int[numCourses];
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//        for (int i = 0; i < prerequisites.length; i++) {
//            int cls = prerequisites[i][1];
//            int nxt = prerequisites[i][0];
//            List<Integer> nb = graph.get(cls);
//            if (nb == null) {
//                nb = new ArrayList<>();
//                graph.put(cls, nb);
//            }
//            nb.add(nxt);
//        }
//
//        boolean[] visited = new boolean[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            boolean[] onStack = new boolean[numCourses];
//            if (!visited[i]) {
//                if (!dfs(i, visited, onStack, graph, stack)) {
//                    return new int[0];
//                }
//            }
//        }
//        return stack;
//    }
//
//    private boolean dfs(int currIdx, boolean[] visited, boolean[] onStack, Map<Integer, List<Integer>> graph, int[] stack) {
//        visited[currIdx] = true;
//        onStack[currIdx] = true;
//
//        List<Integer> nb = graph.get(currIdx);
//        if (nb != null) {
//            for (int nxt : nb) {
//                if (onStack[nxt]) {
//                    return false;
//                }
//                if (!visited[nxt]) {
//                    if (!dfs(nxt, visited, onStack, graph, stack)) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        stack[counter--] = currIdx;
//        onStack[currIdx] = false;
//        return true;
//    }
}
