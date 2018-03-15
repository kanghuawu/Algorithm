package org.khwu._149_max_points_on_a_line;

import java.util.HashMap;
import java.util.Map;

public class LE149MaxPoints {
    static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public int maxPoints(Point[] pts) {
        if (pts == null) return 0;
        int n = pts.length;
        if (n <= 2) return n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sPt = 0;
            int loc = 0;
            Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                Point p1 = pts[i];
                Point p2 = pts[j];
                int dy = p1.y - p2.y;
                int dx = p1.x - p2.x;
                if (dy == 0 && dx == 0) {
                    sPt++;
                    continue;
                } else if (dx == 0) {
                    dy = 1;
                }

                int gcd = gcd(dy, dx);

                if (gcd != 0) {
                    dy /= gcd;
                    dx /= gcd;
                }

                Map<Integer, Integer> tmp = m.computeIfAbsent(dx, v -> new HashMap<>());
                int cur = tmp.getOrDefault(dy, 0) + 1;
                tmp.put(dy, cur);
                loc = Math.max(loc, cur);
            }
            res = Math.max(res, loc + sPt + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a == 0 || b == 0) return a + b;
        else return gcd(b, a  % b);
    }
}
