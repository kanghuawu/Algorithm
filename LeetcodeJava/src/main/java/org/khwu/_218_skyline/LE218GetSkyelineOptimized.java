package org.khwu._218_skyline;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LE218GetSkyelineOptimized {
    /*
    ref: https://leetcode.com/problems/the-skyline-problem/discuss/61194/108-ms-17-lines-body-explained
     */
    public List<int[]> getSkyline(int[][] bds) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = bds.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);
        while (i < n || !pq.isEmpty()) {
            int x;
            if (pq.isEmpty() || (i < n && bds[i][0] <= pq.peek()[1])) {
                x = bds[i][0];
                while (i < n && bds[i][0] == x) {
                    pq.offer(new int[]{bds[i][2], bds[i][1]});
                    i++;
                }
            } else {
                x = pq.peek()[1];
                while (!pq.isEmpty() && pq.peek()[1] <= x) {
                    pq.poll();
                }
            }
            int h = 0;
            if (!pq.isEmpty()) h = pq.peek()[0];
            if (res.isEmpty() || res.get(res.size() - 1)[1] != h) {
                res.add(new int[]{x, h});
            }
        }
        return res;
    }
}
