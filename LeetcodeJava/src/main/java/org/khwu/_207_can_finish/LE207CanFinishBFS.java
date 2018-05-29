package org.khwu._207_can_finish;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LE207CanFinishBFS {
    // MY 2018-05-28
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] pair : prerequisites) {
            int toTake = pair[1];
            int pre = pair[0];
            degree[toTake]++;
            graph[pre].add(toTake);
        }

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) q.addLast(i);
        }

        while (!q.isEmpty()) {
            int v = q.removeFirst();
            ArrayList<Integer> arr = graph[v];
            for (int w : arr) {
                degree[w]--;
                if (degree[w] == 0) q.addLast(w);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] != 0) return false;
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
}
