package org.khwu._218_skyline;

import java.util.*;

public class LE218GetSkyline {

    public List<int[]> getSkyline(int[][] bds) {
        int n = bds.length;
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < n ; i++) {
            map.computeIfAbsent(bds[i][0], v -> new ArrayList<>()).add(bds[i]);
            map.computeIfAbsent(bds[i][1], v -> new ArrayList<>()).add(bds[i]);
        }

        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        for (Map.Entry<Integer, List<int[]>> en : map.entrySet()) {
            int k = en.getKey();
            List<int[]> v = en.getValue();

            for (int[] pt : v) {
                if (pt[0] == k) pq.add(pt);
                else pq.remove(pt);
            }

            if (pq.isEmpty()) {
                res.add(new int[]{k, 0});
            } else {
                int h = pq.peek()[2];
                if (res.isEmpty() || res.get(res.size() - 1)[1] != h) {
                    res.add(new int[]{k, h});
                }
            }
        }
        return res;
    }
}
