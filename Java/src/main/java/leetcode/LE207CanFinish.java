package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LE207CanFinish {
    // MY Time Limite Exceeded
    public static class Graph {
        private final int N;
        private final List<Integer>[] cl;

        public Graph(int num) {
            N = num;
            cl = (ArrayList<Integer>[]) new ArrayList[num];
            for (int i = 0; i < num; i++) {
                cl[i] = new ArrayList();
            }
        }

        public void addEdge(int pre, int take) {
            cl[pre].add(take);
        }

        public Iterable<Integer> adj(int v) {
            return cl[v];
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            g.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            Queue<Integer> q = new LinkedList();
            boolean[] visited = new boolean[numCourses];
            q.add(i);
            while (!q.isEmpty()) {
                int pre = q.remove();
                visited[pre] = true;
                for (int c : g.adj(pre)) {
                    if (!visited[c]) {
                        q.add(c);
                    } else if (i == c) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // BFS ref: https://discuss.leetcode.com/topic/15762/java-dfs-and-bfs-solution
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        ArrayList[] graph = new ArrayList[numCourses];
//        int[] degree = new int[numCourses];
//        Queue queue = new LinkedList();
//        int count = 0;
//
//        for (int i = 0; i < numCourses; i++)
//            graph[i] = new ArrayList();
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            degree[prerequisites[i][1]]++;
//            graph[prerequisites[i][0]].add(prerequisites[i][1]);
//        }
//        for (int i = 0; i < degree.length; i++) {
//            if (degree[i] == 0) {
//                queue.add(i);
//                count++;
//            }
//        }
//
//        while (queue.size() != 0) {
//            int course = (int) queue.poll();
//            for (int i = 0; i < graph[course].size(); i++) {
//                int pointer = (int) graph[course].get(i);
//                degree[pointer]--;
//                if (degree[pointer] == 0) {
//                    queue.add(pointer);
//                    count++;
//                }
//            }
//        }
//        if (count == numCourses)
//            return true;
//        else
//            return false;
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
