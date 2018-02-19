package org.khwu._210_find_order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LE210FindOrderBFS {
    // MY ref: https://leetcode.com/problems/course-schedule-ii/discuss/59317/
    // Kahn's algorithm
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] inbound = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
            inbound[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inbound[i] == 0) q.offer(i);
        }
        // System.out.println(q);
        int[] order = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int pre = q.poll();
            order[idx++] = pre;
            for (int to : graph[pre]) {
                inbound[to]--;
                // System.out.println(Arrays.toString(inbound));
                if (inbound[to] == 0) q.offer(to);
            }
        }
        // System.out.println(idx);
        if (idx == numCourses) return order;
        return new int[0];
    }
}
