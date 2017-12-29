package leetcode.LE207CanFinish;

import java.util.*;

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
}
