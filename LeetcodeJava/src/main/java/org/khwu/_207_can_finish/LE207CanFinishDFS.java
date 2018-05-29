package org.khwu._207_can_finish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LE207CanFinishDFS {

    // MY 2018-05-28
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int[] pair : prerequisites) {
            int toTake = pair[0];
            int pre = pair[1];
            graph[pre].add(toTake);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, onStack)) return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<Integer>[] graph, int idx, boolean[] visited, boolean[] onStack) {
        onStack[idx] = true;
        visited[idx] = true;
        for (int next : graph[idx]) {
            if (onStack[next]) return true;
            else if (!visited[next]) {
                if (hasCycle(graph, next, visited, onStack)) return true;
            }
        }
        onStack[idx] = false;
        return false;
    }

    // MY 2017-12-26
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
//                if (!dfs(i, visited, onStack, graph)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private boolean dfs(int currIdx, boolean[] visited, boolean[] onStack, Map<Integer, List<Integer>> graph) {
//        visited[currIdx] = true;
//
//        List<Integer> nb = graph.get(currIdx);
//        onStack[currIdx] = true;
//
//        if (nb != null) {
//            for (int nxt : nb) {
//                if (onStack[nxt]) {
//                    return false;
//                }
//                if (!visited[nxt]) {
//                    if (!dfs(nxt, visited, onStack, graph)) {
//                        return false;
//                    }
//                }
//            }
//        }
//        onStack[currIdx] = false;
//        return true;
//    }

    // DFS ref: https://discuss.leetcode.com/topic/15762/java-dfs-and-bfs-solution
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        ArrayList[] graph = new ArrayList[numCourses];
//        for (int i = 0; i < numCourses; i++)
//            graph[i] = new ArrayList();
//
//        boolean[] visited = new boolean[numCourses];
//        for (int i = 0; i < prerequisites.length; i++) {
//            graph[prerequisites[i][1]].add(prerequisites[i][0]);
//        }
//
//        for (int i = 0; i < numCourses; i++) {
//            if (!dfs(graph, visited, i))
//                return false;
//        }
//        return true;
//    }
//
//    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
//        if (visited[course])
//            return false;
//        else
//            visited[course] = true;
//        ;
//
//        for (int i = 0; i < graph[course].size(); i++) {
//            if (!dfs(graph, visited, (int) graph[course].get(i)))
//                return false;
//        }
//        visited[course] = false;
//        return true;
//    }
}
