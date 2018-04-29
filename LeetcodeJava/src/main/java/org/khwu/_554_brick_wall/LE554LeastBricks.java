package org.khwu._554_brick_wall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LE554LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int acc = 0;
            List<Integer> li = wall.get(i);
            for (int j = 0; j < li.size() - 1; j++) {
                acc += li.get(j);
                map.put(acc, map.getOrDefault(acc, 0) + 1);
            }
        }
        int res = 0;
        for (int num : map.values()) {
            res = Math.max(num, res);
        }
        return wall.size() - res;
    }
}
