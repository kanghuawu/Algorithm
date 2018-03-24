package org.khwu._636_exclusive_time_of_functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LE636ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int nL = logs.size();
        Deque<Integer> fun = new ArrayDeque<>();
        int prev = 0;
        for (int i = 0; i < nL; i++) {
            String[] split = logs.get(i).split(":");
            int idx = Integer.parseInt(split[2]);
            int f = Integer.parseInt(split[0]);
            if (split[1].equals("start")) {
                if (!fun.isEmpty()) {
                    res[fun.peekLast()] += idx - prev;
                }
                fun.addLast(f);
                prev = idx;
            } else {
                res[fun.removeLast()] += idx - prev + 1;
                prev = idx + 1;
            }
        }
        return res;
    }
}
